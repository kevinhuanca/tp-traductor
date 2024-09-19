package com.ulp.traductor;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SegundaActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Palabra> palabra;

    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Palabra> getPalabra() {
        if (palabra == null) {
            palabra = new MutableLiveData<>();
        }
        return palabra;
    }

    public void rescatarDatos(Intent intent) {
        Bundle bundle = intent.getBundleExtra("palabra");
        if (bundle != null) {
            Palabra p = bundle.getSerializable("palabra", Palabra.class);
            if (p != null) {
                palabra.setValue(p);
            }
        }
    }

}
