package com.edu.prog_java_android2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

    private EditText mapEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapEditText = findViewById(R.id.mapEditText);

        Button mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapData = mapEditText.getText().toString();
                // Ваша логіка для обробки mapData та запуску action для Map
                Toast.makeText(MapActivity.this, "Map Action: " + mapData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

