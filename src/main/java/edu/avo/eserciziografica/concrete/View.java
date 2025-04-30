/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.eserciziografica.concrete;

import edu.avo.eserciziografica.Shape;
import edu.avo.eserciziografica.abstracts.IModelObserver;
import edu.avo.eserciziografica.abstracts.IView;
import edu.avo.eserciziografica.abstracts.IViewObserver;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author palma
 */
public class View extends JFrame implements IView, IModelObserver {

    private JLabel label;
    private Graphics2D g;
    private IViewObserver observer;
    private final JButton push;
    private final JButton pop;

    public View() {
        JPanel north = new JPanel();
        push = new JButton("Aggiungi");
        push.addActionListener((e) -> {
            observer.push();
        });
        pop = new JButton("Rimuovi");
        pop.addActionListener((e) -> {
            observer.pop();
        });
        north.add(push);
        north.add(pop);
        add(north, BorderLayout.NORTH);
    }

    @Override
    public void setObserver(IViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void initialize(int with, int height) {
        BufferedImage bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        g = bi.createGraphics();
        label = new JLabel(new ImageIcon(bi));
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(List<Shape> shapes) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 500);

        for (Shape actualShape : shapes) {
            Color color = new Color(actualShape.color()[0], actualShape.color()[1], actualShape.color()[2]); 
            g.setColor(color);

            switch (actualShape.type()) {
                case "rettangolo" -> {
                    if (actualShape.fill()) {
                        g.fillRect(actualShape.x(), actualShape.y(), actualShape.width(), actualShape.height());
                    } else {
                        g.drawRect(actualShape.x(), actualShape.y(), actualShape.width(), actualShape.height());
                    }
                }
                case "elisse" -> {
                    if (actualShape.fill()) {
                        g.fillOval(actualShape.x(), actualShape.y(), actualShape.width(), actualShape.height());
                    } else {
                        g.drawOval(actualShape.x(), actualShape.y(), actualShape.width(), actualShape.height());
                    }
                }
                case "linea" -> {
                    g.drawLine(actualShape.x(), actualShape.y(), actualShape.x() + actualShape.width(), actualShape.y() + actualShape.height());
                }

            }
        }

        // Aggiorna la vista
        label.repaint();
    }

}
