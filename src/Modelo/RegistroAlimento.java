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
public class RegistroAlimento {
    private String nombre;
    private String tipo;
    private String parte;
    private String proceso;
    private String calidad;
    private String origen;
    private String tipoAlimento;
    private double costoKg;
    private double energiaMetabolizable;
    private double proteinaC;
    private double lisina;
    private double fosforo;
    private double calcio;

    public RegistroAlimento() {
    }

    public RegistroAlimento(String nombre, String tipo, String parte, String proceso, String calidad, String origen, String tipoAlimento, double costoKg, double energiaMetabolizable, double proteinaC, double lisina, double fosforo, double calcio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.parte = parte;
        this.proceso = proceso;
        this.calidad = calidad;
        this.origen = origen;
        this.tipoAlimento = tipoAlimento;
        this.costoKg = costoKg;
        this.energiaMetabolizable = energiaMetabolizable;
        this.proteinaC = proteinaC;
        this.lisina = lisina;
        this.fosforo = fosforo;
        this.calcio = calcio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

   
    public double getCostoKg() {
        return costoKg;
    }

    public void setCostoKg(double costoKg) {
        this.costoKg = costoKg;
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
