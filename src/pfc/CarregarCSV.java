/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import dados.Bean.Anamnese;
import dados.Bean.DadoClinico;
import dados.Bean.DadoRisco;
import dados.Bean.Funcionario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import pfcDAO.anamneseDAO;
import pfcDAO.dadoClinicoDAO;
import pfcDAO.dadoRiscoDAO;
import pfcDAO.funcionarioDAO;

/**
 *
 * @author Balbicosta
 */
public class CarregarCSV {
    
    
    // Instanciamento das classes bean e DAO para funcionários
    funcionarioDAO fDAO = new funcionarioDAO();
    anamneseDAO aDAO = new anamneseDAO();
    dadoRiscoDAO riscoDAO = new dadoRiscoDAO();
    dadoClinicoDAO cliDAO = new dadoClinicoDAO();
    Funcionario func = new Funcionario();
    Anamnese anam = new Anamnese();
    DadoRisco dadoris = new DadoRisco();
    DadoClinico dadocli = new DadoClinico();
    CalcularIMC cIMC = new CalcularIMC();

    private static boolean trueFalse(String Bol, boolean X) {
        X = Bol.equalsIgnoreCase("1");
        return X;
    }
    
    // Método de carregamento de arquivo CSV chamado na ação do JButton.
    public void carregarCSV(String cam, File arq) throws FileNotFoundException {
        
        String linha;
        BufferedReader csv = new BufferedReader(new FileReader(cam));
        try {
            // Loop para leitura de todas as linhas do arquivo CSV.
            while ((linha = csv.readLine()) != null) {
                String[] lista = linha.split(";");
                
                // Carregamento dos dados pessoais vindos do CSV no banco de dados.
                int Id = Integer.valueOf(lista[0]);
                func.setId(Id);
                String Nome = lista[1];
                func.setNome(Nome);
                String Endereco = lista[2];
                func.setEndereco(Endereco);
                String Fone = lista[3];
                func.setFone(Fone);
                String Funcao = lista[4];
                func.setFuncao(Funcao);
                String Email = lista[5];
                func.setEmail(Email);
                String CPF = lista[6];
                func.setCpf(CPF);
                String Sexo = lista[7];
                func.setSexo(Sexo);
                String Dept = lista[8];
                func.setDept(Dept);
                String DataUlt = lista[9];
                func.setDataUlt(DataUlt);
                String DataProx = lista[10];
                func.setDataProx(DataProx);
                String InfoAd = lista[11];
                func.setInfoAd(InfoAd);
                int Idad = Integer.valueOf(lista[12]);
                func.setIdade(Idad);

                // Chamada do método para salvar os dados na classe de Data Access Object funcionarioDAO.
                fDAO.saveData(func);

                // Carregamento do tipo de exame vindo do CSV no banco de dados.
                anam.setId(Integer.valueOf(lista[0]));

                String admis = lista[13];
                boolean Admis = false;
                Admis = trueFalse(admis, Admis);
                anam.setAdmis(Admis);

                String demis = lista[14];
                boolean Demis = false;
                Demis = trueFalse(demis, Demis);
                anam.setDemis(Demis);

                String perid = lista[15];
                boolean Perid = false;
                Perid = trueFalse(perid, Perid);
                anam.setPerid(Perid);

                String apt = lista[16];
                boolean Apt = false;
                Apt = trueFalse(apt, Apt);
                anam.setApto(Apt);

                String inapt = lista[17];
                boolean Inapt = false;
                Inapt = trueFalse(inapt, Inapt);
                anam.setInapto(Inapt);

                // Chamada do método para salvar os dados na classe de Data Access Object anamneseDAO.
                aDAO.saveData(anam);

                // Registra no banco os dados de risco (antecedentes familiares).
                dadoris.setId(Integer.valueOf(lista[0]));
                String fumo = lista[18];
                boolean Fumo = false;
                Fumo = trueFalse(fumo, Fumo);
                dadoris.setFumo(Fumo);

                String alcool = lista[19];
                boolean Alcool = false;
                Alcool = trueFalse(alcool, Alcool);
                dadoris.setAlcool(Alcool);

                String convul = lista[20];
                boolean Convul = false;
                Convul = trueFalse(convul, Convul);
                dadoris.setConvul(Convul);

                String avc = lista[21];
                boolean Avc = false;
                Avc = trueFalse(avc, Avc);
                dadoris.setDerrame(Avc);

                String infart = lista[22];
                boolean Infart = false;
                Infart = trueFalse(infart, Infart);
                dadoris.setInfarto(Infart);

                String isquem = lista[23];
                boolean Isquem = false;
                Isquem = trueFalse(isquem, Isquem);
                dadoris.setIsquem(Isquem);

                String arritm = lista[24];
                boolean Arritm = false;
                Arritm = trueFalse(arritm, Arritm);
                dadoris.setArritm(Arritm);

                // Chamada do método para salvar os dados na classe de Data Access Object dadoRiscoDAO.
                riscoDAO.saveData(dadoris);

                // Registra no banco os dados de risco (antecedentes pessoais).
                dadocli.setId(Integer.valueOf(lista[0]));
                String DataAval = String.valueOf(lista[25]);
                dadocli.setDataAval(DataAval);

                String alerg = lista[26];
                boolean Alerg = false;
                Alerg = trueFalse(alerg, Alerg);
                dadocli.setAlerg(Alerg);

                String medic = lista[27];
                boolean Medic = false;
                Medic = trueFalse(medic, Medic);
                dadocli.setMedicam(Medic);

                String hiper = lista[28];
                boolean Hiper = false;
                Hiper = trueFalse(hiper, Hiper);
                dadocli.setHiperten(Hiper);

                String diab = lista[29];
                boolean Diab = false;
                Diab = trueFalse(diab, Diab);
                dadocli.setDiabete(Diab);

                String reumat = lista[30];
                boolean Reumat = false;
                Reumat = trueFalse(reumat, Reumat);
                dadocli.setReumat(Reumat);

                String epileps = lista[31];
                boolean Epileps = false;
                Epileps = trueFalse(epileps, Epileps);
                dadocli.setEpileps(Epileps);

                String lombal = lista[32];
                boolean Lombal = false;
                Lombal = trueFalse(lombal, Lombal);
                dadocli.setLombal(Lombal);

                String resp = lista[33];
                boolean Resp = false;
                Resp = trueFalse(resp, Resp);
                dadocli.setProbResp(Resp);

                String vasc = lista[34];
                boolean Vasc = false;
                Vasc = trueFalse(vasc, Vasc);
                dadocli.setProbVasc(Vasc);

                String colest = lista[35];
                boolean Colest = false;
                Colest = trueFalse(colest, Colest);
                dadocli.setColest(Colest);

                String Peso = String.valueOf(lista[36].replace(",", "."));
                double PESO = Double.valueOf(Peso);
                dadocli.setPeso(PESO);
                String Altura = String.valueOf(lista[37].replace(",", "."));
                double ALTURA = Double.valueOf(Altura);
                dadocli.setAltura(ALTURA);

                //Chamada do método de cálculo de IMC e tratamento de número de casas decimais na classe CalcularIMC 
                String Imc = String.valueOf(lista[38].replace(",", "."));
                double IMC = Double.valueOf(Imc.replace(",", "."));
                dadocli.setImc(IMC);
                String Obesid = lista[39];
                dadocli.setObesid(Obesid);
                
                // Chamada do método para salvar os dados na classe de Data Access Object dadoClinicoDAO.
                cliDAO.saveData(dadocli);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
