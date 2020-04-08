package com.example.sampleanroidfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_main_fragmentContainer, new FragmentA());
        fragmentTransaction.addToBackStack("FRAGMENT_A");
        fragmentTransaction.commit();


        Button removeTransactionBtn = findViewById(R.id.btn_main_remove_transaction);
        removeTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_main_fragmentContainer);
                if (fragment != null) {
                    FragmentTransaction removeTransaction = getSupportFragmentManager().beginTransaction();
                    removeTransaction.remove(fragment);
                    removeTransaction.commit();
                }
            }
        });
    }
}
