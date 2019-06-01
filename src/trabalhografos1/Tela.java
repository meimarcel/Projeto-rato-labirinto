/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografos1;


import javax.swing.*;
/**
 *
 * @author marce
 */

public class Tela extends JFrame {
    public int rx ;
    public int ry ;
    public int qx ;
    public int qy ;
    private Grafo grafo;
    private Vertice[] rota;
    private String[] file;
    private int[][] matriz;
    private boolean condition = true;
    private boolean mickey = true;
    private boolean cheese = true;
    private String caminho;
    
    private javax.swing.JButton jButton1;
    
    public Tela(int rx, int ry, int qx, int qy, String caminho) {
        setVisible(true);
        this.rx = rx;
        this.ry = ry;
        this.qx = qx;
        this.qy = qy;
        this.caminho = caminho;
        buscar();
        jButton1 = new javax.swing.JButton();
        getContentPane().add(jButton1);
        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Forte", 0, 50)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Voltar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));
        jButton1.setPreferredSize(new java.awt.Dimension(111, 77));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(1700, 100, 170, 50);
        add(new Labirinto(rx,ry,qx,qy,rota,condition,mickey,cheese,caminho));
        setTitle("Labirinto");
        setSize(1900,1000);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void buscar() {
        file = File.Read(caminho);
        int lx = file.length;
        int ly = file[0].split(" ").length;
        matriz = new int[ly][lx];
        for(int i = 0; i < lx; i++) {
            String[] aux = file[i].split(" ");
            ly = aux.length;
            for(int j = 0;j < ly; j++){
                matriz[j][i] = Integer.parseInt(aux[j]);
            }
        }
        
        for(int i = 0; i < ly; i++) {
            for(int j = 0;j < lx; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
        
        grafo = new Grafo();
        Vertice inicio = new Vertice(rx,ry,null,0);
        Vertice fim = new Vertice(qx,qy,null,0);
        
        BFS bfs = new BFS(inicio,fim,grafo);
        condition = bfs.buscar(matriz);
        if(matriz[rx][ry] == -1 && matriz[qy][qx] == 0){
            mickey = false;
            condition = false;
        }
        else if(matriz[qy][qx] == -1 && matriz[rx][ry] == 0 ){
            cheese = false;
            condition = false;
        }
        else if(matriz[rx][ry] == -1 && matriz[qy][qx] == -1) {
            mickey = false;
            cheese = false;
            condition = false;
        } 
        Pilha pilha = new Pilha();
        Vertice atual =(Vertice) grafo.grafo.get(grafo.grafo.size()-1);
        System.out.println(grafo.grafo.size());
        int cont = 1;
        for(Vertice  k : grafo.grafo){
            System.out.println(k.x);
            System.out.println(k.y);
            System.out.println();
        }
        while(atual != null) {
            pilha.push(atual);
            System.out.println("pilha:"+atual.x);
            System.out.println("pilha:"+atual.y);
            cont++;
            atual = atual.pai;
        }
        rota = new Vertice[cont];
        cont = pilha.cont;
        for(int i = 0; i < cont; i++) {
            rota[i] = pilha.pop();
        System.out.println("rota:"+rota[i].x);
        System.out.println("rota:"+rota[i].y);
        }
        
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Principal principal = new Principal();
        setVisible(false);
        principal.setVisible(true);
        
    }     
   
    
}
