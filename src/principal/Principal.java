package principal;

import model.Model;
import view.View;
import controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Principal {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        View v = new View();
        Model m = new Model(v);
        Controller c = new Controller(m, v);
        c.iniciar(true);
    }    
}
