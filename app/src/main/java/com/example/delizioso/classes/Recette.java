package com.example.delizioso.classes;

// Ici j’ai créé la classe Recette
// Elle représente une pizza dans mon application
// Chaque objet Recette correspond à une fiche complète de recette
public class Recette {

    // J’ai ajouté un compteur statique pour générer automatiquement un ID unique
    // À chaque nouvelle recette créée, le compteur augmente
    private static long compteurId = 1;

    private long id;               // ID unique généré automatiquement
    private String titre;          // Nom de la pizza
    private double coutEstime;     // Coût estimé en euros
    private int photoRes;          // Référence vers l’image (R.mipmap.xxx)
    private String tempsTotalPrep; // Temps total de préparation (ex: "35 min")
    private String listeIngredients;
    private String resumeCourt;    // Petite description de la recette
    private String instructionsCuisson; // Étapes de cuisson

    // Constructeur vide
    // Ici je génère juste l’ID automatiquement
    public Recette() {
        this.id = compteurId++;
    }

    // Constructeur complet
    // Ici je remplis tous les champs directement lors de la création de l’objet
    public Recette(String titre, double coutEstime, int photoRes,
                   String tempsTotalPrep, String listeIngredients,
                   String resumeCourt, String instructionsCuisson) {
        this.id = compteurId++;
        this.titre = titre;
        this.coutEstime = coutEstime;
        this.photoRes = photoRes;
        this.tempsTotalPrep = tempsTotalPrep;
        this.listeIngredients = listeIngredients;
        this.resumeCourt = resumeCourt;
        this.instructionsCuisson = instructionsCuisson;
    }

    // --- Getters & Setters ---
    // J’ai mis des getters et setters pour pouvoir accéder et modifier les données
    // Je n’ai pas mis de setter pour l’ID car il ne doit jamais changer

    public long getId() { return id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public double getCoutEstime() { return coutEstime; }
    public void setCoutEstime(double coutEstime) { this.coutEstime = coutEstime; }

    public int getPhotoRes() { return photoRes; }
    public void setPhotoRes(int photoRes) { this.photoRes = photoRes; }

    public String getTempsTotalPrep() { return tempsTotalPrep; }
    public void setTempsTotalPrep(String t) { this.tempsTotalPrep = t; }

    public String getListeIngredients() { return listeIngredients; }
    public void setListeIngredients(String l) { this.listeIngredients = l; }

    public String getResumeCourt() { return resumeCourt; }
    public void setResumeCourt(String r) { this.resumeCourt = r; }

    public String getInstructionsCuisson() { return instructionsCuisson; }
    public void setInstructionsCuisson(String i) { this.instructionsCuisson = i; }

    // Ici j’ai redéfini toString()
    // Ça me permet d’afficher facilement la recette dans les logs (Logcat)
    @Override
    public String toString() {
        return titre + " — " + coutEstime + " €";
    }
}