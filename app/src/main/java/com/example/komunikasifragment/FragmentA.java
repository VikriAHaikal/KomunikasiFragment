package com.example.komunikasifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    private EditText editTextData;
    private Button buttonSend;
    private OnDataSendListener dataSendListener;

    // Interface untuk mengirim data ke MainActivity
    public interface OnDataSendListener {
        void onDataSend(String data);
    }

    // Constructor FragmentA dengan listener untuk data send
    public FragmentA(OnDataSendListener listener) {
        this.dataSendListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_a
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // Inisialisasi EditText dan Button
        editTextData = view.findViewById(R.id.editTextData);
        buttonSend = view.findViewById(R.id.buttonSend);

        // Set OnClickListener untuk tombol Send
        buttonSend.setOnClickListener(v -> {
            // Ambil teks dari EditText
            String data = editTextData.getText().toString();

            // Cek jika input tidak kosong
            if (!data.isEmpty()) {
                // Kirim data ke MainActivity
                dataSendListener.onDataSend(data);

                // Kosongkan EditText setelah mengirim data
                editTextData.setText("");
            }
        });

        return view;
    }
}
