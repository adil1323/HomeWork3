package com.example.lesson31.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lesson31.R;
import com.example.lesson31.model.TaskModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    public int position;
    public MutableLiveData<ArrayList<TaskModel>> mutableLiveData = new MutableLiveData<>();
    public ArrayList<TaskModel> list = new ArrayList<>();

    public void setPosition(int position) {
        this.position = position;
    }

    public void fetchData() {
        list.add(new TaskModel("RUSSIA", "Людей 144,1 миллиона", R.drawable.russia, R.drawable.arms_russia));
        list.add(new TaskModel("CHINA", "Людей 1,402 миллиарда", R.drawable.china, R.drawable.arms_china));
        list.add(new TaskModel("USA", "Людей 329,5 миллиона", R.drawable.usa, R.drawable.arms_usa));
        list.add(new TaskModel("JAPAN", "Людей 125,8 миллиона", R.drawable.japan, R.drawable.arms_japan));
        list.add(new TaskModel("ITALY", "Людей 59,55 миллиона ", R.drawable.italy, R.drawable.arms_italy));
        list.add(new TaskModel("SPAIN", "Людей 47,35 миллиона", R.drawable.spain, R.drawable.arms_spain));
        list.add(new TaskModel("KYRGYZSTAN", "Людей 6,592 миллиона", R.drawable.kyrgystan, R.drawable.arms_kyrgyzstan));
        list.add(new TaskModel("UKRAINE ", "Людей 44,13 миллиона", R.drawable.ukraine, R.drawable.arms_ukraine));
        list.add(new TaskModel("KAZAKHSTAN", "Людей 18,75 миллиона", R.drawable.kazakhstan, R.drawable.arms_kazakhstan));
        mutableLiveData.setValue(list);
    }

}
