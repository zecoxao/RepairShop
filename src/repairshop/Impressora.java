/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repairshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author zecoxao
 */
public class Impressora implements Printable {

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex != 0) {
            return NO_SUCH_PAGE;
        }
        BufferedImage img;
        try {
            img = ImageIO.read(new File("C:\\pic\\euarranjo.jpg"));
            graphics.drawImage(img, 25, 25, null);
        } catch (IOException ex) {
            Logger.getLogger(RepairShopView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setFont(new Font("Serif", Font.PLAIN, 12));
        g2.setPaint(Color.black);
        // x , y
        g2.drawString("ID da Ficha:" + RepairShopView.ficha_id, 100, 100);
        g2.drawString("Nome:" + RepairShopView.nome, 100, 125);
        g2.drawString("Equipamento:" + RepairShopView.equipamento.toString(), 100, 150);
        g2.drawString("Contacto:" + RepairShopView.contacto.toString(), 100, 175);
        g2.drawString("Orçamento:" + RepairShopView.orcamento.toString(), 100, 200);
        g2.drawString("Pagamento de Caução:" + RepairShopView.caucao, 100, 225);
        
            g2.drawString("Descrição da Avaria:" , 350, 125);
            g2.drawString(RepairShopView.avaria,350,150);
        
        g2.drawString("Data da Entrega:" + RepairShopView.data_entrega, 350, 175);
        g2.setFont(new Font("Serif", Font.PLAIN, 8));
        g2.drawString("Não nos responsabilizamos por avarias não relatadas pelo cliente de que nada tenham a ver com a reparação", 100, 250);
        g2.drawString("Quando a reparação for efectuada será enviado um sms para o contacto do cliente,se este não levantar o equipamento no prazo de sete dias", 100, 275);
        g2.drawString("o estabelecimento poderá cobrar aluguer de espaço de armazenamento por uma taxa de 2€/dia", 100, 300);
        //g2.drawString("", 100, 300);
        //g2.drawString("", 100, 325);
        g2.setFont(new Font("Serif", Font.PLAIN, 12));
        g2.drawString("                                                                                                O RESPONSÁVEL  ", 100, 350);
        g2.drawString("                                                                                    ___________________________", 100, 375);




        g2.drawString("ID da Ficha:" + RepairShopView.ficha_id, 100, 475);
        g2.drawString("Nome:" + RepairShopView.nome, 100, 500);
        g2.drawString("Equipamento:" + RepairShopView.equipamento, 100, 525);
        g2.drawString("Contacto:" + RepairShopView.contacto, 100, 550);
        g2.drawString("Orçamento:" + RepairShopView.orcamento, 100, 575);
        g2.drawString("Pagamento de Caução:" + RepairShopView.caucao, 100, 600);
        
            g2.drawString("Descrição da Avaria:", 350, 475);
            g2.drawString(RepairShopView.avaria,350,500);
        
        g2.drawString("Data da Entrega:" + RepairShopView.data_entrega, 350, 525);
        g2.setFont(new Font("Serif", Font.PLAIN, 8));
        g2.drawString("Não nos responsabilizamos por avarias não relatadas pelo cliente de que nada tenham a ver com a reparação", 100, 625);
        g2.drawString("Quando a reparação for efectuada será enviado um sms para o contacto do cliente, se este não levantar o equipamento no prazo de sete dias ", 100, 650);
        g2.drawString("o estabelecimento poderá cobrar aluguer de espaço de armazenamento por uma taxa de 2€/dia", 100, 675);
        //g2.drawString("", 100, 675);
        //g2.drawString("", 100, 700);
        g2.setFont(new Font("Serif", Font.PLAIN, 12));
        g2.drawString("                O CLIENTE                ", 100, 725);
        g2.drawString("       ___________________________       ", 100, 750);
        return PAGE_EXISTS;
    }
    
}
