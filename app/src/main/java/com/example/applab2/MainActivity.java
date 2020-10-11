package com.example.applab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button bClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.eName);
        bClick = (Button)findViewById(R.id.bGreet);
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