/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografos1;

import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class Grafo {
    public ArrayList<Vertice> grafo = new ArrayList<>();
    public void add_vertice(Vertice novo) {
        this.grafo.add(novo);
    }
}
