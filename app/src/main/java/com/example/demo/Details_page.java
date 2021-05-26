package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import static com.example.demo.Demo.DESC;
import static com.example.demo.Demo.Image;
import static com.example.demo.Demo.NAME;

public class Details_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView name,des;
        ImageView image,back;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_about);
        name=findViewById(R.id.name);
        des=findViewById(R.id.description);
        image=findViewById(R.id.image);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Details_page.this.finish();
            }
        });

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(Image);
        String Name = intent.getStringExtra(NAME);
        String Desc = intent.getStringExtra(DESC);
        name.setText(Name);
        des.setText(Desc);
        Picasso.get().load(imageUrl).fit().centerInside().placeholder(R.drawable.background_login1).into(image);

    }
}