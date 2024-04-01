package domain.facultad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    public String nombre;
    public List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.correlativas, materias);
    }
}
