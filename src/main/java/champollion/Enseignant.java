package champollion;

import java.util.HashMap;
import java.util.Map;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    private Map<UE, Integer[]> enseignements;

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.enseignements = new HashMap<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int totalHours = 0;
        for (Integer[] e : enseignements.values()) {
            totalHours += e[0] * 1.5 + e[1] + e[2] * 0.75;
        }
        return Math.round(totalHours);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public long heuresPrevuesPourUE(UE ue) {
        if (enseignements.containsKey(ue)) {
            Integer[] e = enseignements.get(ue);
            return Math.round(e[0] * 1.5 + e[1] + e[2] * 0.75);
        }
        return 0;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        if (enseignements.containsKey(ue)) {
            Integer[] e = enseignements.get(ue);
            e[0] += volumeCM;
            e[1] += volumeTD;
            e[2] += volumeTP;
        } else {
            Integer[] e = {volumeCM, volumeTD, volumeTP};
            enseignements.put(ue, e);
        }
    }

}
