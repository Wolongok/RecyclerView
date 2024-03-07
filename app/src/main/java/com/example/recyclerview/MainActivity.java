package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Makanan_Adapter.ItemClickListener {


    ArrayList<ModelMakanan> makanan = new ArrayList<>();
    int[] gambarMakanan = {R.drawable.soto, R.drawable.ayamgorenggandum, R.drawable.nasgorsurabaya, R.drawable.miekuah, R.drawable.miebandung, R.drawable.capcay, R.drawable.tahu};

    Makanan_Adapter adapter = new Makanan_Adapter(this, makanan);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int statusBarColor = Color.parseColor("#c6c4ab");
        getWindow().setStatusBarColor(statusBarColor);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = window.getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        setMakanan();

        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setMakanan(){
        String[] characterName = getResources().getStringArray(R.array.makanan_txt);
        String[] characterDescription = getResources().getStringArray(R.array.makanan_description_tt);

        for (int i = 0; i<characterName.length; i++){
            makanan.add(new ModelMakanan(characterName[i], characterDescription[i], gambarMakanan[i]));
        }

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(MainActivity.this,ReviewProduct.class);
        intent.putExtra("nama",adapter.getItem(position).getMakananName());
        startActivity(intent);
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getMakananName() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}