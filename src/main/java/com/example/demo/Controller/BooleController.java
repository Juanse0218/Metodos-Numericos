package com.example.demo.Controller;

import com.example.demo.Model.ResultadoBoole;
import com.example.demo.Service.BooleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BooleController {

    @Autowired
    private BooleService service;

    @GetMapping("/boole")
    public String vistaBoole() {

        return "boole/index";
    }

    @PostMapping("/boole/calcular")
    public String calcular(

            @RequestParam String funcion,
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam int n,
            Model model

    ) {

        try {

            ResultadoBoole resultado = service.calcular(funcion, a, b, n);

            model.addAttribute("resultado", resultado);

            return "boole/Resultado";

        } catch (RuntimeException e) {

            model.addAttribute(
                    "error",
                    e.getMessage());

            return "boole/index";

        }

    }
}
