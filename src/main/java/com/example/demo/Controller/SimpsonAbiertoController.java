package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.ResultadoSimpsonAbierto;
import com.example.demo.Service.SimpsonAbiertoService;

@Controller
public class SimpsonAbiertoController {

    @Autowired
    private SimpsonAbiertoService service;

    @GetMapping("/simpsonAbierto")
    public String inicio(){

        return "SimpsonAbierto/index";

    }

    @PostMapping("/simpsonAbierto/calcular")
    public String calcular(

            @RequestParam String funcion,
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam int n,
            Model model

    ){

        try{

            ResultadoSimpsonAbierto resultado =
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

            return "SimpsonAbierto/Resultado";

        }catch (Exception e){

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            return "SimpsonAbierto/index";

        }

    }
}
