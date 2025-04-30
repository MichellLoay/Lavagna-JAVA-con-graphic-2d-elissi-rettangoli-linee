/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.eserciziografica.concrete;

import edu.avo.eserciziografica.abstracts.IModelObserver;
import edu.avo.eserciziografica.abstracts.IView;
import edu.avo.eserciziografica.abstracts.IViewObserver;



/**
 *
 * @author palma
 */
public class Controller implements IViewObserver{
    
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public void setView(IView view) {
        model.setObserver((IModelObserver)view);
        view.setObserver(this);
    }

    @Override
    public void push() {
        model.push();
    }
    
    @Override
    public void pop(){
        model.pop();
    }
    
}
