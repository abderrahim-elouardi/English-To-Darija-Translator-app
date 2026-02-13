# 🌍 DarijaTranslate: Application de Traduction Multilingue vers l'Arabe Marocain

Ce projet est une solution complète de traduction capable de convertir n'importe quelle langue vers le **Darija (Arabe Marocain)**. L'application repose sur une architecture découplée avec un backend robuste en Java et un frontend dynamique en PHP, utilisant l'intelligence artificielle de Google Gemini.

## 📺 Démonstration Vidéo

Découvrez l'application en action (interface, processus d'authentification et exemples de traduction vers le Darija) :

<div align="center">
  <a href="https://www.youtube.com/watch?v=iC6berMWhGo">
    <img src="https://img.youtube.com/vi/iC6berMWhGo/maxresdefault.jpg" alt="Regarder la démo" style="width:100%; max-width:600px;">
  </a>
  <p><i>Cliquer sur l'image pour voir la vidéo de démonstration du traducteur vers la Darija</i></p>
</div>



## 🚀 Architecture du Projet

Le projet est divisé en deux composants principaux :

1.  **Backend (Java JAX-RS) :** Serveur REST gérant l'authentification et la logique métier de communication avec l'API de traduction.
2.  **Frontend (PHP Client) :** Interface utilisateur permettant de saisir les textes et d'afficher les traductions consommées via le backend.

---

## 🛠️ Technologies Utilisées

### Backend (API REST)
* **Java EE / Jakarta EE**
* **JAX-RS (Jersey/Resteasy) :** Pour la création des points de terminaison (endpoints) REST.
* **Java Basic Authentication :** Sécurisation des ressources via un mécanisme d'authentification standard.
* **Maven :** Gestion des dépendances.

### Intelligence Artificielle (Moteur de Traduction)
* **OpenRouter API :** Interface de communication avec le modèle **DeepSeek**.
* **Prompt Engineering :** Optimisé pour capturer les nuances et le dialecte spécifique du Darija marocain.

### Frontend
* **PHP 8.x :** Consommation de l'API REST via cURL.
* **HTML5 / CSS3 / JavaScript :** Interface utilisateur réactive.

---

## 🔒 Sécurité

L'API Backend est protégée par une **Authentification Basique (HTTP Basic Auth)**. Chaque requête envoyée par le client PHP doit inclure un en-tête d'autorisation valide :
```http
Authorization: Basic <credentials_base64>
