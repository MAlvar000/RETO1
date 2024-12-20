package SRC.dominio;
public class Candidato{
    private String nombre;
    private int votos;

    public Candidato( String nombre){
        this.nombre= nombre;
        this.votos=0;
    }
    public void IncrementarVotos(){
        this.votos++;
    }
    public void ResetearVotos(){
        this.votos=0;
    }
    public String getNombre(){
            return nombre;
    }
    public int getVotos(){
        return votos;
    }
    public String toString(){
        return nombre +" ( "+ votos + " votos)";
    }
}

