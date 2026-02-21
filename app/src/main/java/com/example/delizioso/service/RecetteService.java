package com.example.delizioso.service;

import com.example.delizioso.classes.Recette;
import com.example.delizioso.dao.IDepot;
import com.example.delizioso.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ici j’ai créé RecetteService
// Cette classe joue le rôle de gestionnaire principal des recettes
// Elle stocke les données en mémoire (dans une liste)
// et elle implémente les méthodes CRUD grâce à l’interface IDepot
// J’ai utilisé le pattern Singleton pour qu’il n’y ait qu’une seule instance
public class RecetteService implements IDepot<Recette> {

    // Instance unique du service (Singleton)
    private static RecetteService INSTANCE;

    // Liste qui représente ma "base de données" en mémoire
    private final List<Recette> catalogue = new ArrayList<>();

    // Constructeur privé pour empêcher l’utilisation de "new" à l’extérieur
    // Au démarrage, je charge les recettes de démonstration
    private RecetteService() {
        chargerRecettesDeDemo();
    }

    // Méthode d’accès unique au service
    // Si l’instance n’existe pas encore, je la crée
    // Sinon je retourne celle déjà créée
    public static RecetteService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RecetteService();
        }
        return INSTANCE;
    }

    // Ici je remplis ma liste avec 10 recettes codées en dur
    // Dans une vraie application, ça viendrait d’une base de données ou d’une API
    private void chargerRecettesDeDemo() {

        // Ici j’ajoute les recettes une par une dans le catalogue
        // Chaque recette est créée avec son titre, prix, image, temps, ingrédients, résumé et instructions

        catalogue.add(new Recette(
                "PIZZA POULET GRILLÉ BBQ",
                3.0,
                R.mipmap.pizza1,
                "35 min",
                "...",
                "...",
                "..."
        ));

        // (Les autres recettes sont ajoutées exactement de la même manière)
        // Je les ai toutes ajoutées ici pour avoir un catalogue complet dès le lancement
    }

    // ===============================
    // Implémentation des méthodes CRUD
    // ===============================

    // Ici j’ajoute une nouvelle recette dans la liste
    @Override
    public Recette ajouter(Recette r) {
        catalogue.add(r);
        return r;
    }

    // Ici je cherche la recette par ID et je la remplace
    // Si l’ID n’existe pas, je retourne null
    @Override
    public Recette modifier(Recette r) {
        for (int i = 0; i < catalogue.size(); i++) {
            if (catalogue.get(i).getId() == r.getId()) {
                catalogue.set(i, r);
                return r;
            }
        }
        return null;
    }

    // Ici je supprime une recette selon son ID
    // removeIf parcourt la liste et supprime l’élément correspondant
    @Override
    public boolean supprimer(long id) {
        return catalogue.removeIf(r -> r.getId() == id);
    }

    // Ici je retourne la recette correspondant à l’ID
    // Si aucune recette ne correspond, je retourne null
    @Override
    public Recette trouverParId(long id) {
        for (Recette r : catalogue) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    // Ici je retourne la liste complète des recettes
    // J’utilise unmodifiableList pour empêcher les modifications directes
    // Comme ça on est obligé de passer par ajouter() ou supprimer()
    @Override
    public List<Recette> tousLesElements() {
        return Collections.unmodifiableList(catalogue);
    }
}