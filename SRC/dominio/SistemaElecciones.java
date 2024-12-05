package SRC.dominio;

public class SistemaElecciones{
    private Eleccion eleccion;

    public SistemaElecciones(Eleccion eleccion){
        this.eleccion=eleccion;
    }
    public void iniciarEleccion(){
        eleccion.validarPapeletas();
        Candidato ganador = null;
        while (ganador==null){
            eleccion.realizarRecuento();
            ganador = eleccion.comprobarMayoríaAbsoluta();
            if (ganador==null){
                eleccion.eliminarCandidatoConMenosVotos();
            }
        }
        System.out.println("Ganador: " + ganador.getNombre());
    }
    public void mostrarResultados(){
        System.out.println(eleccion);
    }
}