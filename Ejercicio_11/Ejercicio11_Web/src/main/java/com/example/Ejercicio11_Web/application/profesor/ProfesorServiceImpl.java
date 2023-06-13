package com.example.Ejercicio11_Web.application.profesor;

import com.example.Ejercicio11_Web.classes.Persona;
import com.example.Ejercicio11_Web.classes.Profesor;
import com.example.Ejercicio11_Web.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio11_Web.controllers.dto.profesorDTO.ProfesorOutputDTO;
import com.example.Ejercicio11_Web.repository.EstudianteRepository;
import com.example.Ejercicio11_Web.repository.PersonaRepository;
import com.example.Ejercicio11_Web.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Persona persona = personaRepository.findById(profesorInputDTO.getIdPersona()).orElseThrow(() -> new RuntimeException("Error al crear el Profesor"));

            if (profesorRepository.findByPersona(persona).isPresent()) {
                throw new Exception("ERROR EN ADDPROFESOR: Este ID ya es de un profesor");
            }
            if (estudianteRepository.findByPersona(persona).isPresent()) {
                throw new Exception("ERROR EN ADDPROFESOR: Este ID ya es de un estudiante");
            }

            Profesor newProfesor = new Profesor(profesorInputDTO, persona);
            profesorRepository.save(newProfesor);
            return newProfesor.parseProfesorOutputDTO(newProfesor);

    }

    @Override
    public ProfesorOutputDTO getProfesorById(int id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado el profesor con esa ID"));
        return profesor.parseProfesorOutputDTO(profesor);
    }

    @Override
    public void deleteProfesorById(int id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new RuntimeException(("No se ha encontrado el profesor con esa ID")));
        profesorRepository.delete(profesor);
    }

    @Override
    public List<ProfesorOutputDTO> getAllProfesores() {
        List<ProfesorOutputDTO> lstpoDTO = new ArrayList<>();
        profesorRepository.findAll().forEach(p -> lstpoDTO.add((p.parseProfesorOutputDTO(p))));
        return lstpoDTO;
    }

    @Override
    public ProfesorOutputDTO updateProfesor(int id, ProfesorInputDTO profesorInputDTO){
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado un profesor con ese ID"));

        profesor.setIdProfesor(id);
        profesor.setPersona(personaRepository.findById(profesorInputDTO.getIdPersona()).get());
        profesor.setComments(profesorInputDTO.getComments());
        profesor.setBranch(profesorInputDTO.getBranch());
        profesorRepository.save(profesor);
        return profesor.parseProfesorOutputDTO(profesor);
    }
}
