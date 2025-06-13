package com.ema.conversor.modelos;

public class Conversion {

    private String monedaInicial;
    private String monedaConvertir;
    private Double cantidad;
    private Double cotizacion;
    private Double resultado;
    private String fecha;

    public Conversion (String monedaInicial, String monedaConvertir, double cantidad, double cotizacion, double resultado, String fecha){
        this.monedaInicial = monedaInicial;
        this.monedaConvertir = monedaConvertir;
        this.cantidad = cantidad;
        this.cotizacion = cotizacion;
        this.resultado = resultado;
        this.fecha = fecha;
    }
    public Conversion(ConversionApi conversion,double cantidad){
        this.monedaInicial = conversion.base_code();
        this.monedaConvertir = conversion.tarjet_code();
        this.cantidad = cantidad;
        this.cotizacion = conversion.conversion_rate();
        this.resultado = conversion.conversion_result();
        this.fecha = conversion.time_last_update_utc();
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public void setMonedaInicial(String monedaInicial) {
        this.monedaInicial = monedaInicial;
    }

    public String getMonedaConvertir() {
        return monedaConvertir;
    }

    public void setMonedaConvertir(String monedaConvertir) {
        this.monedaConvertir = monedaConvertir;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public void getConversion() {
        System.out.println("El valor de "+this.cantidad+" ["+this.monedaInicial+"] "+"corresponde al valor final de =>> "+this.resultado+" ["+this.monedaConvertir+"]"+" Fecha: "+ this.fecha);
    }
}
