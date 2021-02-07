/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author josue
 */
public class RegistroAnimal {

    private String nombre;
    private String raza;
    private String etapa;
    private String origen;
    private String tipo;
    private double calcio;
    private double energiaMetabolizable;
    private double fosforo;
    private double lisina;
    private String productoFinal;
    private double proteinaC;

    public RegistroAnimal() {
    }

    public RegistroAnimal(String nombre, String raza, String etapa, String origen, String tipo, double calcio, double energiaMetabolizable, double fosforo, double lisina, String productoFinal, double proteinaC) {
        this.nombre = nombre;
        this.raza = raza;
        this.etapa = etapa;
        this.origen = origen;
        this.tipo = tipo;
        this.calcio = calcio;
        this.energiaMetabolizable = energiaMetabolizable;
        this.fosforo = fosforo;
        this.lisina = lisina;
        this.productoFinal = productoFinal;
        this.proteinaC = proteinaC;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getProductoFinal() {
        return productoFinal;
    }

    public void setProductoFinal(String productoFinal) {
        this.productoFinal = productoFinal;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getEnergiaMetabolizable() {
        return energiaMetabolizable;
    }

    public void setEnergiaMetabolizable(double energiaMetabolizable) {
        this.energiaMetabolizable = energiaMetabolizable;
    }

    public double getProteinaC() {
        return proteinaC;
    }

    public void setProteinaC(double proteinaC) {
        this.proteinaC = proteinaC;
    }

    public double getLisina() {
        return lisina;
    }

    public void setLisina(double lisina) {
        this.lisina = lisina;
    }

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

}
