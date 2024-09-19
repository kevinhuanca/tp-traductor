package com.ulp.traductor;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private ArrayList<Palabra> listaDePalabras;
    private MutableLiveData<String> mMensaje;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        listaDePalabras = new ArrayList<>();
        listaDePalabras.add(new Palabra("Arbol", "Tree", R.drawable.arbol));
        listaDePalabras.add(new Palabra("Auto", "Car", R.drawable.auto));
        listaDePalabras.add(new Palabra("Gato", "Cat", R.drawable.gato));
        listaDePalabras.add(new Palabra("Oso", "Bear", R.drawable.oso));
        listaDePalabras.add(new Palabra("Perro", "Dog", R.drawable.perro));
    }

    public LiveData<String> getMmensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    public void traducir(String palabra) {
        if (palabra.trim().isEmpty()) {
            mMensaje.setValue("Escribe algo para traducir.");
            return;
        }
        for (Palabra p : listaDePalabras) {
            if (p.getEs().equalsIgnoreCase(palabra.trim())) {
                Intent intent = new Intent(getApplication(), SegundaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("palabra", p);
                intent.putExtra("palabra", bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
                mMensaje.setValue("");
                return;
            }
        }
        mMensaje.setValue("No esta disponible su traduccion.");
    }
}
