package com.example.whatsapptabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class StatusFragment extends Fragment {
    TextView countText;
    ItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        countText = view.findViewById(R.id.countText);

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        viewModel.getCount().observe(getViewLifecycleOwner(), count -> {
            countText.setText("عدد الرسائل المحفوظة: " + count);
        });

        return view;
    }
}