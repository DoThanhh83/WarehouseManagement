package com.example.warehousemanagement;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.warehousemanagement.additem.DanhSachImport;
import com.example.warehousemanagement.profile.ProfilePage;
import com.example.warehousemanagement.user.UserManagers;

import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class TrangChu extends AppCompatActivity {

    Button btnDN;
    Button btnDangki;
    LinearLayout usermanager   , btnImport ;
    BottomNavigationView bottomNavigationView;
    ImageView imgImport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        usermanager = findViewById(R.id.usermanager);
        btnImport = findViewById(R.id.btnImport);
        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangChu.this, DanhSachImport.class);
                startActivity(i);
            }
        });
        usermanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến UserManagementActivity
                Intent intent = new Intent(TrangChu.this, UserManagers.class);
                        startActivity(intent);
            }
        });
         bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_apps);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_apps:
                        return true;
//                    case R.id.list_apps:
//                        startActivity(new Intent(getApplicationContext(),
//                                StoreManager.class));
//                        overridePendingTransition(0, 0);
//                        return true;
                    case R.id.info_app:
                        startActivity(new Intent(getApplicationContext(),
                                ProfilePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}