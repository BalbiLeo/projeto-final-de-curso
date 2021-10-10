/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import jess.*;


/**
 *
 * @author Balbicosta
 */
public class ClassificarRegra {
    
    public String risco;
    public String tipo;
    public String temp;
    public String inten;
    public String espec;
    public String alim = "Em caso de doenças como hipertensão, diabetes ou taxas alteradas de colesterol,\n " +
            " \n triglicerídeos ou outros, procure um médico especializado";
    
    public String risco(boolean fumo, boolean lombal, boolean hiperten, boolean diabete, String obesid, 
            boolean colest, boolean medicam, boolean convul,boolean infarto, double peso, double imc){
        
        if ( (colest = false) && (hiperten = false) && (medicam = false)&&(imc <= 29.388)){
            risco = "Risco Baixo";
            tipo = "Resistido / Metabólico";
            temp = " 150 min./Semana "; 
            inten = " Leve ";
            espec = " 50 min. treino Metabólico com 100 minutos de treino resisitido";
            
        }else if ((hiperten = true)&&(convul = false)&&(fumo = true)&&(peso >=90)){
            risco = "Risco Alto";
            tipo = "Resistido / Metabólico";
            temp = " 300 min./Semana "; 
            inten = " Vigorosa ";
            espec = " 200 min. treino Metabólico com 100 minutos de treino resisitido";
            
        }else{
            risco = "Risco Alto";
        }
        
        if ((colest = true)&&(diabete=true)&&(peso>94)){
            risco = " Risco Moderado Limitrofe";
            tipo = "Resistido / Metabólico";
            temp = " 300 min./Semana "; 
            inten = " Moderada a Vigorosa ";
            espec = " 150 min. treino Metabólico com 150 minutos de treino resisitido";
            
            
        }else if ((infarto=false)&&(obesid.equalsIgnoreCase("Obesidade_Grau_I"))){
            risco = "Risco Moderado Limitrofe";
            tipo = "Resistido / Metabólico";
            temp = " 300 min./Semana "; 
            inten = " Moderada a Vigorosa ";
            espec = " 150 min. treino Metabólico com 150 minutos de treino resisitido";
            
        }else if ((colest = false)&&(medicam = true)){
            risco = "Risco Moderado Limitrofe";
            tipo = "Resistido / Metabólico";
            temp = " 300 min./Semana "; 
            inten = " Moderada a Vigorosa ";
            espec = " 150 min. treino Metabólico com 150 minutos de treino resisitido";
        }
        
        if ((colest = true)&&(diabete=true)&&(medicam = false)&&(obesid.equalsIgnoreCase("Obesidade_Grau_I"))&&
                (lombal=false)){
            risco = "Risco Moderado";
            tipo = "Resistido / Metabólico";
            temp = " 250 min./Semana "; 
            inten = " Moderada ";
            espec = " 100 min. treino Metabólico com 150 minutos de treino resisitido";
            
        }else if ((colest = true)&&(medicam = false)){
            risco = "Risco Moderado";
            tipo = "Resistido / Metabólico";
            temp = " 250 min./Semana "; 
            inten = " Moderada ";
            espec = " 100 min. treino Metabólico com 150 minutos de treino resisitido";
        }
        
        if (medicam=false){
            risco = "Risco baixo_limitrofe";
            tipo = "Resistido / Metabólico";
            temp = " 200 min./Semana "; 
            inten = " Leve a Moderada ";
            espec = " 75 min. treino Metabólico com 125 minutos de treino resisitido";
        }else{
            risco = "Risco Baixo";
            tipo = "Resistido / Metabólico";
            temp = " 150 min./Semana "; 
            inten = " Leve ";
            espec = " 50 min. treino Metabólico com 100 minutos de treino resisitido";
        }
        
        return risco;
    }
    
    
    public String condicao(String valor) throws JessException{
        String Risco="";
        Rete regra = new Rete();
        
        regra.executeCommand(("(assert (riscoAl1))"));
        var riscoAl1 = ((valor)+ "=>" + 
                (regra.store(Risco, valor))); 
        regra.executeCommand("(run)");
        Value sum = regra.fetch(Risco);
        String condicao = sum.atomValue(regra.getGlobalContext());
        System.out.println(condicao);
        
        return valor;
    }
}
