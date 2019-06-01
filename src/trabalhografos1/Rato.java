/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografos1;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author marce
 */
public class Rato extends Vertice{
   public Image imagem1;
   public Image imagem2;
   public boolean troca = false;
    public Rato(int x,int y,Vertice pai,int salto) {
        super(x, y, pai, salto);
        ImageIcon ref = new ImageIcon("res//rato1.png");
        this.imagem1 = ref.getImage();
        ImageIcon ref2 = new ImageIcon("res//rato2.png");
        this.imagem2 = ref2.getImage();
    } 
}
