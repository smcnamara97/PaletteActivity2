package edu.temple.paletteactivity2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int requestCode = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner color_spinner = (Spinner) findViewById(R.id.spinner);
        final View palette_layout = findViewById(R.id.activity_main_layout);
        String[] myColors = {"Green", "Blue", "Cyan", "Yellow", "Purple", "Grey", "Red"};
        colorAdapter<String> myAdapter = new colorAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,myColors);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color_spinner.setAdapter(myAdapter);
        color_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                palette_layout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));

                Intent launchIntent = new Intent(MainActivity.this,CanvasActivity.class);
                String newcolor = ((TextView) view).getText().toString();
                launchIntent.putExtra("message", newcolor);
                startActivityForResult(launchIntent,requestCode);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    class colorAdapter<S> extends ArrayAdapter{

        public colorAdapter(@NonNull Context context, int resource, String[] myColors) {
            super(context, resource,myColors);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == this.requestCode && resultCode == RESULT_OK){
            Toast.makeText(MainActivity.this,data.getStringExtra("result"),Toast.LENGTH_LONG).show();
        }
    }
}
