package vk.kirisaki;

import vk.kirisaki.localisation.Lieu;
import vk.kirisaki.localisation.Navigateur;
import vk.kirisaki.localisation.Rue;

import java.util.ArrayList;
import java.util.List;

public final class Marcheur {
    private final String nom;

    public Marcheur(String nom) {
        this.nom = nom;
    }

    public List<Lieu> marche(Navigateur navigateur, Lieu depart, Lieu desitnation) {
        List<Lieu> listeCulsDeSac = new ArrayList<>();
        ArrayList<Lieu> marche = new ArrayList<>();
        marche.add(depart);
        Lieu postition = depart;
        while (!postition.equals(desitnation)) {
            Lieu positionTemporaire = postition;
            int indexIntersection = (int) Math.floor(
                    Math.random() * positionTemporaire.intersections().size()
            );
            Rue rue = positionTemporaire.intersections().get(indexIntersection);
            Lieu nouvellePosition = navigateur.ouMene(postition, rue);
            if (nouvellePosition.equals(positionTemporaire) || listeCulsDeSac.contains(nouvellePosition))
                continue;
            postition = nouvellePosition;
            marche.add(postition);

            if (nouvellePosition.estUnCulDeSac()) listeCulsDeSac.add(nouvellePosition);
        }
        return marche;
    }
}
