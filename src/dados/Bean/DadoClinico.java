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
public class DadoClinico extends Anamnese {
    
    // Declaração das variáveis da classe DadoClinico.
    private double peso;
    private double altura;
    private double imc;
    private String dataAval;
    private boolean lombal;
    private boolean probResp;
    private boolean probVasc;
    private boolean alerg;
    private boolean hiperten;
    private boolean diabete;
    private boolean reumat;
    private String obesid;
    private boolean colest;
    private boolean epileps;
    private boolean medicam;
    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getDataAval() {
        return dataAval;
    }

    public void setDataAval(String dataAval) {
        this.dataAval = dataAval;
    }
    
    public boolean getLombal() {
        return lombal;
    }

    public void setLombal(boolean lombal) {
        this.lombal = lombal;
    }

    public boolean getProbResp() {
        return probResp;
    }

    public void setProbResp(boolean probResp) {
        this.probResp = probResp;
    }

    public boolean getProbVasc() {
        return probVasc;
    }

    public void setProbVasc(boolean probVasc) {
        this.probVasc = probVasc;
    }

    public boolean getAlerg() {
        return alerg;
    }

    public void setAlerg(boolean alerg) {
        this.alerg = alerg;
    }

    public boolean getHiperten() {
        return hiperten;
    }

    public void setHiperten(boolean hiperten) {
        this.hiperten = hiperten;
    }

    public boolean getDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean getReumat() {
        return reumat;
    }

    public void setReumat(boolean reumat) {
        this.reumat = reumat;
    }

    public String getObesid() {
        return obesid;
    }

    public void setObesid(String obesid) {
        this.obesid = obesid;
    }

    public boolean getColest() {
        return colest;
    }

    public void setColest(boolean colest) {
        this.colest = colest;
    }

    public boolean getEpileps() {
        return epileps;
    }

    public void setEpileps(boolean epileps) {
        this.epileps = epileps;
    }

    public boolean getMedicam() {
        return medicam;
    }

    public void setMedicam(boolean medicam) {
        this.medicam = medicam;
    }
}
