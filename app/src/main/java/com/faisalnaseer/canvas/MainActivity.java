package com.faisalnaseer.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faisalnaseer.canvas.views.Chess;

public class MainActivity extends AppCompatActivity {
    Chess chess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chess = new Chess(this);
        setContentView(chess);
    }

    @Override
    protected void onResume() {
        super.onResume();
        chess.onResume();
    }

    @Override
    protected void onPause() {
        chess.onPause();
        super.onPause();
    }
}

