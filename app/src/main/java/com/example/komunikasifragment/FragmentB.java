package com.example.komunikasifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    private TextView textViewData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_b
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        // Inisialisasi TextView
        textViewData = view.findViewById(R.id.textViewData);

        return view;
    }

    // Method untuk memperbarui data yang dikirim dari FragmentA
    public void updateData(String data) {
        textViewData.setText(data);
    }
}
