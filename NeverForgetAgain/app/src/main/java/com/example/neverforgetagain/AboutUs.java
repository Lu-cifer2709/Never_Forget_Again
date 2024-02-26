package com.example.neverforgetagain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    ImageView imgLinkedin, imgInstagram, imgTwitter;
    TextView txtEmail, txtWebsiteUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");

        imgLinkedin = findViewById(R.id.imgLinkedin);
        imgInstagram = findViewById(R.id.imgInstagram);
        imgTwitter = findViewById(R.id.imgTwitter);
        txtEmail = findViewById(R.id.txtEmail);
        txtWebsiteUrl = findViewById(R.id.txtWebsiteUrl);

        imgLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navigateToUrl("https://www.linkedin.com/in/vibhor-agrawal-21737522a/");
            }
        });

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "george.phn27@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "From Never Forget Again");
                }catch (ActivityNotFoundException e){
                    System.out.println(e);
                }
            }
        });

        txtWebsiteUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUrl("https://github.com/Lu-cifer2709");
            }
        });

        imgInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUrl("https://www.instagram.com/thelifeof_lucifer1903/");
            }
        });

        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUrl("https://twitter.com/VibhorAgr2709");
            }
        });
    }
    private void navigateToUrl(String url){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}