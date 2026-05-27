package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Punto;
import com.example.demo.Model.ResultadoSimpson38;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class Simpson38Service {

    public double evaluarFuncion(
            String funcion,
            double x
    ){

        Expression expresion =
                new ExpressionBuilder(funcion)
                        .variable("x")
                        .build()
                        .setVariable("x", x);

        return expresion.evaluate();

    }

    public ResultadoSimpson38 calcular(

            String funcion,
            double a,
            double b,
            int n

    ){

        if(n % 3 != 0){

            throw new RuntimeException(
                    "El numero de intervalos debe ser multiplo de 3"
            );

        }

        double h = (b - a) / n;

        double suma = 0;

        List<Punto> puntos =
                new ArrayList<>();

        List<Double> x =
                new ArrayList<>();

        List<Double> y =
                new ArrayList<>();

        for(int i = 0; i <= n; i++){

            double xi = a + (i * h);

            double yi =
                    evaluarFuncion(funcion, xi);

            puntos.add(
                    new Punto(xi, yi)
            );

            x.add(xi);

            y.add(yi);

            if(i == 0 || i == n){

                suma += yi;

            }else if(i % 3 == 0){

                suma += 2 * yi;

            }else{

                suma += 3 * yi;

            }

        }

        double resultado =
                (3 * h / 8) * suma;

        return new ResultadoSimpson38(

                resultado,
                puntos,
                x,
                y

        );

    }

}
