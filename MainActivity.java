package com.example.taraskin_pz2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lasting;
    private Button nexting;
    private Button randomimg;
    private ImageView img;
    private TextView textView;
    private TextView imageName;
    private int[] p = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
    private String[] names = {"Картинка A", "Картинка B", "Картинка C", "Картинка D", "Картинка E"};
    private int Index = 0;
    private int count = p.length - 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }
    private void init() {
        lasting = (Button) findViewById(R.id.lastimg);
        lasting.setOnClickListener(this);
        nexting = (Button) findViewById(R.id.nextimg);
        nexting.setOnClickListener(this);
        randomimg = (Button) findViewById(R.id.randomimg);
        randomimg.setOnClickListener(this);
        img = (ImageView) findViewById(R.id.img);
        textView = (TextView) findViewById(R.id.textView);
        imageName = (TextView) findViewById(R.id.imageName);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.lastimg) {
            if (Index == 0) {
                Index = count;
            } else {
                Index = Index - 1;
            }
        } else if (id == R.id.nextimg) {
            if (Index == count) {
                Index = 0;
            } else {
                Index = Index + 1;
            }
        } else if (id == R.id.randomimg) {
            Index = new Random().nextInt(p.length);
        }

        img.setImageResource(p[Index]);
        textView.setText(Integer.toString(Index + 1) + "/" + p.length);
        imageName.setText(names[Index]);
    }
}