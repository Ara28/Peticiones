package com.example.peticiones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peticiones.Interfaz.registro;
import com.example.peticiones.Models.Inicio;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public Button btnAceptar;
    public EditText txtNombreReg;
    public EditText txtApellidoPat;
    public EditText txtApellidoMat;
    public EditText txtNumber;
    public EditText txtCorreoReg;
    public EditText txtPassRegUno;
    public EditText txtPassRegDos;
    public EditText txtUsuario;
    public Button btnInicioReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        txtNombreReg=(EditText)findViewById(R.id.txtNombreReg);
        txtApellidoPat=(EditText)findViewById(R.id.txtApellidoPat);
        txtApellidoMat=(EditText)findViewById(R.id.txtApellidoMat);
        txtNumber=(EditText)findViewById(R.id.txtNumber);
        txtCorreoReg=(EditText)findViewById(R.id.txtCorreoReg);
        txtUsuario= (EditText) findViewById(R.id.txtUsuario);
        txtPassRegUno=(EditText)findViewById(R.id.txtPassRegUno);
        txtPassRegDos=(EditText)findViewById(R.id.txtPassRegDos);
        btnInicioReg = (Button) findViewById(R.id.btnInicioReg);

        btnInicioReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(MainActivity.this, activity_iniciar.class);
                startActivity(siguiente);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceder(txtNombreReg.getText().toString(), txtApellidoPat.getText().toString(), txtApellidoMat.getText().toString(),txtNumber.getText().toString(),txtCorreoReg.getText().toString(), txtUsuario.getText().toString(), txtPassRegUno.getText().toString(), txtPassRegDos.getText().toString());
            }
        });


    }
    private void acceder(String Nombre, String Apeliido_pat, String Apellido_mat, String telefono, String Correo, String Usuario, String Contrasenia, String rContrasenia){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://t27.herokuapp.com/api/").addConverterFactory(GsonConverterFactory.create())
                .build();
        registro reg = retrofit.create(registro.class);
        Call<Inicio> call = reg.crearUsuario(Nombre,Apeliido_pat, Apellido_mat, telefono, Correo, Usuario, Contrasenia, rContrasenia);
        call.enqueue(new Callback<Inicio>() {
            @Override
            public void onResponse(Call<Inicio> call, Response<Inicio> response) {
                if (response.isSuccessful())
                {
                    Inicio res = response.body();
                    if (res.isEstado())
                    {
                        Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_LONG).show();

                        Intent inicializar = new Intent(MainActivity.this, activity_preg.class);
                        startActivity(inicializar);
                    }else
                    {
                        Toast.makeText(MainActivity.this, res.getDetalle()[0], Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Inicio> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}