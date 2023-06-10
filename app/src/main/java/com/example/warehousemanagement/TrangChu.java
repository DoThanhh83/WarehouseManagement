package com.example.warehousemanagement;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class TrangChu extends AppCompatActivity {

    Button btnDN;
    Button btnDangki;
    ImageView imgImport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imgImport = findViewById(R.id.imgImport);
        imgImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, NhapSanPham.class);
                startActivity(intent);
            }
        });

    }
}