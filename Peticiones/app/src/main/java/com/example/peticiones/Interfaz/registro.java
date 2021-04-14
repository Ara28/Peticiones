package com.example.peticiones.Interfaz;


import com.example.peticiones.Models.Inicio;
import com.example.peticiones.Models.Registro;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface registro {
    @FormUrlEncoded
    @POST("crearUsuarioAppP")
    Call<Inicio>crearUsuario(@Field("nombre")String nombre, @Field("apellido_pat")String apellido_pat, @Field("apellido_mat")String apellido_mat, @Field("telefono")String telefono, @Field("correo")String correo, @Field("usuario")String usuario, @Field("contrasennia") String contrasennia, @Field("rcontrasennia") String rcontrasennia);
}
