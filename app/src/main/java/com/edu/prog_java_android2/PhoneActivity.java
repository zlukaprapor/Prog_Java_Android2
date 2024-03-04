package com.edu.prog_java_android2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneActivity extends AppCompatActivity {

    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phoneEditText = findViewById(R.id.phoneEditText);

        Button phoneButton = findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneData = phoneEditText.getText().toString();
                // Ваша логіка для обробки phoneData та запуску action для Phone
                Toast.makeText(PhoneActivity.this, "Phone Action: " + phoneData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

