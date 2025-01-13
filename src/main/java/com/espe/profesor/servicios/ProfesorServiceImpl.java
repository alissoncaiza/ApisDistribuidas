package com.espe.profesor.servicios;

import com.espe.profesor.model.Profesor;
import com.espe.profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> getProfesorById(Integer id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor updateProfesor(Integer id, Profesor profesor) {
        return profesorRepository.findById(id).map(existingProfesor -> {
            existingProfesor.setNombre(profesor.getNombre());
            existingProfesor.setEmail(profesor.getEmail());
            existingProfesor.setFechaContratacion(profesor.getFechaContratacion());
            existingProfesor.setSueldo(profesor.getSueldo());
            return profesorRepository.save(existingProfesor);
        }).orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
    }

    @Override
    public void deleteProfesor(Integer id) {
        profesorRepository.deleteById(id);
    }

    @SpringBootApplication
    public class ProfesorApplication {
        public static void main(String[] args) {
            SpringApplication.run(ProfesorApplication.class, args);
        }
    }
}

