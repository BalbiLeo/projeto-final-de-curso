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
public class Dieta extends Tratamento{
    
    // Declaração das variáveis da classe Tratamento
    private String dietRav;
    private String dietDukan;
    private String dietDash;
    private String dietLowcarb;
    private String dietCetog;

    public String getDietRav() {
        return dietRav;
    }

    public void setDietRav(String dietRav) {
        this.dietRav = dietRav;
    }

    public String getDietDukan() {
        return dietDukan;
    }

    public void setDietDukan(String dietDukan) {
        this.dietDukan = dietDukan;
    }

    public String getDietDash() {
        return dietDash;
    }

    public void setDietDash(String dietDash) {
        this.dietDash = dietDash;
    }

    public String getDietLowcarb() {
        return dietLowcarb;
    }

    public void setDietLowcarb(String dietLowcarb) {
        this.dietLowcarb = dietLowcarb;
    }

    public String getDietCetog() {
        return dietCetog;
    }

    public void setDietCetog(String dietCetog) {
        this.dietCetog = dietCetog;
    }
}
