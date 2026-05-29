package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.ResultadoTrapezoidal;
import com.example.demo.Service.TrapezoidalService;

@Controller
public class TrapezoidalController {

    @Autowired
    private TrapezoidalService service;

    @GetMapping("/trapezoidal")
    public String inicio() {
        return "Trapezoidal/index";
    }

    @PostMapping("/calcular")
    public String calcular(
            @RequestParam String funcion,
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam int n,
            Model model

    ) {

        try {

            ResultadoTrapezoidal resultado = service.calcular(
                    funcion,
                    a,
                    b,
                    n);

            model.addAttribute(
                    "resultado",
                    resultado);

            return "Trapezoidal/Resultado";

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Funcion matematica invalida");

            return "Trapezoidal/index";

        }
    }
}