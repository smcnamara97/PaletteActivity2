package edu.temple.paletteactivity2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        final View my_layout = findViewById(R.id.canvas_layout);
        Intent receivedIntent = getIntent();

        String message = receivedIntent.getStringExtra("message");
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);
        my_layout.setBackgroundColor(Color.parseColor(message));

        Intent resultIntent = new Intent();

        resultIntent.putExtra("result","Choose another color.");
        setResult(RESULT_OK,resultIntent);//Do this before you call finish

        findViewById(R.id.messageTextView).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                finish();
            }
        });
    }
}
