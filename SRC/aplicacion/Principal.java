package SRC.aplicacion;

import java.util.Arrays;

import SRC.dominio.Candidato;
import SRC.dominio.Eleccion;
import SRC.dominio.Papeleta;
import SRC.dominio.SistemaElecciones;

public class Principal {
    public static void main(String[] args) {
        
        Candidato c1 = new Candidato("Candidato 1");
        Candidato c2 = new Candidato("Candidato 2");
        Candidato c3 = new Candidato("Candidato 3");

        Eleccion eleccion = new Eleccion(Arrays.asList(c1, c2, c3));

        Papeleta p1 = new Papeleta(Arrays.asList(c1, c2, c3));
        Papeleta p2 = new Papeleta(Arrays.asList(c2, c1, c3));
        Papeleta p3 = new Papeleta(Arrays.asList(c3, c2, c1));
        Papeleta p4 = new Papeleta(Arrays.asList(c1, c3, c2));

        eleccion.annadirPapeleta(p1);
        eleccion.annadirPapeleta(p2);
        eleccion.annadirPapeleta(p3);
        eleccion.annadirPapeleta(p4);

        SistemaElecciones sistema = new SistemaElecciones(eleccion);
        sistema.iniciarEleccion();
        sistema.mostrarResultados();
    }
}


