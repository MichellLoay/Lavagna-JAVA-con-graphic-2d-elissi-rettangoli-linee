/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.eserciziografica.concrete;

import edu.avo.eserciziografica.Shape;
import edu.avo.eserciziografica.abstracts.IModelObserver;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author palma
 */
public class Model {

    private final int width;
    private final int height;
    private final Random random;
    private IModelObserver observer;
    private List<Shape> shapes;

    public Model(int width, int height) {
        shapes = new LinkedList<>();
        this.width = width;
        this.height = height;
        random = new Random();
    }

    public void setObserver(IModelObserver observer) {
        this.observer = observer;
        observer.initialize(width, height);
    }

    public void push() {
        String type = null;
        int r = random.nextInt(3);
        switch (r) {
            case 0 -> {
                type = "rettangolo";
            }
            case 1 -> {
                type = "elisse";
            }
            case 2 -> {
                type = "linea";
            }

        }
        boolean fill = random.nextBoolean();
        int[] color = new int[]{
            random.nextInt(256), //R
            random.nextInt(256), //G
            random.nextInt(256), //B
        };
        
        int w = 60 + random.nextInt(100);//dimensiona massima
        int h = 60 + random.nextInt(100);
        int x = random.nextInt(width - w);//questo perche rispettino i limiti della schermata
        int y = random.nextInt(height - h);

        shapes.add(new Shape(type, fill, color, x, y, w, h));
        observer.update(shapes);

    }

    public void pop() {
    if (!shapes.isEmpty()) {
        ((LinkedList<Shape>)shapes).removeFirst(); 
        observer.update(shapes);
    }
}

}
