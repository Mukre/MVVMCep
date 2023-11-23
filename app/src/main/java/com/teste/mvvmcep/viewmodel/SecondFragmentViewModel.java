package com.teste.mvvmcep.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.teste.mvvmcep.R;
import com.teste.mvvmcep.adapter.CepAdapter;
import com.teste.mvvmcep.model.Cep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondFragmentViewModel extends ViewModel {
    public SecondFragmentViewModel() {
        Log.i("SecondViewModel", "ViewModel created");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("SecondViewModel", "ViewModel destroyed");
    }

    public boolean save(String cep){
        if (cep == null || !validateCep(cep))
            return false;
        Cep newCep = new Cep(cep);
        newCep.save();
        return true;
    }
    public boolean validateCep(String cep){
        Pattern p = Pattern.compile("[0-9]{5}[0-9]{3}");
        Matcher m = p.matcher(cep);
        boolean b = m.matches();
        return b;
    }
}
