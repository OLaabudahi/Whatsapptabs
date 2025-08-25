package com.example.whatsapptabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CallsFragment extends Fragment {
    EditText editText;
    Button saveButton;
    ItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calls, container, false);

        editText = view.findViewById(R.id.editText);
        saveButton = view.findViewById(R.id.saveButton);
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        saveButton.setOnClickListener(v -> {
            String text = editText.getText().toString().trim();
            if (!text.isEmpty()) {
                viewModel.insertItem(text);
                ((MainActivity) getActivity()).switchToChatsTab();
            }
        });

        return view;
    }
}
