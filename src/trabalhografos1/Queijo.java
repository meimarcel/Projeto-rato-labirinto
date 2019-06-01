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
public class Queijo extends Vertice {
    public Image imagem;
    public Queijo(int x, int y, Vertice pai, int salto) {
        super(x, y, pai, salto);
        ImageIcon ref = new ImageIcon("res//queijo.png");
        imagem = ref.getImage();
    }
    
}
