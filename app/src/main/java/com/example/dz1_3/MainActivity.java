package com.example.dz1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button send;
    private EditText address;
    private EditText theme;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.btn_send);
        address = findViewById(R.id.edit_email);
        theme = findViewById(R.id.edit_theme);
        text = findViewById(R.id.edit_massage);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailClient = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",address.getText().toString(), null));
                mailClient.putExtra(Intent.EXTRA_EMAIL, address.getText().toString());
                mailClient.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                mailClient.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
                startActivity(Intent.createChooser(mailClient,"send"));
            }
        });
    }
}