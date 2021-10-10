/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.Bean;

/**
 *
 * @author Balbicosta
 */
public class Anamnese {
   
    // Declaração das variáveis da classe ANAMNESE.
    private boolean admis;
    private boolean demis;
    private boolean perid;
    private boolean apto;
    private boolean inapto;
    private int id;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isAdmis() {
        return admis;
    }

    public void setAdmis(boolean admis) {
        this.admis = admis;
    }

    public boolean isDemis() {
        return demis;
    }

    public void setDemis(boolean demis) {
        this.demis = demis;
    }

    public boolean isPerid() {
        return perid;
    }

    public void setPerid(boolean perid) {
        this.perid = perid;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public boolean isInapto() {
        return inapto;
    }

    public void setInapto(boolean inapto) {
        this.inapto = inapto;
    }
}
