package com.example.tablayoutwithviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class InputFragment extends Fragment {

    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        EditText editText = view.findViewById(R.id.edit_text);
        Button sendButton = view.findViewById(R.id.btn_send);

        sendButton.setOnClickListener(v -> {
            String text = editText.getText().toString().trim();
            if (!text.isEmpty()) {
                viewModel.addText(text);
                editText.setText("");


                Toast.makeText(getContext(), "Sent successfully ", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(getContext(), "Please write text before sending ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

