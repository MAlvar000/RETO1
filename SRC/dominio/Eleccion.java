package SRC.dominio;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Eleccion {
    private List<Candidato> candidatos;
    private List<Papeleta> papeletas;

    public Eleccion(List<Candidato> candidatos) {
        this.candidatos = candidatos;
        this.papeletas = new ArrayList<>();
    }

    public void annadirPapeleta(Papeleta papeleta) {
        if (papeleta.esValida(candidatos)) {
            papeletas.add(papeleta);
        } else {
            System.out.println("Papeleta inválida: " + papeleta);
        }
    }
    public void realizarRecuento() {
        for (Candidato candidato : candidatos) {
            candidato.ResetearVotos();
        }
        for (Papeleta papeleta : papeletas) {
            Candidato candidato = papeleta.obtenerPrimeraPreferencia();
            if (candidato != null) {
                candidato.IncrementarVotos();
            }
        }
    }
    
    
    public Candidato comprobarMayoríaAbsoluta() {
        int totalVotos = papeletas.size();
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > totalVotos / 2) {
                return candidato;
            }
        }
        return null;
    }

    public void eliminarCandidatoConMenosVotos() {
        Candidato candidatoMenosVotos = candidatos.stream()
            .min((c1, c2) -> Integer.compare(c1.getVotos(), c2.getVotos()))
            .orElse(null);
        if (candidatoMenosVotos != null) {
            candidatos.remove(candidatoMenosVotos);
            papeletas.forEach(p -> p.eliminarCandidato(candidatoMenosVotos));
        }
    }

    public void validarPapeletas() {
        papeletas = papeletas.stream()
            .filter(p -> p.esValida(candidatos))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados de la elección:\n");
        candidatos.forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }
}
