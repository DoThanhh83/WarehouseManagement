package com.example.warehousemanagement;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.warehousemanagement.additem.DanhSachImport;
import com.example.warehousemanagement.profile.ProfilePage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class TrangChu extends AppCompatActivity {

    Button btnDN;
    Button btnDangki;
    ImageView imgImport, imgExport;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imgImport = findViewById(R.id.imgImport);
        imgExport = findViewById(R.id.imgExport);

        imgImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, DanhSachImport.class);
                startActivity(intent);
            }
        });

        imgExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(TrangChu.this, XuatSanPham.class);
                startActivity(intent1);
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_apps);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                public boolean onNavigationItemSelected( MenuItem item) {
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
}
        );
    }
}