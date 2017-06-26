package pl.edu.pk.project.controller;

import pl.edu.pk.project.model.Model;
import pl.edu.pk.project.service.Service;
import pl.edu.pk.project.view.View;

public abstract class Controller<T> {

    protected Service<T> service;
    protected View view;
    protected Model model;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    public void setService(Service<T> service) {
        this.service = service;
    }

    public abstract void control();

    public View getView() {
        return view;
    }

}
