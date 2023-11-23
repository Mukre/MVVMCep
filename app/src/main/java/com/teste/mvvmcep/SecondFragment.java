package com.teste.mvvmcep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.teste.mvvmcep.adapter.CepAdapter;
import com.teste.mvvmcep.databinding.FragmentSecondBinding;
import com.teste.mvvmcep.model.Cep;
import com.teste.mvvmcep.viewmodel.SecondFragmentViewModel;

public class SecondFragment extends Fragment {
    SecondFragmentViewModel viewModel;

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(SecondFragmentViewModel.class);

        binding.buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cep = binding.searchEditText.getText().toString();
                if (viewModel.save(cep))
                    Snackbar.make(v, "Salvo!", Snackbar.LENGTH_SHORT).show();
                else
                    Snackbar.make(v, "Não Salvo!", Snackbar.LENGTH_SHORT).show();



            }
        });
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}