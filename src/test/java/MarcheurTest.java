import org.junit.jupiter.api.Test;
import vk.kirisaki.localisation.Carte;
import vk.kirisaki.localisation.Lieu;
import vk.kirisaki.Marcheur;
import vk.kirisaki.localisation.Rue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarcheurTest {
    @Test
    public void Bjarni_marche_a_Atananarivo_de_HEI_a_ESTI() {
        // Rues
        var rue1 = new Rue();
        var rue2 = new Rue();
        var rue3 = new Rue();
        var rue4 = new Rue();
        var rue5 = new Rue();
        var rue6 = new Rue();
        var rue7 = new Rue();
        var rueRanaivo = new Rue("Ranaivo");
        var rueAndriatsihorana = new Rue("Andriatsihorana");

        // Lieux
        var HEI = new Lieu("HEI", List.of(rueAndriatsihorana, rue1, rue2));
        var ESTI = new Lieu("ESTI", List.of(rue3, rue4));
        var balancoire = new Lieu("Balancoire", List.of(rueRanaivo, rue1, rue3, rue5));
        var boulevardDeLeurope = new Lieu("Boulevard de l'Europe", List.of(rue4, rue5));
        var pullman = new Lieu("Pullman", List.of(rueAndriatsihorana, rueRanaivo, rue7));
        var sekolintsika = new Lieu("Sekolintsika", List.of(rue2, rue6));
        var marais = new Lieu("Marais", List.of(rue6));
        var nexta = new Lieu("Nexta", List.of(rue7));

        var carteAnatananarivo = new Carte("Antananarivo", List.of(HEI, ESTI, balancoire, boulevardDeLeurope, pullman, sekolintsika, marais, nexta));

        var bjarni = new Marcheur("Bjarni");

        var itineraire = bjarni.marche(carteAnatananarivo, HEI, ESTI);

        System.out.println(itineraire);

        assertEquals(ESTI, itineraire.getLast());
    }
}
