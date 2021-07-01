package com.example.consultasapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnPesquisar;
    TextView lblResultado;
    EditText txtRastreio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPesquisar = findViewById(R.id.btnConsultaCEP);
        txtRastreio = findViewById(R.id.txtConsulta);
        lblResultado = findViewById(R.id.lblRetorno);

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String[] args = new String[3];
                    args[0] = "post"; //method
                    args[1] = "https://correios.contrateumdev.com.br/api/rastreio"; //url

                    JSONObject body = new JSONObject();
                    body.put("code", txtRastreio.getText());
                    body.put("type", "LS");

                    args[2] = body.toString(); //body in json

                    ApiTask task = new ApiTask(lblResultado);
                    task.execute(args);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}