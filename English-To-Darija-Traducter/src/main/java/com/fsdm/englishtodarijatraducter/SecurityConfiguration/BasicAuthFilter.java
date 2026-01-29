package com.fsdm.englishtodarijatraducter.SecurityConfiguration;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;

import jakarta.servlet.Filter;

@WebFilter("/*") // S'applique à toutes les URLs
public class BasicAuthFilter implements Filter {

   
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 1. Autoriser toutes les origines (ou remplacez * par votre URL spécifique)
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");

        // 2. Autoriser les méthodes HTTP utilisées
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        // 3. Autoriser l'en-tête Authorization que vous envoyez en JS
        httpResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");

        // 4. Gérer la requête de pré-vérification (Preflight)
        // Le navigateur envoie 'OPTIONS' avant la vraie requête. On doit répondre OK (200).
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // --- ICI COMMENCE VOTRE CODE D'AUTHENTIFICATION EXISTANT ---
        String authHeader = httpRequest.getHeader("Authorization");

        // 1. Récupérer l'URL demandée
        String path = httpRequest.getRequestURI();
        if (path.endsWith("/api/signUp")) {
            // On laisse passer sans vérifier l'authentification
            chain.doFilter(request, response);
            return;
        }
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // 2. Extraire et décoder le Base64
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);

            // Format du texte décodé : "username:password"
            String[] values = credentials.split(":", 2);

            if (values.length == 2) {
                // Authentification réussie
                File f = new File("password.pwd");
                Reader reader = new FileReader(f);
                BufferedReader bufferedReader = new BufferedReader(reader);
                AtomicBoolean valide = new AtomicBoolean(false);
                bufferedReader.lines().forEach((l)->{
                    if(l.trim().split(":")[0].equals(values[0]) && l.trim().split(":")[1].equals(values[1])){
                        valide.set(true);
                    }
                });
                if(valide.get()){
                    chain.doFilter(request, response);
                }

                return;
            }
        }

        // 3. Si échec : envoyer une erreur 401 avec l'en-tête WWW-Authenticate
        httpResponse.setHeader("WWW-Authenticate", "Basic realm=\"Accès sécurisé\"");
        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentification requise");
    }
}