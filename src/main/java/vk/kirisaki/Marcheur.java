package vk.kirisaki;

import vk.kirisaki.localisation.Carte;
import vk.kirisaki.localisation.Lieu;
import vk.kirisaki.localisation.Rue;

import java.util.ArrayList;
import java.util.List;

public final class Marcheur {
    private final String nom;

    public Marcheur(String nom) {
        this.nom = nom;
    }

    public List<Lieu> marche(Carte endroit, Lieu depart, Lieu desitnation) {
        List<Lieu> marche = new ArrayList<>();
        marche.add(depart);
        Lieu postition = depart;
        while (!postition.equals(desitnation)) {
            Lieu positionTemporaire = postition;
            List<Lieu> routePossible = endroit.lieux().stream().filter(
                    lieu -> {
                        int indexIntersection = (int) Math.floor(
                                Math.random() * positionTemporaire.intersections().size()
                        );
                        Rue rue = positionTemporaire.intersections().get(indexIntersection);
                        return lieu.intersections().contains(rue);
                    }
            ).toList();
            int indexNouvellePosition = (int) Math.floor(Math.random() * routePossible.size());
            Lieu nouvellePosition = routePossible.get(indexNouvellePosition);
            if (nouvellePosition.equals(postition)) continue;
            postition = nouvellePosition;
            marche.add(postition);

        }

        return marche;
    }
}
