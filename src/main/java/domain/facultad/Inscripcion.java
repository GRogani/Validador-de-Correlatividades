package domain.facultad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    public Alumno alumno;
    public List<Materia> materiasInscripcion;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasInscripcion = new ArrayList<>();
    }

    public boolean aprobada() {
       return this.materiasInscripcion.stream().allMatch(mat -> this.cumpleConCorrelativas(mat) && !this.alumno.getMateriasAprobadas().contains(mat))
               && !this.materiasInscripcion.isEmpty();
    }

    public void agregarMateriasAInscripcion(Materia ... materias) {
        Collections.addAll(this.materiasInscripcion, materias);
    }

    public boolean cumpleConCorrelativas(Materia unaMateria) {
        for (Materia materia : unaMateria.getCorrelativas()) {
            if (!this.alumno.getMateriasAprobadas().contains(materia)) {
                return false;
            }
        }
        return true;
    }
}
