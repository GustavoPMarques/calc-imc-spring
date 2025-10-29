package br.fiap.calculadora_imc_spring.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculadoraImcService {

    public BigDecimal calcular(String nome, String altura, String peso) {
        BigDecimal alt = toBigDecimal(altura);
        BigDecimal pes = toBigDecimal(peso);
        BigDecimal resultado = pes.divide((alt.pow(2)),6, RoundingMode.HALF_UP);;

        return resultado;
    }

    private BigDecimal toBigDecimal(String valor) {
        String aux = valor.trim().replace(",",".");
        try {
            return new BigDecimal(aux);
        } catch (Exception e) {
            throw new IllegalArgumentException("Deu xabu!");
        }
    }

}
