package vk.kirisaki.localisation;

import java.util.List;

public record Lieu(String nom, List<Rue> intersections) {
    @Override
    public String toString() {
        return nom;
    }

    public boolean estUnCulDeSac() {
        return intersections.size() == 1;
    }
}