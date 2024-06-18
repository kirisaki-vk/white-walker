package vk.kirisaki.localisation;

public class Navigateur {
    private final Carte carte;

    public Navigateur(Carte carte) {
        this.carte = carte;
    }

    public Lieu ouMene(Lieu position, Rue rue) {
        return carte.lieux().stream().filter(
                lieu -> lieu.intersections().contains(rue) && lieu != position
        ).toList().getFirst();
    }
}
