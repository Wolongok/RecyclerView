package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.bumptech.glide.Glide;

class Makanan_Adapter extends RecyclerView.Adapter<Makanan_Adapter.MyViewHolder> {
    private ItemClickListener mClickListener;
    Context context;
    ArrayList<ModelMakanan> makanans;


    public Makanan_Adapter(Context context, ArrayList<ModelMakanan> makanans){
        this.context = context;
        this.makanans = makanans;    }



    @NonNull
    @Override
    public Makanan_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new Makanan_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelMakanan items = this.makanans.get(position);

        holder.makananName.setText(makanans.get(position).getMakananName());
        holder.makananDescription.setText(makanans.get(position).getMakananDescription());
        holder.makananImages.setImageResource(makanans.get(position).getMakananImage());

        Glide.with(holder.itemView.getContext())
                .load(items.getMakananImage())
                .into(holder.makananImages);
    }

    @Override
    public int getItemCount() {
        return makanans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView makananImages;
        TextView makananName, makananDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            makananImages = itemView.findViewById(R.id.makananView);
            makananName = itemView.findViewById(R.id.makananName);
            makananDescription = itemView.findViewById(R.id.makananDescription);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }



        }
        void setClickListener(ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }

        public ModelMakanan getItem(int id) {
            return makanans.get(id);
        }
}
