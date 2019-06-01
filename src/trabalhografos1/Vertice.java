/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografos1;

import java.util.*;
/**
 *
 * @author marce
 */
public class Vertice {
    public int x;
    public int y;
    public Vertice pai;
    public int salto;
    public ArrayList<Vertice> dest = new ArrayList<>();
    
    public Vertice(int x, int y,Vertice pai,int salto) {
        this.x = x;
        this.y = y;
        this.pai = pai;
        this.salto = salto;
    }
    public void add_destino(Vertice novo) {
        this.dest.add(novo);
        novo.dest.add(Vertice.this);
    }
    
    
}
