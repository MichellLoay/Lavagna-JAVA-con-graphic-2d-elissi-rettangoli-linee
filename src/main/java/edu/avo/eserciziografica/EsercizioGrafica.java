/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.avo.eserciziografica;

import edu.avo.eserciziografica.abstracts.IView;
import edu.avo.eserciziografica.abstracts.IViewObserver;
import edu.avo.eserciziografica.concrete.Controller;
import edu.avo.eserciziografica.concrete.Model;
import edu.avo.eserciziografica.concrete.View;

/**
 *
 * @author palma
 */
public class EsercizioGrafica {

    public static void main(String[] args) {
        Model model=new Model(500,500);
        IViewObserver controller=new Controller(model);
        IView view=new View();
        controller.setView(view);
    }
}
