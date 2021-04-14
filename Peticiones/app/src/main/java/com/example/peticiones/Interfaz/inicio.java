package com.example.peticiones.Interfaz;

import com.example.peticiones.Models.Inicio;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface inicio {
    @FormUrlEncoded
    @POST("iniciarSesionAppP")
    Call<Inicio> acceder(@Field("correo")String correo, @Field("contrasennia")String contrasenia);
}
