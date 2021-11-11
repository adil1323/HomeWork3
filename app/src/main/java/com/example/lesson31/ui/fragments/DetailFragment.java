package com.example.lesson31.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson31.R;
import com.example.lesson31.databinding.FragmentDetailBinding;
import com.example.lesson31.ui.adapter.TaskAdapter;
import com.example.lesson31.ui.viewmodel.SharedViewModel;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    TaskAdapter adapter = new TaskAdapter();
    SharedViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater(), container, false);
        ininilize();
        getData();
        return binding.getRoot();
    }


    private void ininilize() {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    private void getData() {
        viewModel.SetPosition(viewModel.position);
        binding.population.setText(viewModel.list.get(viewModel.position).getPopulation());
        binding.arms.setImageResource(viewModel.list.get(viewModel.position).getArms());
    }
}