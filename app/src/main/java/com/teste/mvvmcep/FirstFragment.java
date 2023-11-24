package com.teste.mvvmcep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.mvvmcep.adapter.CepAdapter;
import com.teste.mvvmcep.databinding.FragmentFirstBinding;
import com.teste.mvvmcep.model.Cep;

import java.util.Collections;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private boolean isAllVisible;
    private NavController navController;
    CepAdapter adapter;
    RecyclerView recyclerView;
    boolean erease = false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.deleteFab.setVisibility(View.GONE);
        binding.searchFab.setVisibility(View.GONE);
        binding.searchFabText.setVisibility(View.GONE);
        binding.deleteFabText.setVisibility(View.GONE);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toogleButton();
            }
        });
        binding.searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toogleButton();
                navController = Navigation.findNavController(FirstFragment.this.requireActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.SecondFragment);
            }
        });
        binding.deleteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erease = true;


            }
        });
        configurarRecycler();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void toogleButton() {
        if (!isAllVisible) {
            binding.deleteFab.show();
            binding.searchFab.show();
            binding.searchFabText.setVisibility(View.VISIBLE);
            binding.deleteFabText.setVisibility(View.VISIBLE);

            isAllVisible = true;
        } else {
            binding.deleteFab.hide();
            binding.searchFab.hide();
            binding.searchFabText.setVisibility(View.GONE);
            binding.deleteFabText.setVisibility(View.GONE);
            isAllVisible = false;
        }
    }

    private void configurarRecycler() {
        //Configurando o gerenciador de layout para ser uma lista
        recyclerView = binding.recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        List<Cep> listCep = Cep.listAll(Cep.class);
        Collections.reverse(listCep);
        adapter = new CepAdapter(listCep);
        recyclerView.setAdapter(adapter);
        adapter.getItemCount();
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.HORIZONTAL));
    }
}