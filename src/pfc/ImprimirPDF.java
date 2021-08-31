/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.print.PrintException;
import javax.swing.JPanel;

/**
 *
 * @author Balbicosta
 */
public class ImprimirPDF {
    
    // Método para imprimir o relatório de saúde recebendo um JPanel como parâmetro
    public void imprimirPDF(JPanel tela) throws FileNotFoundException, IOException, PrintException, PrinterException{
        PrinterJob ptj = PrinterJob.getPrinterJob();
            ptj.setJobName("Imprimir");
            ptj.setPrintable((Graphics graph, PageFormat pgt, int pag) -> {
                if (pag > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D grp2D = (Graphics2D)graph;
                grp2D.translate(pgt.getImageableX(), pgt.getImageableY());
                tela.paint(graph);
                return Printable.PAGE_EXISTS;
        }); 
        boolean retornaImp = ptj.printDialog();
        if (retornaImp){
            ptj.print();
        }
    }
}
