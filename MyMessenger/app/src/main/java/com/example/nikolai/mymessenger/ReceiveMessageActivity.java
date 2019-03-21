package com.example.nikolai.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveMessageActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";
    public static void start(Activity activity, String message) {
        Intent intent = new Intent(activity, ReceiveMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = findViewById(R.id.message);
        messageView.setText(messageText);
    }
    public void SendToEmailComponent(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Test Recipient"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test subject");

        emailIntent.putExtra(Intent.EXTRA_TEXT, EXTRA_MESSAGE);

        Intent chooser = Intent.createChooser(emailIntent, "Send message via...");

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(ReceiveMessageActivity.this, "Opening mailing app", Toast.LENGTH_SHORT).show();
            startActivity(chooser);
        } else {
            Toast.makeText(ReceiveMessageActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
