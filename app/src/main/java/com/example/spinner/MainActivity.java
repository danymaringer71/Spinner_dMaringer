package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<CharSequence> ArrayAdapter;

    TextView txt;
    Button save;
    Spinner opcion;

    ArrayList<String> addArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.textView);
        save = (Button)findViewById(R.id.btn_1);
        opcion =(Spinner)findViewById(R.id.planets_spinner);

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        opcion.setAdapter(adapter);
        opcion.setPrompt("Selecciona una opción");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getInput = txt.getText().toString();

                Toast.makeText(getBaseContext(), "Has selccionado un planeta", Toast.LENGTH_SHORT).show();

                if(addArray.contains(getInput))
                {
                    Toast.makeText(getBaseContext(), "Has selccionado el planeta: ", Toast.LENGTH_SHORT).show();
                }
                else if(getInput.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(), "No ha funcionado", Toast.LENGTH_LONG).show();
                }

                else if(!addArray.contains(getInput))
                {
                    addArray.add(getInput);
                    ((TextView)findViewById(R.id.textView)).setText("");
                }

            }
        });
    }
}
