package com.ulp.traductor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.traductor.databinding.ActivityMainBinding;
import com.ulp.traductor.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {

    private SegundaActivityViewModel mv;
    private ActivitySegundaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv.getPalabra().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.etPalabraEN.setText(palabra.getEn());
                binding.ivImagen.setImageResource(palabra.getImg());
            }
        });
        mv.rescatarDatos(getIntent());

    }
}