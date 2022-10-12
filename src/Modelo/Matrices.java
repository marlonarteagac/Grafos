/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Vertice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jorge pastrana
 */
public class Matrices extends javax.swing.JFrame{
    
    private Vista.vista view;

    public ArrayList<Vertice> panel = new ArrayList<>();
    public static int c = 0;
    public static int cl = 0 ;
    public static int maxN = 10;
    public boolean N = false;
    public boolean L = false;
    public Graphics h;
    public String nombreN[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};///
    public String nombreL[] = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
        "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20"};
    public  int maxL = nombreL.length;
    public boolean eligioP = true;
    public Point punto;
    public int x1, x2, y1, y2;
    public int i = -1, j = -1;
    public boolean MAdyacencia[][] = new boolean[maxN][maxN];
    public boolean MIncidencia[][] = new boolean[maxN][maxL];
    public String matrizAdyacente = "", matrizIncedencia = "";//
    
    private int pos=-1;

    public Matrices() {
        //this.c = 0;
        //this.cl =0;
        //this.maxN = 10;
      // this.N = false;
       //this.L = false;

    }
  
      public void inicializa() {/// inicializa la matriz , con ceros
        for (int r = 0; r < maxN; r++) {
            for (int s = 0; s < maxN; s++) {
                MAdyacencia[r][s] = false;
            }
        }
        for (int e = 0; e < maxN; e++) {
            for (int f = 0; f < maxL; f++) {
                MIncidencia[e][f] = false;
            }
        }
    }
      
      public  void linea(int x, int y, int w, int z) {
        h.setColor(Color.RED);
        if (x == w && y == z) {
            h.drawArc(x + 10, y + 5, 20, 30, 320, 290);
            x = x + 15;
            y = y + 20;
        } else {      
        }
        h.setColor(Color.BLACK);
        h.drawString(nombreL[cl], x, y);
//        h.drawString(nombreL[cl], ((x + 20 - w + 20) / 2) + w, ((y + 45 - z + 45) / 2) + z);
        cl++;
    }
    


    public void muestraAdyacencia() {
        matrizAdyacente = "Matriz de Adyacencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrizAdyacente += "   ";
        matrizAdyacente += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrizAdyacente += "  " + nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrizAdyacente += "  \n";
            for (int l = 0; l < tNodos; l++) {
                if (MAdyacencia[k][l]) {
                    bit = 1;
                } else {
                    bit = 0;
                }
                if (l == 0) {
                    Nom = nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrizAdyacente += Nom + bit + "   ";
            }
        }
        setMatriz(matrizAdyacente, matrizIncedencia);
    }

    public void Incidencia() {
        matrizIncedencia = "Matriz de Incidencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrizIncedencia += "  ";
        matrizIncedencia += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrizIncedencia += "   " + nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrizIncedencia += "   \n";
            for (int l = 0; l < tNodos; l++) {
                if (MIncidencia[k][l]) {
                    bit = 0;
                } else {
                    bit = 1;
                }
                if (l == 0) {
                    Nom = nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrizIncedencia += Nom + bit + "   ";
            }
        }
        setMatriz(matrizIncedencia, matrizAdyacente);
    }
    
     private void setMatriz(String matriz1, String matriz2) {
        this.view.Matriz.setText(matriz1 + "\n\n" + matriz2);
    }

 
}
