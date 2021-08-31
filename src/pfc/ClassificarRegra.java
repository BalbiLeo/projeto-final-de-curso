/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;


/**
 *
 * @author Balbicosta
 */
public class ClassificarRegra {
    
    public String risco;
    public String recom;
    
    public String risco(boolean fumo, boolean lombal, boolean hiperten, boolean diabete, String obesid, 
            boolean colest, boolean medicam, boolean convul,boolean infarto, double peso, double imc){
        
        if ( (colest = false) && (hiperten = false) && (medicam = false)&&(imc <= 29.388)){
            risco = "Risco Baixo";
        }else if ((hiperten = true)&&(convul = false)&&(fumo = true)&&(peso >=90)){
            risco = "Risco Alto";
        }else{
            risco = "Risco Alto";
        }
        
        if ((colest = true)&&(diabete=true)&&(peso>94)){
            risco = " Risco Moderado Limitrofe";
        }else if ((infarto=false)&&(obesid.equalsIgnoreCase("Obesidade_Grau_I"))){
            risco = "Risco Moderado Limitrofe";
        }else if ((colest = false)&&(medicam = true)){
            risco = "Risco Moderado Limitrofe";
        }
        
        if ((colest = true)&&(diabete=true)&&(medicam = false)&&(obesid.equalsIgnoreCase("Obesidade_Grau_I"))&&
                (lombal=false)){
            risco = "Risco Moderado";
        }else if ((colest = true)&&(medicam = false)){
            risco = "Risco Moderado";
        }
        
        if (medicam=false){
            risco = "Risco baixo_limitrofe";
        }else{
            risco = "Risco baixo";
        }
        
        return risco;
    }
    /*public void condicao(String valor) throws JessException{
        String Risco="";
        Defrule defrule;
        Rete regra = new Rete();
        regra.executeCommand(("(assert (riscoAl1))"));
        var riscoAl1 = ((valor)+ "=>" + 
                (regra.store(Risco, valor))); 
        regra.executeCommand("(run)");
        Value sum = regra.fetch(Risco);
        String condicao = sum.atomValue(regra.getGlobalContext());
        System.out.println(condicao);
    }*/
}
