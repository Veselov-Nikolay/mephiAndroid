package com.example.nikolai.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        Button button = findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    public void sendMessage() {
        EditText message = findViewById(R.id.WriteMessage);
        String messageStr = message.getText().toString();
        ReceiveMessageActivity.start(this, messageStr);
    }

}
