package com.example.applab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText name;
    private Button bClick;
    private Spinner colorSpinner;

    private Map<String, Integer> colorMap = new HashMap<String, Integer>();

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String selectedColor = parent.getItemAtPosition(pos).toString();

        this.bClick.setBackgroundColor(colorMap.get(selectedColor));
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.eName);
        bClick = findViewById(R.id.bGreet);
        colorSpinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colous_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);
        colorSpinner.setOnItemSelectedListener(this);

        colorMap.put("Red", Color.RED);
        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Magenta", Color.MAGENTA);
        colorMap.put("Green",Color.GREEN);


    }

    public void click(View view)
    {
        switch(view.getId()){
            case R.id.bGreet:
                String name_text = name.getText().toString();
                alert(name_text);
                break;
            default: break;
        }
    }

    public void alert(String name){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final AlertDialog dialog = builder
                .setNegativeButton("Nothing, but in red", null)
                .setPositiveButton("Nothing", null)
                .setMessage("Hello there, " + name + "!")
                .setTitle("Greeting dialog")
                .create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener(){


            @Override
            public void onShow(DialogInterface arg0) {
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
            }
        });
        dialog.show();




    }


}
