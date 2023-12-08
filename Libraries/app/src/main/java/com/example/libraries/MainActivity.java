package com.example.libraries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageView imageView = findViewById(R.id.imageView);
//
//        // built-in image handling
////        imageView.setImageResource(R.drawable.big);
//
//        // Glide image handling
//        Glide
//                .with(this)
//                .load(R.drawable.big)
//                .into(imageView);

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("zapier.pdf")
//                .pages(0, 1, 2, 3, 4, 5)
//                .enableSwipe(true)
//                .swipeHorizontal(true)
//                .enableDoubletap(true)
//                .defaultPage(0)
                .load();
    }
}