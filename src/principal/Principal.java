package principal;

import model.Model;
import view.View;
import controller.Controller;

public class Principal {

    public static void main(String[] args) {
        Model m = new Model();
        View v= new View();
        Controller c= new Controller(m, v);
        c.iniciar();
    }
    
}
