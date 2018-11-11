package com.nissan.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.nissan.entity.Car;
import com.nissan.service.CarService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainView.class)
@PageTitle("CarView")
public class CarView extends FlexLayout {

    @Autowired
    public CarView(CarService carService) {
        Grid<Car> carGrid = new Grid<>();
        Button button = new Button("Refresh");
        button.getStyle().set("background", "red");
        add(button);
        add(carGrid);
        getStyle().set("background", "grey");
        carGrid.addColumn(Car::getid).setHeader("Id");
        carGrid.addColumn(Car::getBrand).setHeader("Brand");
        carGrid.addColumn(Car::getModel).setHeader("Model");
        carGrid.addColumn(Car::getColor).setHeader("Color");

        DataProvider<Car, Void> carListDataProvider = DataProvider
                .fromCallbacks(f -> carService.findAll(f.getOffset(),f.getLimit()), f -> (int) carService.findAll(
                        f.getOffset(), f.getLimit()).count());


        button.addClickListener(buttonClickEvent -> {
            carGrid.getDataProvider().refreshAll();
            Notification.show("refreshed");
        });

        // The grid shows the persons sorted by name
        carGrid.setDataProvider(carListDataProvider);
    }
}
