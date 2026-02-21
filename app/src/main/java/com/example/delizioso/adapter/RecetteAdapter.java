package com.example.delizioso.adapter;

import com.example.delizioso.classes.Recette;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.delizioso.R;
import java.util.List;

// Ici j'ai créé mon propre Adapter pour afficher mes recettes dans la ListView
// Il sert à relier mes objets Recette avec le layout row_recette.xml
public class RecetteAdapter extends BaseAdapter {

    // J'ai besoin du contexte pour accéder aux ressources (layout, images, etc.)
    private final Context ctx;

    // La liste des recettes que je veux afficher
    private final List<Recette> recettes;

    // Constructeur pour recevoir le contexte et la liste
    public RecetteAdapter(Context ctx, List<Recette> recettes) {
        this.ctx = ctx;
        this.recettes = recettes;
    }

    // Ici je retourne le nombre total de recettes
    @Override
    public int getCount() {
        return recettes.size();
    }

    // Ici je retourne la recette à une position donnée
    @Override
    public Object getItem(int position) {
        return recettes.get(position);
    }

    // Ici je retourne l'id de la recette (utile pour les clics par exemple)
    @Override
    public long getItemId(int position) {
        return recettes.get(position).getId();
    }

    // Ici je crée chaque ligne de la ListView
    // Android appelle cette méthode pour afficher chaque élément
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Si aucune vue recyclable n'existe, je crée une nouvelle vue à partir de row_recette.xml
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.row_recette, parent, false);
        }

        // Ici je récupère les composants de ma ligne (image + textes)
        ImageView photo = convertView.findViewById(R.id.imgRecette);
        TextView tvTitre = convertView.findViewById(R.id.tvTitre);
        TextView tvMeta  = convertView.findViewById(R.id.tvMeta);

        // Je récupère la recette correspondant à la position actuelle
        Recette r = recettes.get(position);

        // Ici j'affiche l'image
        photo.setImageResource(r.getPhotoRes());

        // Ici j'affiche le titre
        tvTitre.setText(r.getTitre());

        // Ici j'affiche le temps + le coût formaté
        tvMeta.setText(r.getTempsTotalPrep() + " • " + r.getCoutEstime() + " €");

        return convertView;
    }
}