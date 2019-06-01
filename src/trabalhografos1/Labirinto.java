/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografos1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author marce
 */
public class Labirinto extends JPanel implements ActionListener {
    public String[] labirinto;
    private Image fundo;
    private Image parede;
    private Image piso;
    private Rato rato;
    private Queijo queijo;
    private Timer timer;
    private int lx;
    private int ly;
    private int pos = 0;
    private int k = 0;
    private Vertice[] rota;
    private boolean cond;
    private boolean mickey;
    private boolean cheese;
    private boolean pode = true;
    private String caminho;
    private boolean got1 = false;
    private boolean got2 = true;
    
    
    public Labirinto(int rx, int ry, int qx, int qy,Vertice[] rota,boolean cond,boolean mickey, boolean cheese,String caminho) {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon ref1 = new ImageIcon("res//fundo2.jpg");
        this.fundo = ref1.getImage();
        ImageIcon ref2 = new ImageIcon("res//parede.png");
        this.parede = ref2.getImage();
        ImageIcon ref3 = new ImageIcon("res//piso2.jpg");
        this.piso = ref3.getImage();
        this.rato = new Rato(rx, ry , null, 0);
        this.queijo = new Queijo((qx * 100),(qy * 100),null,0);
        this.mickey = mickey;
        this.cheese = cheese;
        this.rota = rota;
        this.cond = cond;
        this.caminho = caminho;
        labirinto = File.Read(caminho);
        lx = labirinto.length;
        timer = new Timer(500,this);
        timer.start();

    }
    
    @Override
     public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if(k == 0){
            graficos.drawImage(fundo, 0, 0, null);
        }
        for(int i = 0; i < lx; i++) {
            String[] aux = labirinto[i].split(" ");
            ly = aux.length;
            for(int j = 0;j < ly; j++){
                if(aux[j].equals("-1")) {
                    graficos.drawImage(parede, (i*100), (j*100), this);
                }
                else if(aux[j].equals("0")) {
                    graficos.drawImage(piso, (i*100), (j*100), this);
                }
            }
        }
        if (((rato.y*100) != queijo.x) || ((rato.x*100) != queijo.y)) {
            graficos.drawImage(queijo.imagem,queijo.x,queijo.y,this);
        } else {
            got1 = true;
         
        }
        if(rato.troca ) {
            graficos.drawImage(rato.imagem1, (rato.y*100), (rato.x*100), this);
        }else {
            graficos.drawImage(rato.imagem2, (rato.y*100), (rato.x*100), this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(got1 && got2) {
            JOptionPane.showMessageDialog(null,"Mickey Conseguiu Alcançar o QUEIJO!!!!");
            got2 = false;

        }
        try {
            rato.x = rota[pos].x;
            rato.y = rota[pos].y;
            rato.troca = !rato.troca;
            if(pos < rota.length && cond && pode) {
                pos++;
            }
        } catch(Exception e){
           
        }
            k = 1;
            repaint();   
        
        System.out.println(rato.x);
        System.out.println(rato.y);
        if(!cond) {
            JOptionPane.showMessageDialog(null,"Não é possível alcançar o queijo");
            pode = false;
            cond = true;

        }
        if(!cheese) {
            JOptionPane.showMessageDialog(null,"O queijo está em uma armadilha, É CILADA!!.");
            cheese = true;
          
        }
        if(!mickey) {
            JOptionPane.showMessageDialog(null,"Infelizmente Mickey caiu em uma armadilha.");
            mickey = true;

        }
        
        
        
    }
    
}
