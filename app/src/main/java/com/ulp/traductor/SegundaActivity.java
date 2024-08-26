package com.ulp.traductor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ulp.traductor.databinding.ActivityMainBinding;
import com.ulp.traductor.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    private ActivitySegundaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String palabra = getIntent().getStringExtra("traducido");
        int imagen = getIntent().getIntExtra("imagen", 0);

        binding.etPalabraEN.setText(palabra);
        binding.ivImagen.setImageResource(imagen);
    }
}