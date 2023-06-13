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
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Valid
    public EstudianteSimpleOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception {
        Persona persona = personaRepository.findById(estudianteInputDTO.getIdPersona()).orElseThrow(() -> new Exception("Not found id in persons"));
        Profesor profesor = profesorRepository.findById(estudianteInputDTO.getIdProfesor()).orElseThrow(() -> new Exception("Not found id in teacher"));

        if (profesorRepository.findByPersona(persona).isPresent())
            throw new Exception("ERROR EN ADDESTUDIANTE: Este ID ya es de un profesor");

        if (estudianteRepository.findByPersona(persona).isPresent())
            throw new Exception("ERROR EN ADDESTUDIANTE: Este ID ya es de un estudiante");

        Estudiante estudiante = new Estudiante(estudianteInputDTO, persona, profesor);
        if (estudianteInputDTO.getAsignaturas() != null) {
            estudianteInputDTO.getAsignaturas().forEach(asignaturaId -> {
                Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElseThrow(() -> new RuntimeException("Id asignatura not found"));
                estudiante.getAsignaturas().add(asignatura);
            });
        }

        estudianteRepository.save(estudiante);
        return new EstudianteFullOutputDTO(estudiante);
    }

    @Override
    public EstudianteSimpleOutputDTO getEstudianteSimpleById(int id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el estudiante con esa ID"));

        return new EstudianteSimpleOutputDTO(estudiante);
    }

    @Override
    public EstudianteFullOutputDTO getEstudianteFullById(int id){
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el estudiante con esa ID"));

        return new EstudianteFullOutputDTO(estudiante);
    }

    @Override
    public void deleteEstudianteById(int id){
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el estudiante con esa ID"));

        estudianteRepository.delete(estudiante);
    }

    @Override
    public List<EstudianteFullOutputDTO> getAllEstudiantes(){
        List<EstudianteFullOutputDTO> lsteoDTO = estudianteRepository.findAll().stream().map(EstudianteFullOutputDTO::new).toList();
        return lsteoDTO;
    }

    @Override
    public EstudianteSimpleOutputDTO updateEstudiante(int id, EstudianteInputDTO estudianteInputDTO){
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN UPDATEESTUDIANTE: No se ha encontrado un estudiante con ese ID"));

        estudiante.setIdEstudiante(id);
        estudiante.setPersona(personaRepository.findById(estudianteInputDTO.getIdPersona()).get());
        estudiante.setNumHoursWeek(estudianteInputDTO.getNumHoursWeek());
        estudiante.setComments(estudianteInputDTO.getComments());
        estudiante.setProfesor(profesorRepository.findById(estudianteInputDTO.getIdProfesor()).get());
//        estudiante.setAsignaturas(estudianteInputDTO.getAsignaturas());
        estudiante.setBranch(estudianteInputDTO.getBranch());
        estudianteRepository.save(estudiante);
        return new EstudianteSimpleOutputDTO(estudiante);

    }

    @Override
    public EstudianteFullOutputDTO addAsignatura(int idEstudiante, int idAsignatura){
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).orElseThrow(() -> new RuntimeException("ERROR EN ADDASIGNATURA: No encuentra una asignatura con ese ID"));
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new RuntimeException("ERROR EN ADDASIGNATURA: No encuentra un estudiante con ese ID"));

        List<Asignatura> lstAsignatura = new ArrayList<>();
        lstAsignatura.add(asignatura);
        estudiante.setAsignaturas(lstAsignatura);
        estudianteRepository.save(estudiante);
        return new EstudianteFullOutputDTO(estudiante);

    }


}
