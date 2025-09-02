package com.example.tablayoutwithviewpager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<String>> textList = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<String>> getTextList() {
        return textList;
    }

    public void addText(String newText) {
        List<String> currentList = textList.getValue();
        if (currentList != null) {
            currentList.add(newText);
            textList.setValue(currentList);
        }
    }
}
