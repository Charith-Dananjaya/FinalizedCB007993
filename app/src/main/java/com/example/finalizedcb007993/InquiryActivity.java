package com.example.finalizedcb007993;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InquiryActivity extends AppCompatActivity {
    EditText editTextSubject,editTextMessage;
    String TextTo;
    Button send,call,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        TextTo= "admin@lookgood.lk";
        call = findViewById(R.id.inquiry_btn_call);
        editTextSubject= findViewById(R.id.inquiry_subject);
        editTextMessage= findViewById(R.id.inquiry_messasge);
        send= findViewById(R.id.inquiry_btn_submit);
        cancel = findViewById(R.id.inquiry_btn_cancel);

        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to= TextTo;
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);


                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                    dial.setData(Uri.parse("tel:0812235611"));
                    startActivity(dial);

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
   }




}