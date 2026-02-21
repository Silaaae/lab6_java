package com.example.delizioso.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.delizioso.R;
import com.example.delizioso.classes.Recette;
import com.example.delizioso.service.RecetteService;

// Cette Activity affiche le détail complet d’une recette
// Elle reçoit l’ID depuis la liste, récupère la recette
// et affiche toutes ses informations à l’écran
public class DetailRecetteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recette);

        // Ici je récupère l’ID envoyé par l’Activity précédente (via Intent)
        // Si jamais rien n’est envoyé, la valeur par défaut sera -1
        long id = getIntent().getLongExtra("recette_id", -1);

        // Ensuite je vais chercher la recette correspondante dans le service (Singleton)
        Recette recette = RecetteService.getInstance().trouverParId(id);

        // Ici je récupère toutes les vues du layout pour pouvoir les remplir
        ImageView photo        = findViewById(R.id.imgDetail);
        TextView tvTitre       = findViewById(R.id.tvDetailTitre);
        TextView tvMeta        = findViewById(R.id.tvDetailMeta);
        TextView tvIngredients = findViewById(R.id.tvDetailIngredients);
        TextView tvDescription = findViewById(R.id.tvDetailDescription);
        TextView tvEtapes      = findViewById(R.id.tvDetailEtapes);

        // Si la recette existe, je remplis toutes les informations
        if (recette != null) {

            photo.setImageResource(recette.getPhotoRes());
            tvTitre.setText(recette.getTitre());

            // Ici j’affiche le temps de préparation + le coût formaté
            tvMeta.setText(recette.getTempsTotalPrep() + " • " + recette.getCoutEstime() + " €");

            tvIngredients.setText(recette.getListeIngredients());
            tvDescription.setText(recette.getResumeCourt());
            tvEtapes.setText(recette.getInstructionsCuisson());

        } else {
            // Cas de sécurité : si l’ID ne correspond à aucune recette
            tvTitre.setText("Recette introuvable !");
        }
    }
}