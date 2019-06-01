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
public class BFS {
    
    private Queue<Vertice> fronteira = new LinkedList<>();
    private final int[] x = {0,0,1,-1};
    private final int[] y = {1,-1,0,0};
    public Vertice inicio;
    public Vertice fim;
    public Grafo grafo;
    public boolean[][] teste = new boolean[100][100]; 

    public BFS(Vertice inicio, Vertice fim,Grafo grafo){
        this.inicio = inicio;
        this.fim = fim;
        this.grafo = grafo;

    }

    public boolean buscar(int[][] labirinto) {
        fronteira.add(inicio);
        grafo.add_vertice(inicio);
        teste[inicio.x][inicio.y] = true;
        while(!fronteira.isEmpty()){
            Vertice atual = fronteira.poll();
            for(int i = 0; i < 4; i++) {
                int auxX = atual.x + x[i];
                int auxY = atual.y + y[i];
                if (auxX >= 0 && auxY >= 0  && auxX < labirinto.length && auxY < labirinto[0].length ) {
                    if(labirinto[auxX][auxY] == 0 && teste[auxX][auxY] == false ) {
                        fronteira.add(new Vertice(auxX,auxY,atual,atual.salto+1));
                        grafo.add_vertice(new Vertice(auxX , auxY,atual,atual.salto+1));
                        teste[auxX][auxY] = true;
                        if (auxX == fim.y && auxY == fim.x) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
}
