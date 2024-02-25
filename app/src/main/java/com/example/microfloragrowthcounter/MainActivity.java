package com.example.microfloragrowthcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // fields
    private TextView output;
    private Button button;
    private int count = 0; // microflora counter
    private int preCount = 0; // auxiliary counter of the previous amount of microflora

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Активность доступна для взаимодействия", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Активность не доступна для взаимодействия", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Активность остановлена и пропала с экрана", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Активность унисчтожена", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        outState.putInt("preCount", preCount);
        output.setText("" + count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        preCount = savedInstanceState.getInt("preCount");
        output.setText("" + count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding fields to markup
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);

        // button click processing
        button.setOnClickListener(listener);
    }

    // creating a listener
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            countFibonacci();
            output.setText("" + count);
        }
    };


    private int countFibonacci() {
        if (count == 0 && preCount == 0) {
            count = 1; preCount = 0;
        } if (count == 1 && preCount == 0) {
            count = 1; preCount = 1;
        } else {
            int pre = count;
            count += preCount;
            preCount = pre;
        }
        return count;
    }

}