package domain.facultad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    public String nombre;
    public String legajo;
    public List<Materia> materiasAprobadas;


    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();}



    public void agregarAprobadas(Materia ... materias) {
    Collections.addAll(this.materiasAprobadas, materias);
    }
}
