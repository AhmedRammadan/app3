package com.example.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView title,descrpition;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar =getSupportActionBar();

        title = findViewById(R.id.dtitle);
        descrpition = findViewById(R.id.ddescrpition);
        image = findViewById(R.id.dimageView);

        Intent intent =getIntent();
        String mtitle=intent.getStringExtra("iTitle");
        String mDesc=intent.getStringExtra("iDesc");

        byte[] mBytes =getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        //set title for action bar
        actionBar.setTitle(mtitle);
        //set data

        title.setText(mtitle);
        descrpition.setText(mDesc);
        image.setImageBitmap(bitmap);

    }
}
