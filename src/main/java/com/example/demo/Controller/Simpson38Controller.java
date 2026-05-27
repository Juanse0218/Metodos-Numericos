package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.ResultadoSimpson38;
import com.example.demo.Service.Simpson38Service;

@Controller
public class Simpson38Controller {

    @Autowired
    private Simpson38Service service;

    @GetMapping("/simpson38")
    public String inicio(){

        return "simpson38/Index";

    }

    @PostMapping("/simpson38/calcular")
    public String calcular(

            @RequestParam String funcion,
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam int n,
            Model model

    ){

        try{

            ResultadoSimpson38 resultado =
                    service.calcular(
                            funcion,
                            a,
                            b,
                            n
                    );

            model.addAttribute(
                    "resultado",
                    resultado
            );

            return "simpson38/resultado";

        }catch (Exception e){

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            return "simpson38/Index";

        }

    }
}
