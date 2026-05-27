package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.ResultadoSimpson13;
import com.example.demo.Service.Simpson13Service;

@Controller
public class Simpson13Controller {

     @Autowired
    private Simpson13Service service;

    @GetMapping("/simpson13")
    public String inicio(){

        return "simpson13/index";

    }

    @PostMapping("/simpson13/calcular")
    public String calcular(

            @RequestParam String funcion,
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam int n,
            Model model

    ){

        try{

            ResultadoSimpson13 resultado =
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

            return "simpson13/resultado";

        }catch (Exception e){

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            return "simpson13/index";

        }

    }
}
