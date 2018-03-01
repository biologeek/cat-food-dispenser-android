package io.biologeek.catfeederandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PushCrocketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_crockets);

    final EditText ip = (EditText) findViewById(R.id.editText);

    ip.setText("192.168.0.1");
    final Button button = (Button) findViewById(R.id.toggleButton);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            OkHttpClient client = new OkHttpClient();

            Request req = new Request.Builder().url("http://"+ip.getText()+"/catfeeder/feed").post(null).build();
            Response response = null;
            try {
                response = client.newCall(req).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response != null && response.isSuccessful()) {
                button.setBackgroundColor(getColor(R.color.Red));
            }
        }
    });
    }
}