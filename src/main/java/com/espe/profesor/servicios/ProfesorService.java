package com.espe.profesor.servicios;

import com.espe.profesor.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> getAllProfesores();
    Optional<Profesor> getProfesorById(Integer id);
    Profesor createProfesor(Profesor profesor);
    Profesor updateProfesor(Integer id, Profesor profesor);
    void deleteProfesor(Integer id);
}
