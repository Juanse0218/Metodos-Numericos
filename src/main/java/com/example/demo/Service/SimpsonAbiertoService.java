package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Punto;
import com.example.demo.Model.ResultadoSimpsonAbierto;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class SimpsonAbiertoService {

    public double evaluarFuncion(
            String funcion,
            double x) {

        Expression expresion = new ExpressionBuilder(funcion)
                .variable("x")
                .build()
                .setVariable("x", x);

        return expresion.evaluate();

    }

    public ResultadoSimpsonAbierto calcular(

            String funcion,
            double a,
            double b,
            int n

    ) {

        if (n % 2 != 0) {

            throw new RuntimeException(
                    "El numero de particiones debe ser par");

        }

        double h = (b - a) / (n + 2);

        double suma = 0;

        List<Punto> puntos = new ArrayList<>();

        List<Double> x = new ArrayList<>();

        List<Double> y = new ArrayList<>();

        for (int i = 1; i <= n + 1; i++) {

            double xi = a + (i * h);

            double yi = evaluarFuncion(funcion, xi);

            puntos.add(
                    new Punto(xi, yi));

            x.add(xi);

            y.add(yi);

            if (i % 2 == 0) {

                suma += 2 * yi;

            } else {

                suma += 4 * yi;

            }

        }

        double resultado = (4 * h / 3) * suma;

        return new ResultadoSimpsonAbierto(

                resultado,
                puntos,
                x,
                y

        );

    }

}
