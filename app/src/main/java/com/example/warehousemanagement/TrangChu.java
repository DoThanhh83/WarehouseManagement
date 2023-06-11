package com.example.warehousemanagement;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.warehousemanagement.user.UserManagers;

public class TrangChu extends AppCompatActivity {

    Button btnDN;
    Button btnDangki;
    LinearLayout usermanager = findViewById(R.id.usermanager);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        usermanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến UserManagementActivity
                Intent intent = new Intent(TrangChu.this, UserManagers.class);
                startActivity(intent);
            }
        });

    }
}