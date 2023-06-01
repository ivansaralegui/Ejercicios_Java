package com.example.Ejercicio7_Validacion.application.profesor;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import com.example.Ejercicio7_Validacion.repository.EstudianteRepository;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import com.example.Ejercicio7_Validacion.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository repository;

    @Autowired
    private PersonaRepository repositoryPersona;

    @Autowired
    private EstudianteRepository repositoryEstudiante;

    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesor) throws Exception {
        Optional<Persona> personaOptional = repositoryPersona.findById(profesor.getId_persona());

        if (personaOptional.isPresent()) {
            for (Profesor p: repository.findAll()) {
                if (profesor.getId_persona() == p.getId_persona().getId()) {
                    throw new Exception("ERROR EN ADDPROFESOR: Este ID ya es de un profesor");
                }
            }
            for (Estudiante e: repositoryEstudiante.findAll()) {
                if (profesor.getId_persona() == e.getId_persona().getId()) {
                    throw new Exception("ERROR EN ADDPROFESOR: Este ID ya es de un estudiante");
                }
            }

            Profesor newProfesor = new Profesor(profesor, personaOptional.get());
            repository.save(newProfesor);
            return newProfesor.parseProfesorOutputDTO(newProfesor);
        } else {
            throw new Exception("Error al crear el Profesor");
        }
    }

    @Override
    public ProfesorOutputDTO getProfesorById(int id) throws Exception {
        Optional<Profesor> profesorOptional = repository.findById(id);
        if (profesorOptional.isPresent()) {
            Profesor p = profesorOptional.get();
            return p.parseProfesorOutputDTO(p);
        } else {
            throw new Exception("No se ha encontrado el profesor con esa ID");
        }
    }

    @Override
    public void deleteProfesorById(int id) throws Exception {
        Optional<Profesor> profesorOptional = repository.findById(id);
        if (profesorOptional.isPresent()) {
            Profesor p = profesorOptional.get();
            repository.delete(p);
        } else {
            throw new Exception("No se ha encontrado el profesor con esa ID");
        }
    }

    @Override
    public List<ProfesorOutputDTO> getAllProfesores() throws Exception {
        List<ProfesorOutputDTO> lstpoDTO = new ArrayList<ProfesorOutputDTO>();
        for (Profesor p: repository.findAll()) {
            lstpoDTO.add((p.parseProfesorOutputDTO(p)));
        }
        return lstpoDTO;
    }

    @Override
    public ProfesorOutputDTO updateProfesor(int id, ProfesorInputDTO profesor) throws Exception {
        Optional<Profesor> profesorOptional = repository.findById(id);
        Optional<Persona> personaOptional = repositoryPersona.findById(profesor.getId_persona());
        if (personaOptional.isPresent()) {
            if (profesorOptional.isPresent()) {
                Profesor p = new Profesor(profesor, personaOptional.get());
                p.setId_profesor(id);
                repository.save(p);
                return p.parseProfesorOutputDTO(p);
            } else {
                throw new Exception("No se ha encontrado un profesor con ese ID");
            }
        } else {
            throw new Exception("No se ha encontrado una persona con ese ID");
        }
    }
}
