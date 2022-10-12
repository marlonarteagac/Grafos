/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Matrices;
import Modelo.Vertice;

import Vista.vista;

import java.awt.Color;

import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.N;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge pastrana
 */
public class controlador extends javax.swing.JFrame implements ActionListener {
private Vista.vista view;
    private Modelo.Vertice vertice;
    
    Matrices matrices = new Matrices();
    ArrayList<Vertice> panel = new ArrayList<>();

   
    
    
    
    private int pos;
    
    public controlador() {
       
        this.pos =0;
        matrices.h = this.view.getGraphics();
        this.view.setTitle("Grafos");
        this.view.setLocationRelativeTo(null);
        this.view.setResizable(false);
        this.inicializa();
        this.view.Matriz.setEditable(false);
        this.view.btnLinea.setEnabled(false);
        this.view.btnAyacente.setEnabled(false);
        this.view.setEnabled(false);
    }

    public void inicializa() {
        for (int r = 0; r < Matrices.maxN; r++) {
            for (int s = 0; s < Matrices.maxN; s++) {
                matrices.MAdyacencia[r][s] = false;
            }
        }
        for (int e = 0; e < Matrices.maxN; e++) {
            for (int f = 0; f < matrices.maxL; f++) {
                matrices.MIncidencia[e][f] = false;
            }
        }
    }
    
    //*********************************
    public  void linea(int x, int y, int w, int z) {
        matrices.h.setColor(Color.RED);
        if (x == w && y == z) {
            matrices.h.drawArc(x + 10, y + 5, 20, 30, 320, 290);
            x = x + 15;
            y = y + 20;
        } else {
            matrices.h.drawLine(x + 20, y + 45, w + 20, z + 45);
            x = ((x + 20 - w + 20) / 2) + w;
            y = ((y + 45 - z + 45) / 2) + z;
        }
        matrices.h.setColor(Color.BLACK);
        matrices.h.drawString(matrices.nombreL[matrices.cl], x, y);
//        h.drawString(nombreL[cl], ((x + 20 - w + 20) / 2) + w, ((y + 45 - z + 45) / 2) + z);
        matrices.cl++;
    }
    
     public void muestraAdyacencia() {
        matrices.matrizAdyacente = "Matriz de Adyacencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrices.matrizAdyacente += "   ";
        matrices.matrizAdyacente += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrices.matrizAdyacente += "  " + matrices.nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrices.matrizAdyacente += "  \n";
            for (int l = 0; l < tNodos; l++) {
                if (matrices.MAdyacencia[k][l]) {
                    bit = 1;
                } else {
                    bit = 0;
                }
                if (l == 0) {
                    Nom = matrices.nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrices.matrizAdyacente += Nom + bit + "   ";
            }
        }
        setMatriz(matrices.matrizAdyacente, matrices.matrizIncedencia);
    }

    public void Incidencia() {
        matrices.matrizIncedencia = "Matriz de Incidencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrices.matrizIncedencia += "  ";
        matrices.matrizIncedencia += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrices.matrizIncedencia += "   " + matrices.nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrices.matrizIncedencia += "   \n";
            for (int l = 0; l < tNodos; l++) {
                if (matrices.MIncidencia[k][l]) {
                    bit = 0;
                } else {
                    bit = 1;
                }
                if (l == 0) {
                    Nom = matrices.nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrices.matrizIncedencia += Nom + bit + "   ";
            }
        }
        setMatriz(matrices.matrizIncedencia, matrices.matrizAdyacente);
    }

    private void setMatriz(String matriz1, String matriz2) {
        this.view.Matriz.setText(matriz1 + "\n\n" + matriz2);
    }
    //*************************************
    
    

    private enum Actions {
        vertice, adyacencia, incidencia, Linea, salir
    }

    public controlador(vista view) {

        this.view = view;

        this.view.btnVertice.setActionCommand(Actions.vertice.name());
        this.view.btnVertice.addActionListener((ActionListener) this);

        this.view.btnAyacente.setActionCommand(Actions.adyacencia.name());
        this.view.btnAyacente.addActionListener((ActionListener) this);

        this.view.btnIncidencia.setActionCommand(Actions.incidencia.name());
        this.view.btnIncidencia.addActionListener((ActionListener) this);

        this.view.btnLinea.setActionCommand(Actions.Linea.name());
        this.view.btnLinea.addActionListener((ActionListener) this);

        this.view.btnSalir1.setActionCommand(Actions.salir.name());
        this.view.btnSalir1.addActionListener((ActionListener) this);

        this.view.panelView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelViewMouseClicked(evt);
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == Actions.vertice.name()) {
            // bntVertice();
            if (matrices.N) {
                matrices.N = false;
                matrices.L = false;
                this.view.lblEstado.setText("Vertice y Arista Desactivado");
                this.view.btnVertice.setBackground(null);
                this.view.btnLinea.setBackground(null);
            } else {
                matrices.L = false;
                matrices.N = true;
                this.view.btnVertice.setBackground(Color.decode("#79f966"));
                this.view.btnLinea.setBackground(null);
                this.view.lblEstado.setText("Vertice Activo");
            }

        } else if (e.getActionCommand() == Actions.adyacencia.name()) {

           // JOptionPane.showMessageDialog(null, "adyacencia");
           muestraAdyacencia();

        } else if (e.getActionCommand() == Actions.incidencia.name()) {

            //JOptionPane.showMessageDialog(null, "incidencia");
            Incidencia();
            
            
        } else if (e.getActionCommand() == Actions.Linea.name()) {

            //JOptionPane.showMessageDialog(null, "Linea");
            if (matrices.L) {
                matrices.L = false;
                matrices.N = false;
                view.lblEstado.setText("Vertice y Arista Desactivado");
                view.btnVertice.setBackground(null);
                view.btnLinea.setBackground(null);
            } else {
                
                matrices.N = false;
                matrices.L = true;
                view.btnLinea.setBackground(Color.decode("#79f966"));
                view.btnVertice.setBackground(null);
                view.lblEstado.setText("Arista Activo");
                
            }
            

        } else if (e.getActionCommand() == Actions.salir.name()) {

            //JOptionPane.showMessageDialog(null, "salir");
             System.exit(0);
        }

    }

    private void panelViewMouseClicked(java.awt.event.MouseEvent evt) {
        //System.out.println("panelViewMouseClicked"); // mensaje de la posicio
        if (this.view.panelView.getMousePosition() != null) {
            Point p = this.view.panelView.getMousePosition().getLocation();
            if (!matrices.L) {
                if (matrices.N) {
                    view.btnLinea.setEnabled(true);
                    view.btnAyacente.setEnabled(true);
                    view.btnIncidencia.setEnabled(true);
                    Vertice prueba = new Vertice();
                    prueba.setBounds(p.x - 15, p.y - 10, 31, 31);
                    view.panelView.add(prueba);
                   // pos ++;
                    panel.add(prueba);
                    prueba.dibuja(prueba.getGraphics());
                }
            }
        }
    }
    

}
