package com.example.finalizedcb007993;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class AdminHomeActivity extends AppCompatActivity {


    private CardView addProductcv,addStockcv,adminSignoutcv;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        addProductcv = findViewById(R.id.admin_product_add);
        addStockcv = findViewById(R.id.admin_product_stock);
        adminSignoutcv = findViewById(R.id.admin_signout);
        auth = FirebaseAuth.getInstance();

        addProductcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminHomeActivity.this,AddProductActivity.class));


            }
        });

        addStockcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminHomeActivity.this,AddStockActivity.class));
            }
        });
        adminSignoutcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(AdminHomeActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}