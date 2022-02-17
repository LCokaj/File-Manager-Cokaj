package com.example.cokajsl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnScrivi;
    Button btnLeggi;
    TextView txtTesto;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeggi=(Button) findViewById(R.id.btnLeggi);
        btnScrivi=(Button) findViewById(R.id.btnScrivi);
        txtTesto=(TextView) findViewById(R.id.txtTesto);
        editText=(EditText) findViewById(R.id.editText);

        Gestore g=new Gestore();

        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTesto.setText(g.leggiFIle("File.txt",getApplicationContext()));

            }

        });
        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito=g.scriviFile("File.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(),esito,Toast.LENGTH_LONG).show();

            }
        });
    }
}