package tn.usousse.eniso.get1.stage1.presentation.controller;

import tn.usousse.eniso.get1.stage1.presentation.model.Table;
import tn.usousse.eniso.get1.stage1.service.AppService;

public class AppController {
    private AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    public void add(String name) {
        getService().add(name);
    }
    public AppService getService() {
        return service;
    }

    public Table getModel() {
        return getService().getTable();
    }

    public void setService(AppService service) {
        this.service = service;
    }
    public void setSize(int size){
        service.getTable().setSize(size);
    }

    public int getSize(){
        return service.getTable().getSize();
    }
}
