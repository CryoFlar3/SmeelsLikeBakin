package org.computermentors.smeelslikebakin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textView;
        private ImageView imageView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemText);
            imageView = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            textView.setText(Recipes.names[position]);
            imageView.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
