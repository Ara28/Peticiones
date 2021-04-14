package com.example.peticiones.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pregunta {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("id_materia_nivel_tema")
    @Expose
    public int id_materia_nivel_tema;
    @SerializedName("texto")
    @Expose
    public String texto;
    @SerializedName("r1")
    @Expose
    public String r1;
    @SerializedName("r2")
    @Expose
    public String r2;
    @SerializedName("r3")
    @Expose
    public String r3;
    @SerializedName("r4")
    @Expose
    public String r4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_materia_nivel_tema() {
        return id_materia_nivel_tema;
    }

    public void setId_materia_nivel_tema(int id_materia_nivel_tema) {
        this.id_materia_nivel_tema = id_materia_nivel_tema;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }
}
