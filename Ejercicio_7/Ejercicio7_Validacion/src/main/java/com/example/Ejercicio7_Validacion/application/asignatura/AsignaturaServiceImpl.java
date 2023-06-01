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
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    private AsignaturaRepository repository;

    @Autowired
    EstudianteRepository repositoryEstudiante;

    @Override
    public AsignaturaSimpleOutputDTO addAsignatura(AsignaturaInputDTO asignatura){
            Asignatura a = new Asignatura(asignatura);
            repository.save(a);
            return a.parseAsignaturaSimpleOutputDTO(a);

    }

    @Override
    public AsignaturaFullOutputDTO getAsignaturaById(int id) throws Exception {
        Optional<Asignatura> asignaturaOptional = repository.findById(id);
        if (asignaturaOptional.isPresent()) {
            Asignatura a = asignaturaOptional.get();
            return a.parseAsignaturaFullOutputDTO(a);
        } else {
            throw new Exception("ERROR EN GETASIGNATURABYID: No se ha encontrado una Asignatura con esa ID");
        }
    }

    @Override
    public void deleteAsignaturaById(int id) throws Exception {
        Optional<Asignatura> asignaturaOptional = repository.findById(id);
        if (asignaturaOptional.isPresent()) {
            Asignatura a = asignaturaOptional.get();
            repository.delete(a);
        } else {
            throw new Exception("ERROR EN DELETEASIGNATURABYID: No se ha encontrado una Asignatura con esa ID");
        }
    }

    @Override
    public List<AsignaturaFullOutputDTO> getAllAsignatura() throws Exception {
        List<AsignaturaFullOutputDTO> lstaoDTO = new ArrayList<AsignaturaFullOutputDTO>();
        for (Asignatura a: repository.findAll()) {
            lstaoDTO.add((a.parseAsignaturaFullOutputDTO(a)));
        }
        return lstaoDTO;
    }

    @Override
    public AsignaturaSimpleOutputDTO updateAsignatura(int id, AsignaturaInputDTO asignatura) throws Exception {
        Optional<Asignatura> asignaturaOptional = repository.findById(id);
        Optional<Estudiante> estudianteOptional = repositoryEstudiante.findById(id);
        if (asignaturaOptional.isPresent()) {
            if (estudianteOptional.isPresent()) {
                Asignatura a = new Asignatura(asignatura);
                a.setId_asignatura(id);
                repository.save(a);
                return a.parseAsignaturaSimpleOutputDTO(a);
            } else {
                throw new Exception("ERROR EN UPDATEASIGNATURA: No se ha encontrado un estudiante con ese ID");
            }
        } else {
            throw new Exception("ERROR EN UPDATEASIGNATURA: No se ha encontrado una Asignatura con ese ID");
        }
    }

    @Override
    public AsignaturaFullOutputDTO addEstudiantes(int idAsignatura, int idEstudiante) throws Exception {
        Optional<Estudiante> estudianteOptional = repositoryEstudiante.findById(idEstudiante);
        Optional<Asignatura> asignaturaOptional = repository.findById(idAsignatura);
        if (estudianteOptional.isPresent() && asignaturaOptional.isPresent()) {
            Asignatura a = asignaturaOptional.get();
            Set<Estudiante> lstEstudiantes = new HashSet<>();
            lstEstudiantes.add(estudianteOptional.get());
            a.setEstudiantes(lstEstudiantes);
            repository.save(a);
            return a.parseAsignaturaFullOutputDTO(a);
        } else {
            throw new Exception("ERROR EN ADDESTUDIANTES: No encuentra uno de los IDs");
        }
    }

    @Override
    public Set<AsignaturaSimpleOutputDTO> getAsignaturaByEstudianteId(int id) throws Exception {
        Optional<Estudiante> estudianteOptional = repositoryEstudiante.findById(id);

        if (estudianteOptional.isPresent()) {
            Set<AsignaturaSimpleOutputDTO> lstAsignatura = new HashSet<>();
            Estudiante estudiante = estudianteOptional.get();
            for (Asignatura a: estudiante.getAsignatura()) {
                lstAsignatura.add(a.parseAsignaturaSimpleOutputDTO(a));
            }
            return  lstAsignatura;
        } else {
            throw new Exception("ERROR EN GETASIGNATURABYESTUDIANTEID: No se ha encontrado un Estudiante con esa ID");
        }
    }
}
