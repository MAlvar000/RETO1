package SRC.dominio;

import java.util.List;

public class Papeleta{
    private List <Candidato> listaPreferencias;

    public Papeleta (List<Candidato> listaPreferencias){
        this.listaPreferencias=listaPreferencias;
    }
    public Candidato obtenerPrimeraPreferencia(){
        if(listaPreferencias.isEmpty()){
            return null;
        }
        else{
            return listaPreferencias.get(0);
        }
    }
    public void eliminarCandidato(Candidato candidato){
        listaPreferencias.remove(candidato);
    }
    public boolean esValida(List<Candidato> candidatos){
        return listaPreferencias.stream().allMatch(candidatos::contains);
    }
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        for (Candidato c : listaPreferencias) { sb.append(c.getNombre()).append(" > ");
    }  
    return sb.substring(0, sb.length() - 3);
    }
}