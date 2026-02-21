package com.example.delizioso.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.delizioso.R;

// Cette Activity est l’écran de démarrage (Splash Screen)
// Elle affiche le logo pendant 2 secondes
// Puis elle ouvre automatiquement la liste des recettes
// C’est elle qui est définie comme MAIN dans le Manifest
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Ici j’ai créé un Thread pour gérer le délai
        // Comme ça je ne bloque pas le thread principal (UI Thread)
        // Sinon l’application pourrait se figer (ANR)
        Thread minuterie = new Thread(() -> {
            try {
                // Je fais une pause de 2 secondes pour afficher le logo
                Thread.sleep(2000);
            } catch (InterruptedException ignoree) {
                // Si le thread est interrompu, on continue quand même
            }

            // Après les 2 secondes, j’ouvre l’Activity principale
            startActivity(new Intent(SplashActivity.this, ListeRecettesActivity.class));

            // Ici je ferme le Splash pour éviter que l’utilisateur
            // puisse revenir dessus en appuyant sur le bouton retour
            finish();
        });

        // Je démarre le Thread
        minuterie.start();
    }
}