package com.example.peticiones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peticiones.Interfaz.inicio;
import com.example.peticiones.Models.Inicio;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_iniciar extends AppCompatActivity {
    public Button btnIngresar;
    public EditText txtCorreoIniciar;
    public EditText txtPasswordIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        txtCorreoIniciar = (EditText) findViewById(R.id.txtCorreoIniciar);
        txtPasswordIniciar = (EditText) findViewById(R.id.txtPasswordIniciar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acceder(txtCorreoIniciar.getText().toString(), txtPasswordIniciar.getText().toString());
            }
        });
    }
    private void acceder(String Correo, String Contrasenia) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://t27.herokuapp.com/api/").addConverterFactory(GsonConverterFactory.create())
                .build();
        inicio ini = retrofit.create(inicio.class);
        Call<Inicio> call =ini.acceder(Correo, Contrasenia);
        call.enqueue(new Callback<Inicio>() {
            @Override
            public void onResponse(Call<Inicio> call, Response<Inicio> response) {
                if (response.isSuccessful())
                {
                    Inicio respuesta = response.body();
                    if(respuesta.isEstado())
                    {
                        Intent pregunta = new Intent(activity_iniciar.this,activity_preg.class);
                        startActivity(pregunta);
                    }
                    Toast.makeText(activity_iniciar.this, respuesta.getDetalle()[0], Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inicio> call, Throwable t) {
                Toast.makeText(activity_iniciar.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

