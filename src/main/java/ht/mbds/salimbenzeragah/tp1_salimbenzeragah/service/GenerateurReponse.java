package ht.mbds.salimbenzeragah.tp1_salimbenzeragah.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * Service qui génère la réponse à une question.
 * Traitement personnel : codage en binaire. Si la question est du texte, la réponse
 * est ce texte écrit en binaire (8 bits par octet). Si la question est déjà du binaire,
 * la réponse est le texte décodé.
 */
@Dependent
public class GenerateurReponse implements Serializable {

    /** Nombre de questions traitées dans ce chat. */
    private int numeroQuestion = 0;

    public String genererReponse(String question, String roleSysteme) {
        this.numeroQuestion++;
        String texte = question.trim();

        String resultat;
        if (estBinaire(texte)) {
            resultat = "Décodé : " + decoder(texte);
        } else {
            resultat = "Binaire : " + encoder(texte);
        }
        return "Question n°" + this.numeroQuestion + "\n" + resultat;
    }

    /** Transforme chaque octet du texte en 8 bits, séparés par une espace. */
    private String encoder(String texte) {
        StringBuilder sb = new StringBuilder();
        for (byte octet : texte.getBytes(StandardCharsets.UTF_8)) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            // & 0xFF pour obtenir une valeur de 0 à 255, puis on complète à 8 bits avec des zéros
            String bits = Integer.toBinaryString(octet & 0xFF);
            sb.append("0".repeat(8 - bits.length())).append(bits);
        }
        return sb.toString();
    }

    /** Vrai si le texte est une suite de groupes de 8 bits séparés par des espaces. */
    private boolean estBinaire(String texte) {
        return texte.matches("[01]{8}( [01]{8})*");
    }

    /** Opération inverse de encoder. */
    private String decoder(String binaire) {
        String[] groupes = binaire.split(" ");
        byte[] octets = new byte[groupes.length];
        for (int i = 0; i < groupes.length; i++) {
            octets[i] = (byte) Integer.parseInt(groupes[i], 2);
        }
        return new String(octets, StandardCharsets.UTF_8);
    }
}