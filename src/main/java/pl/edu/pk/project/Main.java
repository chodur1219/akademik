package pl.edu.pk.project;

import pl.edu.pk.project.controller.Controller;
import pl.edu.pk.project.controller.MainController;

public class Main {
    public static void main(String[] args){
        Controller controller = MainController.getInstance();
        controller.control();
        controller.getView().display();
    }
}
