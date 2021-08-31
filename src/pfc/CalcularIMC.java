/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import static java.lang.Math.pow;
import java.text.DecimalFormat;
/**
 *
 * @author Balbicosta
 */
public class CalcularIMC {
    
    // Objeto dcm com uma casa decimal para tratamento do valor de IMC.
    DecimalFormat dcm = new DecimalFormat("0.00");
    DecimalFormat vgl = new DecimalFormat("0.0");
    // Método para cálculo do IMC do funcionário.
    public double IMC(double peso, double altura) {
        double imc = peso / pow(altura, 2);
        return imc;
    }
    
    // Método para determinação do GRAU DE Obesidade do funcionário.
    public String obesid(double imc) {
        String obesid = "";
        if (imc < 18.5) {
            obesid = "Abaixo do Peso";
        } else if (imc >= 18.5 & imc <= 24.9) {
            obesid = "Peso normal";
        } else if (imc > 24.9 & imc <= 29.9) {
            obesid = "Sobrepeso";
        } else if (imc > 29.9 & imc <= 34.9) {
            obesid = "Obesidade Grau I";
        } else if (imc > 34.9 & imc <= 39.9) {
            obesid = "Obesidade Grau II";
        } else if (imc > 39.9) {
            obesid = "Obesidade Grau III";
        }
        return obesid;
    }
    // Método para tratamento do número de casas decimais informadas no IMC.
    public String formato(Double imc) {
        String IMC = dcm.format(imc);
        return IMC;
    }
}

    

