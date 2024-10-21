package com.example.komunikasifragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentA.OnDataSendListener {

    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi FragmentB
        fragmentB = new FragmentB();

        // Fragment manager untuk menambahkan fragment ke layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Tambahkan FragmentA dan FragmentB ke dalam container di activity_main.xml
        fragmentTransaction.add(R.id.fragment_container_a, new FragmentA(this));
        fragmentTransaction.add(R.id.fragment_container_b, fragmentB);
        fragmentTransaction.commit();
    }

    // Implementasi interface OnDataSendListener untuk menerima data dari FragmentA
    @Override
    public void onDataSend(String data) {
        // Kirim data ke FragmentB dan perbarui tampilan
        fragmentB.updateData(data);
    }
}
