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
public class Funcionario {
    
    // Declaração das variáveis da classe Funcionario
    private String nome;
    private String endereco;
    private String fone;
    private String funcao;
    private String email;
    private String cpf;
    private String sexo;
    private String dept;
    private String dataUlt;
    private String dataProx;
    private String infoAd;
    private int idade;
    private int id;
    private String busca;

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDataUlt() {
        return dataUlt;
    }

    public void setDataUlt(String dataUlt) {
        this.dataUlt = dataUlt;
    }

    public String getDataProx() {
        return dataProx;
    }

    public void setDataProx(String dataProx) {
        this.dataProx = dataProx;
    }

    public String getInfoAd() {
        return infoAd;
    }

    public void setInfoAd(String infoAd) {
        this.infoAd = infoAd;
    }
}
