package vk.kirisaki;

import vk.kirisaki.localisation.Carte;
import vk.kirisaki.localisation.Lieu;
import vk.kirisaki.localisation.Rue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class Marcheur {
    private final String nom;

    public Marcheur(String nom) {
        this.nom = nom;
    }

    public List<Lieu> marche(Carte endroit, Lieu depart, Lieu desitnation) {
        Set<Lieu> destinationsPossibles = endroit.lieux();
        List<Lieu> listeCulsDeSac = new ArrayList<>();
        ArrayList<Lieu> marche = new ArrayList<>();
        marche.add(depart);
        Lieu postition = depart;
        while (!postition.equals(desitnation)) {
            Lieu positionTemporaire = postition;
            List<Lieu> routePossible = destinationsPossibles.stream().filter(
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
            if (nouvellePosition.equals(positionTemporaire) || listeCulsDeSac.contains(nouvellePosition)) continue;
            postition = nouvellePosition;
            marche.add(postition);

            if (nouvellePosition.estUnCulDeSac()) listeCulsDeSac.add(nouvellePosition);
        }
        return marche;
    }
}
