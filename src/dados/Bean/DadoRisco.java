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
public class DadoRisco extends Anamnese {
    
    // Declaração das variáveis da classe DadoRisco.
    private boolean fumo;
    private boolean alcool;
    private boolean convul;
    private boolean derrame;
    private boolean infarto;
    private boolean isquem;
    private boolean arritm;
    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean getFumo() {
        return fumo;
    }

    public void setFumo(boolean fumo) {
        this.fumo = fumo;
    }

    public boolean getAlcool() {
        return alcool;
    }

    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }

    public boolean getConvul() {
        return convul;
    }

    public void setConvul(boolean convul) {
        this.convul = convul;
    }

    public boolean getDerrame() {
        return derrame;
    }

    public void setDerrame(boolean derrame) {
        this.derrame = derrame;
    }

    public boolean getInfarto() {
        return infarto;
    }

    public void setInfarto(boolean infarto) {
        this.infarto = infarto;
    }

    public boolean getIsquem() {
        return isquem;
    }

    public void setIsquem(boolean isquem) {
        this.isquem = isquem;
    }

    public boolean getArritm() {
        return arritm;
    }

    public void setArritm(boolean arritm) {
        this.arritm = arritm;
    }
}
