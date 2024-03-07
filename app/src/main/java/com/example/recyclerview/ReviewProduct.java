package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class ReviewProduct extends AppCompatActivity {
    ImageView ivGambarProduk;
    TextView tvNamaProduk;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.preview_product);





        ivGambarProduk = findViewById(R.id.ivGambarProduk);
        tvNamaProduk = findViewById(R.id.tvNamaProduk);



        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");

        switch (nama) {
            case "Soto Semarang":
                tvNamaProduk.setText("Soto Semarang");
                Glide.with(this).load(R.drawable.soto).into(ivGambarProduk);
                break;
            case "Ayam Goreng Gandum":
                tvNamaProduk.setText("Ayam Goreng Gandum");
                Glide.with(this).load(R.drawable.ayamgorenggandum).into(ivGambarProduk);
                break;
            case "Nasi Goreng Surabaya":
                tvNamaProduk.setText("Nasi Goreng Surabaya");
                Glide.with(this).load(R.drawable.nasgorsurabaya).into(ivGambarProduk);
                break;
            case "Mi Kuah Tek Tek":
                tvNamaProduk.setText("Mi Kuah Tek Tek");
                Glide.with(this).load(R.drawable.miekuah).into(ivGambarProduk);
                break;
            case "Mi Bandung":
                tvNamaProduk.setText("Mi Bandung");
                Glide.with(this).load(R.drawable.miebandung).into(ivGambarProduk);
                break;
            case "Capcay Kuah":
                tvNamaProduk.setText("Capcay Kuah");
                Glide.with(this).load(R.drawable.capcay).into(ivGambarProduk);
                break;
            case "Tahu Kecap Kacang":
                tvNamaProduk.setText("Tahu Kecap Kacang");
                Glide.with(this).load(R.drawable.tahu).into(ivGambarProduk);
                break;

        }

    }
}
