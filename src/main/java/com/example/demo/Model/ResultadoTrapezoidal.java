package com.example.demo.Model;

import java.util.List;

public class ResultadoTrapezoidal {

    private double resultado;
    private List<Punto> puntos;
    private List<Double> x;
    private List<Double> y;

    public ResultadoTrapezoidal(double resultado, List<Punto> puntos, List<Double> x, List<Double> y) {
        this.resultado = resultado;
        this.puntos = puntos;
        this.x = x;
        this.y = y;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public List<Double> getX() {
        return x;
    }

    public void setX(List<Double> x) {
        this.x = x;
    }

    public List<Double> getY() {
        return y;
    }

    public void setY(List<Double> y) {
        this.y = y;
    }

    

    

}
