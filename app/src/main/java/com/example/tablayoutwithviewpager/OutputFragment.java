package com.example.tablayoutwithviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OutputFragment extends Fragment {

    private SharedViewModel viewModel;
    private TextAdapter adapter;
    private TextView noDataText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_output, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_texts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TextAdapter();
        recyclerView.setAdapter(adapter);

        noDataText = view.findViewById(R.id.no_data_text);

        viewModel.getTextList().observe(getViewLifecycleOwner(), list -> {
            adapter.setItems(list);

            if (list == null || list.isEmpty()) {
                noDataText.setVisibility(View.VISIBLE);
            } else {
                noDataText.setVisibility(View.GONE);
            }
        });
    }
}


