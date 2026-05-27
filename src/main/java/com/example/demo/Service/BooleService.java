package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Punto;
import com.example.demo.Model.ResultadoBoole;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooleService {
     public double evaluarFuncion(String funcion, double x) {

        Expression expresion = new ExpressionBuilder(funcion)
                .variable("x")
                .build()
                .setVariable("x", x);

        return expresion.evaluate();
    }

    public ResultadoBoole calcular(
            String funcion,
            double a,
            double b,
            int n
    ) {

        if(n % 4 != 0){
            throw new RuntimeException(
                    "El numero de intervalos debe ser multiplo de 4"
            );
        }

        double h = (b - a) / n;

        double suma = 0;

        List<Punto> puntos = new ArrayList<>();
        List<Double> xValores = new ArrayList<>();
        List<Double> yValores = new ArrayList<>();

        for(int i = 0; i <= n; i++){

            double xi = a + (i * h);

            double yi = evaluarFuncion(funcion, xi);

            puntos.add(new Punto(xi, yi));

            xValores.add(xi);
            yValores.add(yi);
        }

        for(int i = 0; i < n; i += 4){

            double f0 = yValores.get(i);
            double f1 = yValores.get(i + 1);
            double f2 = yValores.get(i + 2);
            double f3 = yValores.get(i + 3);
            double f4 = yValores.get(i + 4);

            suma += (2 * h / 45) * (
                    7 * f0
                    + 32 * f1
                    + 12 * f2
                    + 32 * f3
                    + 7 * f4
            );
        }

        return new ResultadoBoole(
                suma,
                puntos,
                xValores,
                yValores
        );
    } 
}