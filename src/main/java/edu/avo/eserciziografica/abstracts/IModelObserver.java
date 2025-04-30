/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.avo.eserciziografica.abstracts;

import edu.avo.eserciziografica.Shape;
import java.util.List;



/**
 *
 * @author palma
 */
public interface IModelObserver {
    void initialize(int with, int height);
    void update(List<Shape> shapes);
}
