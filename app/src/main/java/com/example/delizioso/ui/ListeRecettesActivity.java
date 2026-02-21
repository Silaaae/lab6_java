package com.example.delizioso.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.delizioso.R;
import com.example.delizioso.adapter.RecetteAdapter;
import com.example.delizioso.classes.Recette;
import com.example.delizioso.service.RecetteService;
import java.util.List;

// Cette Activity est l’écran principal de mon application
// Elle affiche toutes les recettes dans une ListView
// Quand on clique sur une recette, on ouvre l’écran détail
public class ListeRecettesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_recettes);

        // Ici je récupère la ListView depuis le layout XML
        ListView listeView = findViewById(R.id.lvRecettes);

        // Ici je demande toutes les recettes au RecetteService (Singleton)
        // Comme ça j’ai une seule source de données pour toute l’application
        List<Recette> recettes = RecetteService.getInstance().tousLesElements();

        // Ici je relie mes données à la ListView grâce à mon RecetteAdapter
        listeView.setAdapter(new RecetteAdapter(this, recettes));

        // Ici je gère le clic sur un élément de la liste
        // Quand l’utilisateur clique, je récupère l’ID de la recette
        listeView.setOnItemClickListener((parent, view, position, id) -> {

            // Je crée un Intent pour ouvrir DetailRecetteActivity
            Intent intent = new Intent(this, DetailRecetteActivity.class);

            // Je passe l’ID de la recette sélectionnée à l’Activity suivante
            intent.putExtra("recette_id", id);

            // Je lance l’Activity détail
            startActivity(intent);
        });
    }
}