/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.avo.eserciziografica.abstracts;

/**
 *
 * @author palma
 */
public interface IViewObserver {
    
    void setView(IView view);
    void push();
    void pop();
}
