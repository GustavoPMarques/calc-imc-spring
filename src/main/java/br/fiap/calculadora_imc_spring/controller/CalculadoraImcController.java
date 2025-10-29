package br.fiap.calculadora_imc_spring.controller;


import br.fiap.calculadora_imc_spring.service.CalculadoraImcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CalculadoraImcController {
    private CalculadoraImcService service;

    public CalculadoraImcController(CalculadoraImcService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public String calcular (@RequestParam String nome, @RequestParam String altura, @RequestParam String peso, Model model) {
        BigDecimal resultado = null;
        String erro = "";

        try {
            resultado = service.calcular(nome, altura, peso);
        }
        catch (Exception e) {
            erro = e.getMessage();
        }
        model.addAttribute("resultado", resultado);
        model.addAttribute("erro",erro);
        model.addAttribute("nome",nome);
        model.addAttribute("altura",altura);
        model.addAttribute("peso",peso);
        return "index";
    }
}
