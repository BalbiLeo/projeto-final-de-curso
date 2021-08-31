/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import java.util.Locale;

/**
 *
 * @author Balbicosta
 */
public class PFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Locale.setDefault(new Locale("pt", "BR"));
        Login login = new Login();
        login.setVisible(true);
    }
    
}
