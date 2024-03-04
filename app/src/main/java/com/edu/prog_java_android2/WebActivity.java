package com.edu.prog_java_android2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private EditText webEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webEditText = findViewById(R.id.webEditText);

        Button webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webData = webEditText.getText().toString();
                // Ваша логіка для обробки webData та запуску action для Web
                Toast.makeText(WebActivity.this, "Web Action: " + webData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

