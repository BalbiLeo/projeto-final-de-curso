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
public class Tratamento {
    
    // Declaração das variáveis da classe Tratamento
    private String endoc;
    private String fisico;
    private String nutric;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEndoc() {
        return endoc;
    }

    public void setEndoc(String endoc) {
        this.endoc = endoc;
    }

    public String getFisico() {
        return fisico;
    }

    public void setFisico(String fisico) {
        this.fisico = fisico;
    }

    public String getNutric() {
        return nutric;
    }

    public void setNutric(String nutric) {
        this.nutric = nutric;
    }
}
