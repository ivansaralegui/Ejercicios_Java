package com.example.Ejercicio7_Validacion.application.asignatura;

import com.example.Ejercicio7_Validacion.classes.Asignatura;
import com.example.Ejercicio7_Validacion.classes.Estudiante;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.repository.AsignaturaRepository;
import com.example.Ejercicio7_Validacion.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public AsignaturaSimpleOutputDTO addAsignatura(AsignaturaInputDTO asignaturaInputDTO) {
        Asignatura asignatura = new Asignatura(asignaturaInputDTO);
        asignaturaRepository.save(asignatura);
        return asignatura.parseAsignaturaSimpleOutputDTO(asignatura);
    }

    @Override
    public AsignaturaFullOutputDTO getAsignaturaById(int id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN GETASIGNATURABYID: No se ha encontrado una Asignatura con esa ID"));

        return asignatura.parseAsignaturaFullOutputDTO(asignatura);
    }

    @Override
    public void deleteAsignaturaById(int id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN DELETEASIGNATURABYID: No se ha encontrado una Asignatura con esa ID"));

        asignaturaRepository.delete(asignatura);
    }

    @Override
    public List<AsignaturaFullOutputDTO> getAllAsignatura() {
        List<AsignaturaFullOutputDTO> lstaoDTO = new ArrayList<>();
        asignaturaRepository.findAll().forEach(a -> lstaoDTO.add((a.parseAsignaturaFullOutputDTO(a))));
        return lstaoDTO;
    }

    @Override
    public AsignaturaSimpleOutputDTO updateAsignatura(int id, AsignaturaInputDTO asignaturaInputDTO) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN UPDATEASIGNATURA: No se ha encontrado una Asignatura con ese ID"));

        asignatura.setIdAsignatura(id);
//        asignatura.setEstudiantes(asignaturaInputDTO.getEstudiantes());
        asignatura.setAsignaturaNombre(asignaturaInputDTO.getAsignaturaNombre());
        asignatura.setComments(asignaturaInputDTO.getComments());
        asignatura.setInitialDate(asignaturaInputDTO.getInitialDate());
        asignatura.setFinishDate(asignaturaInputDTO.getFinishDate());
        asignaturaRepository.save(asignatura);
        return asignatura.parseAsignaturaSimpleOutputDTO(asignatura);

    }

    @Override
    public AsignaturaFullOutputDTO addEstudiantes(int idAsignatura, int idEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new RuntimeException("ERROR EN ADDESTUDIANTES: No encuentra un estudiante con ese ID"));
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).orElseThrow(() -> new RuntimeException("ERROR EN ADDESTUDIANTES: No encuentra una asignatura con ese ID"));

        List<Estudiante> lstEstudiantes = new ArrayList<>();
        lstEstudiantes.add(estudiante);
        asignatura.setEstudiantes(lstEstudiantes);
        asignaturaRepository.save(asignatura);
        return asignatura.parseAsignaturaFullOutputDTO(asignatura);
    }

    @Override
    public List<AsignaturaSimpleOutputDTO> getAsignaturaByEstudianteId(int id){
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN GETASIGNATURABYESTUDIANTEID: No se ha encontrado un Estudiante con esa ID"));

        List<AsignaturaSimpleOutputDTO> lstAsignaturas = new ArrayList<>();
        for (Asignatura a: estudiante.getAsignaturas()) {
            lstAsignaturas.add(a.parseAsignaturaSimpleOutputDTO(a));
        }

        return lstAsignaturas;
    }
}
