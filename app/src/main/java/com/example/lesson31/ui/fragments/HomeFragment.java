
package com.example.lesson31.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lesson31.R;
import com.example.lesson31.databinding.FragmentHomeBinding;
import com.example.lesson31.interfaces.OnItemClick;
import com.example.lesson31.model.TaskModel;
import com.example.lesson31.ui.adapter.TaskAdapter;
import com.example.lesson31.ui.viewmodel.SharedViewModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    TaskAdapter adapter = new TaskAdapter();
    SharedViewModel mainViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    private void initId() {
        binding.materialBtn.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Вот ваш Список ", Toast.LENGTH_SHORT).show();
            mainViewModel.fetchData();
            binding.materialBtn.setVisibility(View.GONE);
        });
        mainViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<TaskModel>>() {
            @Override
            public void onChanged(ArrayList<TaskModel> taskModels) {
                adapter.addList(taskModels);
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecView();
        ininilize();
        initId();
        setupListener();
    }

    private void setupListener() {
        adapterClickListener();
    }

    private void adapterClickListener() {
        adapter.setOnItemClick(new OnItemClick() {
            @Override
            public void OnClick(int position) {
                mainViewModel.SetPosition(position);
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_homeFragment_to_detailFragment);

            }
        });
    }

    private void ininilize() {
        mainViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }


    private void initRecView() {
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycler.setAdapter(adapter);
    }

}