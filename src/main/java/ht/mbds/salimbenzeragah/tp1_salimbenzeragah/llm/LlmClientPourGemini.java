package ht.mbds.salimbenzeragah.tp1_salimbenzeragah.llm;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;

/**
 * Gère l'interface avec l'API de Gemini.
 * Son rôle est essentiellement de lancer une requête à chaque nouvelle
 * question qu'on veut envoyer à l'API.
 *
 * De portée dependent pour réinitialiser la conversation à chaque fois que
 * l'instance qui l'utilise est renouvelée.
 * Par exemple, si l'instance qui l'utilise est de portée View, la conversation est
 * réunitialisée à chaque fois que l'utilisateur quitte la page en cours.
 */
@Dependent
public class LlmClientPourGemini implements Serializable {
    // Clé pour l'API du LLM
    private final String key;
    // Client REST. Facilite les échanges avec une API REST.
    private Client clientRest; // Pour pouvoir le fermer
    // Représente un endpoint de serveur REST
    private final WebTarget target;

    public LlmClientPourGemini() {
        // Récupère la clé secrète pour travailler avec l'API du LLM, mise dans une variable d'environnement
        // du système d'exploitation.
        String cle = System.getenv("GEMINI_KEY");
        // Si la variable n'existe pas, on met une clé vide : l'API refusera la requête et le message
        // d'erreur s'affichera dans la page.
        this.key = (cle == null) ? "" : cle;
        // Client REST pour envoyer des requêtes vers les endpoints de l'API du LLM
        this.clientRest = ClientBuilder.newClient();
        // Endpoint REST pour envoyer la question à l'API.
        // Pour Gemini, la clé secrète est passée en paramètre "key" de l'URL.
        this.target = clientRest
                .target("https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash-lite:generateContent")
                .queryParam("key", this.key);
    }

    /**
     * Envoie une requête à l'API de Gemini.
     * @param requestEntity le corps de la requête (en JSON).
     * @return réponse REST de l'API (corps en JSON).
     */
    public Response envoyerRequete(Entity requestEntity) {
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
        // Envoie la requête POST au LLM
        return request.post(requestEntity);
    }

    public void closeClient() {
        this.clientRest.close();
    }
}