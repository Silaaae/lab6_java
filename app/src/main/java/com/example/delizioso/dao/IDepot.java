package com.example.delizioso.dao;

import java.util.List;

// Ici j’ai créé une interface générique pour gérer les données
// Elle suit le pattern DAO (Data Access Object)
// Ça sert à définir les opérations de base qu’une classe doit implémenter
// pour manipuler des données (CRUD)
public interface IDepot<T> {

    // Ici j’ajoute un nouvel élément (Create)
    // Cette méthode devra être implémentée dans la classe concrète
    T ajouter(T t);

    // Ici je modifie un élément existant (Update)
    // On suppose que l’objet contient déjà son ID
    T modifier(T t);

    boolean supprimer(long id);

    // Ici je cherche un élément par son ID (Read - recherche spécifique)
    // Si l’élément n’existe pas, on retourne null
    T trouverParId(long id);

    // Ici je retourne tous les éléments stockés (Read - liste complète)
    List<T> tousLesElements();
}