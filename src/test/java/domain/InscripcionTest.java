package domain;

import domain.facultad.Alumno;
import domain.facultad.Inscripcion;
import domain.facultad.Materia;


import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {
    Materia matematicaDiscreta = new Materia("Matematica Discreta");
    Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programacion");
    Materia algoritmos = new Materia("Algoritmos");

    Materia fisica = new Materia("Fisica");
    Materia diseñoDeSistemas = new Materia("Diseño de Sistemas");
    Materia analisisDeSistemas = new Materia("Analisis de Sistemas");
    Materia sistemasYOrganizaciones = new Materia("Sistemas y Organizaciones");



    Alumno juan = new Alumno("Juan", "1234");



    @Test
    public void alumnoSeAnotaAMateriaDePrimerAño(){
        Inscripcion inscripcion = new Inscripcion(juan);
        inscripcion.agregarMateriasAInscripcion(matematicaDiscreta);

        Assert.assertTrue(inscripcion.aprobada());
    }
    @Test
    public void inscripcionAMateriaConCorrelativasAprobadas(){
        paradigmasDeProgramacion.agregarCorrelativas(matematicaDiscreta, algoritmos);

        juan.agregarAprobadas(matematicaDiscreta, algoritmos);

        Inscripcion inscripcion = new Inscripcion(juan);
        inscripcion.agregarMateriasAInscripcion(paradigmasDeProgramacion);



        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionAMateriaSinCorrelativasAprobadas(){
        paradigmasDeProgramacion.agregarCorrelativas(matematicaDiscreta, algoritmos);

        juan.agregarAprobadas(matematicaDiscreta);

        Inscripcion inscripcion = new Inscripcion(juan);
        inscripcion.agregarMateriasAInscripcion(paradigmasDeProgramacion);

        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void noSePuedeAceptarInscripcionSinMaterias(){
        Inscripcion inscripcion = new Inscripcion(juan);
        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void noSePuedeInscribirAUnaMateriaQueYaAprobo(){

        juan.agregarAprobadas(matematicaDiscreta, algoritmos);

        Inscripcion inscripcion = new Inscripcion(juan);
        inscripcion.agregarMateriasAInscripcion(matematicaDiscreta);

        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void inscripcionConVariasMateriasYCorrelatividades(){
        paradigmasDeProgramacion.agregarCorrelativas(matematicaDiscreta, algoritmos);
        diseñoDeSistemas.agregarCorrelativas(analisisDeSistemas, paradigmasDeProgramacion);
        analisisDeSistemas.agregarCorrelativas(sistemasYOrganizaciones, algoritmos);

        juan.agregarAprobadas( algoritmos, analisisDeSistemas, paradigmasDeProgramacion);

        Inscripcion inscripcion = new Inscripcion(juan);
        inscripcion.agregarMateriasAInscripcion(matematicaDiscreta, diseñoDeSistemas, fisica);



        Assert.assertTrue(inscripcion.aprobada());
    }
    @Test
    public void inscripcionConVariasMateriasYCorrelatividadesPeroFaltaUnaCorrelativa(){
        paradigmasDeProgramacion.agregarCorrelativas(matematicaDiscreta, algoritmos);
        diseñoDeSistemas.agregarCorrelativas(analisisDeSistemas, paradigmasDeProgramacion);
        analisisDeSistemas.agregarCorrelativas(sistemasYOrganizaciones, algoritmos);

        juan.agregarAprobadas( algoritmos, paradigmasDeProgramacion);

        Inscripcion inscripcion = new Inscripcion(juan);
        inscripcion.agregarMateriasAInscripcion(matematicaDiscreta, diseñoDeSistemas, fisica);



        Assert.assertFalse(inscripcion.aprobada());
    }


}
