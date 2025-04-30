/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.eserciziografica;

/**
 *
 * @author Labinfo1-20
 */
public record Shape(String type, boolean fill, int[] color, int x, int y, int width, int height) {

}




































/*
public record Shape(String type, boolean fill, int[] color, int x, int y, int width, int height) {

}
public class EsercizioGrafica {

    public static void main(String[] args) {
        Model model=new Model(500,500);
        IViewObserver controller=new Controller(model);
        IView view=new View();
        controller.setView(view);
    }
}
public interface IModelObserver {
    void initialize(int with, int height);
    void update(List<Shape> shapes);
}
public interface IView {
    void setObserver(IViewObserver observer);
}
public interface IViewObserver {
    
    void setView(IView view);
    void push();
    void pop();
}
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
        String type;
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

    }

    public void pop() {

    }
}
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
public class View extends JFrame implements IView, IModelObserver{

    private JLabel label;
    private Graphics2D g;
    private IViewObserver observer;
    private final JButton push;
    private final JButton pop;

    public View()  {
        JPanel north=new JPanel();
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
        add(north,BorderLayout.NORTH);
    }
    

    @Override
    public void setObserver(IViewObserver observer) {
        this.observer=observer;
    }

    @Override
    public void initialize(int with, int height) {
        BufferedImage bi=new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        g=bi.createGraphics();
        label=new JLabel(new ImageIcon(bi));
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(List<Shape> shapes) {
        
    }

    
    
}

*/