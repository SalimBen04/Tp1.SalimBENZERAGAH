
# Utilisation de l'intelligence artificielle

Dans le cadre de ce TP, j'ai utilisé l'intelligence artificielle comme outil d'assistance pour comprendre, tester et améliorer le fonctionnement de l'application utilisant l'API Gemini.

## 1. Compréhension du fonctionnement de l'API Gemini
- J'ai utilisé ChatGPT pour comprendre le fonctionnement des requêtes et des réponses envoyées à l'API Gemini.
- J'ai demandé des explications sur la structure des données JSON, notamment les propriétés `system_instruction`, `contents`, `parts` et `role`.
- J'ai utilisé l'assistance de l'IA pour comprendre comment l'historique des conversations est transmis au modèle à chaque nouvelle requête.

## 2. Analyse des erreurs
- J'ai utilisé ChatGPT pour comprendre les erreurs obtenues lors des tests avec une fausse clé API.
- J'ai également analysé l'erreur provoquée en remplaçant le rôle `user` par `system` dans le JSON.
- L'IA m'a aidé à interpréter les messages d'erreur et à identifier leurs causes.

## 3. Création d'un rôle système personnalisé
- J'ai utilisé ChatGPT pour réfléchir à la création d'un rôle système personnalisé intitulé « Professeur d'informatique ».
- Ce rôle permet à Gemini d'expliquer les concepts informatiques aux débutants avec un langage simple, des exemples pratiques et des analogies.
- J'ai intégré ce rôle dans l'application et testé son comportement avec deux questions.

## 4. Analyse et compréhension du code
- J'ai utilisé ChatGPT pour comprendre le rôle de la classe `JsonAdapterPourGemini` dans la préparation des requêtes JSON et la conservation de l'historique conversationnel.
- J'ai également utilisé son aide pour comprendre certaines parties du code et les manipulations Git nécessaires à la restauration des modifications après les tests.

## 5. Utilisation de Gemini dans l'application
- Le TP m'a permis de tester directement le modèle Gemini à travers l'application développée.
- J'ai testé différents échanges conversationnels, observé les requêtes et les réponses JSON en mode debug et expérimenté un rôle système personnalisé.

