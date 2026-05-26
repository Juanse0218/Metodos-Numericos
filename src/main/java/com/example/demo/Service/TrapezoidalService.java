package com.example.demo.Service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Punto;
import com.example.demo.Model.ResultadoTrapezoidal;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrapezoidalService {

    public double evaluarFuncion(String funcion, double x) {

        Expression expresion = new ExpressionBuilder(funcion)
                .variable("x")
                .build()
                .setVariable("x", x);

        return expresion.evaluate();
    }

    public ResultadoTrapezoidal calcular(
            String funcion,
            double a,
            double b,
            int n) {

        double h = (b - a) / n;

        double suma = 0;

        List<Punto> puntos = new ArrayList<>();
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();

        for (int i = 0; i <= n; i++) {

            double xi = a + (i * h);

            double fxi = evaluarFuncion(funcion, xi);

            puntos.add(new Punto(xi, fxi));

            x.add(xi);
            y.add(fxi);

            if (i == 0 || i == n) {
                suma += fxi;
            } else {
                suma += 2 * fxi;
            }
        }

        double resultado = (h / 2) * suma;

        return new ResultadoTrapezoidal(
                resultado,
                puntos,
                x,
                y);
    }
}