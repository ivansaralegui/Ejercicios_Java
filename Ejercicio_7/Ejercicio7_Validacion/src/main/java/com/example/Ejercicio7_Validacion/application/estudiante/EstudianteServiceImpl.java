package com.example.Ejercicio7_Validacion.application.estudiante;

import com.example.Ejercicio7_Validacion.classes.Asignatura;
import com.example.Ejercicio7_Validacion.classes.Estudiante;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.repository.AsignaturaRepository;
import com.example.Ejercicio7_Validacion.repository.EstudianteRepository;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import com.example.Ejercicio7_Validacion.repository.ProfesorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private PersonaRepository repositoryPersona;

    @Autowired
    private ProfesorRepository repositoryProfesor;

    @Autowired
    private AsignaturaRepository repositoryAsignatura;

    @Override
    @Valid
    public EstudianteSimpleOutputDTO addEstudiante(EstudianteInputDTO estudiante) throws Exception {
        Optional<Persona> personaOptional = repositoryPersona.findById(estudiante.getId_persona());
        Optional<Profesor> profesorOptional = repositoryProfesor.findById(estudiante.getId_profesor());
        if (personaOptional.isPresent()) {
            if (profesorOptional.isPresent()) {
                for (Profesor p: repositoryProfesor.findAll()) {
                    if (estudiante.getId_persona() == p.getId_persona().getId()) {
                        throw new Exception("ERROR EN ADDESTUDIANTE: Este ID ya es de un profesor");
                    }
                }
                for (Estudiante e: repository.findAll()) {
                    if (estudiante.getId_persona() == e.getId_persona().getId()) {
                        throw new Exception("ERROR EN ADDESTUDIANTE: Este ID ya es de un estudiante");
                    }
                }
                Estudiante e = new Estudiante(estudiante, personaOptional.get(), profesorOptional.get());
                repository.save(e);
                return e.parseEstudianteSimpleOutputDTO(e);
            } else {
                throw new Exception("Error al crear el Profesor");
            }
        } else {
            throw new Exception("Error al crear el Estudiante");
        }
    }

    @Override
    public EstudianteSimpleOutputDTO getEstudianteSimpleById(int id) throws Exception {
        Optional<Estudiante> estudianteOptional = repository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiante e = estudianteOptional.get();
            return e.parseEstudianteSimpleOutputDTO(e);
        } else {
            throw new Exception("No se ha encontrado el estudiante con esa ID");
        }
    }

    @Override
    public EstudianteFullOutputDTO getEstudianteFullById(int id) throws Exception {
        Optional<Estudiante> estudianteOptional = repository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiante e = estudianteOptional.get();
            return e.parseEstudianteFullOutputDTO(e);
        } else {
            throw new Exception("No se ha encontrado el estudiante con esa ID");
        }
    }

    @Override
    public void deleteEstudianteById(int id) throws Exception {
        Optional<Estudiante> estudianteOptional = repository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiante e = estudianteOptional.get();
            repository.delete(e);
        } else {
            throw new Exception("No se ha encontrado el estudiante con esa ID");
        }
    }

    @Override
    public List<EstudianteFullOutputDTO> getAllEstudiantes() throws Exception {
        List<EstudianteFullOutputDTO> lsteoDTO = new ArrayList<EstudianteFullOutputDTO>();
        for (Estudiante e: repository.findAll()) {
            lsteoDTO.add((e.parseEstudianteFullOutputDTO(e)));
        }
        return lsteoDTO;
    }

    @Override
    public EstudianteSimpleOutputDTO updateEstudiante(int id, EstudianteInputDTO estudiante) throws Exception {
        Optional<Estudiante> estudianteOptional = repository.findById(id);
        Optional<Persona> personaOptional = repositoryPersona.findById(estudiante.getId_persona());
        if (personaOptional.isPresent()) {
            if (estudianteOptional.isPresent()) {
                Estudiante e = new Estudiante(estudiante, personaOptional.get(), estudianteOptional.get().getId_profesor());
                e.setId_student(id);
                repository.save(e);
                return e.parseEstudianteSimpleOutputDTO(e);
            } else {
                throw new Exception("No se ha encontrado un estudiante con ese ID");
            }
        } else {
            throw new Exception("No se ha encontrado una persona con ese ID");
        }
    }

    @Override
    public EstudianteFullOutputDTO addAsignatura(int idEstudiante, int idAsignatura) throws Exception {
        Optional<Asignatura> asignaturaOptional = repositoryAsignatura.findById(idAsignatura);
        Optional<Estudiante> estudianteOptional = repository.findById(idEstudiante);
        if (asignaturaOptional.isPresent() && estudianteOptional.isPresent()) {
            Estudiante e = estudianteOptional.get();
            Set<Asignatura> lstAsignatura = new HashSet<Asignatura>();
            lstAsignatura.add(repositoryAsignatura.findById(idAsignatura).get());
            e.setAsignatura(lstAsignatura);
            repository.save(e);
            return e.parseEstudianteFullOutputDTO(e);
        } else {
            throw new Exception("ERROR EN ADDASIGNATURA: No encuentra uno de los IDs");
        }
    }


}
