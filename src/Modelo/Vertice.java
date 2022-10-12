package Modelo;

import Controlador.controlador;
import Vista.vista;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

/**
 * javax.swing.JPanel
 *
 *
 */
public class Vertice extends javax.swing.JPanel implements MouseListener, MouseMotionListener {

    // vista view = new vista();
    Matrices matrices = new Matrices();
    private Controlador.controlador control;
    private int pos = -1;

    public void dibuja(Graphics g) {
        if (matrices.c != Matrices.maxN) {
            Font fuenteV = getFont();
            Font nuevaFuente = new Font("Monospaced", Font.BOLD, 16);
            g.setColor(Color.blue);
            g.drawOval(0, 0, 30, 30);
            g.setColor(Color.black);
            g.setFont(nuevaFuente);

            g.drawString(matrices.nombreN[matrices.c], 12, 19);
            g.setFont(fuenteV);
            this.setName(matrices.nombreN[matrices.c]);
            pos = matrices.c;
            matrices.c++;

        } else {
            JOptionPane.showMessageDialog(null, " LIMITE DE VERTICES ");

        }
    }

    public void mouseClicked(MouseEvent e) {  ///linea
        Point p;
        if (matrices.L) {
            p = MouseInfo.getPointerInfo().getLocation();
            if (matrices.eligioP) {
                p = this.getLocation();
                matrices.x1 = p.x;
                matrices.y1 = p.y;
                matrices.eligioP = false;
                matrices.i = this.pos;
            } else {
                p = this.getLocation();
                matrices.x2 = p.x;
                matrices.y2 = p.y;
                control.linea(matrices.x1, matrices.y1,
                        matrices.x2, matrices.y2);
                matrices.eligioP = true;
                matrices.j = this.pos;
                matrices.MAdyacencia[matrices.i][matrices.j] = true;
                matrices.MAdyacencia[matrices.j][matrices.i] = true;
                this.matrices.MIncidencia[matrices.i][matrices.j] = true;
                matrices.MIncidencia[matrices.j][matrices.i] = true;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
