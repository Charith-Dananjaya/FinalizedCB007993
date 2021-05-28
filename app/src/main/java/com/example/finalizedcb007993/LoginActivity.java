package com.example.finalizedcb007993;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText txtusername, txtpassword;
    private Button btnlogin;
    private FirebaseAuth authentication;
    private TextView tvlink;
    private ImageView google,facebook,twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusername = findViewById(R.id.login_txtusername);
        txtpassword = findViewById(R.id.login_txtpassword);
        btnlogin = findViewById(R.id.btnlogin);
        authentication = FirebaseAuth.getInstance();
        tvlink = findViewById(R.id.register_tvlink);
        facebook = findViewById(R.id.fbiv_link);
        google = findViewById(R.id.googleiv_link);
        twitter = findViewById(R.id.twitteriv_link);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/");
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://twitter.com/login?lang=en");
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = txtusername.getText().toString();
                password = txtpassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter both Email and Password!!!", Toast.LENGTH_SHORT).show();

                } else {
                    validateUser(email, password);

                }
            }
        });

        tvlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_reg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(int_reg);
                finish();
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void validateUser(String email, String password) {
        authentication.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Toast.makeText(LoginActivity.this, "Valid User", Toast.LENGTH_SHORT).show();
                if(email.equals("admin@lookgood.lk")){
                    startActivity(new Intent(LoginActivity.this,AdminHomeActivity.class));
                }else {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Invalid Email or Password, Please try again....", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*
        if(FirebaseAuth.getInstance().getCurrentUser()!=null);
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();;

         */
    }


}