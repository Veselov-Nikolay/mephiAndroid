package com.example.nikolai.ulitka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zhmyak = findViewById(R.id.Execute);
        zhmyak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JustDoIt();
            }
        });
    }
    private void JustDoIt()
    {
        EditText editText = findViewById(R.id.WriteMessage);
        String text = editText.getText().toString();
        Main2Activity.start(this, text);
    }
}
