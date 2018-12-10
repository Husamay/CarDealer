package com.nissan.ui;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.nissan.entity.Car;
import com.nissan.entity.carparts.chassis.PulsarChassis;
import com.nissan.entity.carparts.door.Door;
import com.nissan.entity.carparts.door.PulsarDoor;
import com.nissan.entity.carparts.engine.PulsarEngine;
import com.nissan.factory.abstractfactory.QashQaiCarPartFactory;
import com.nissan.factory.abstractfactory.QashqaiFactoryMethod;
import com.nissan.factory.factorymethod.AbstractFactoryMethod;
import com.nissan.factory.factorymethod.JukeFactoryMethod;
import com.nissan.factory.factorymethod.PulsarFactoryMethod;
import com.nissan.factory.simplefactory.SimpleCarFactory;
import com.nissan.factory.simplefactory.StaticCarFactory;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

/**
 * The main view contains a button and a click listener.
 */
public class MainView extends HorizontalLayout implements RouterLayout {
    private final Div content;

    @Override
    public void showRouterLayoutContent(HasElement content) {
        this.content.getElement()
                .appendChild(Objects.requireNonNull(content.getElement()));
    }

    private final ApplicationContext applicationContext;

    @Autowired
    public MainView(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidth("500px");
        content = new Div();
        content.setSizeFull();
        add(verticalLayout, content);
        verticalLayout.add(new Button("Use SimpleFactory(Creates 1 Pulsar)",
                event -> useSimpleCarFactory()));

        verticalLayout.add(new Button("Use SimpleFactory(Creates 2 Qashqai`s)",
                event -> useStaticCarFactory()));

        verticalLayout.add(new Button(
                "Use CarFactoryMethod(Creates 2 Juke`s and 1 Pulsar)",
                event -> useCarFactoryMethod()));

        verticalLayout.add(new Button(
                "Use CarFactoryMethodWrongWay(Creates 2 Juke`s and 1 Pulsar)",
                event -> useCarFactoryMethodWrongWay()));

        verticalLayout.add(new Button(
                "Use CarAbstractFactory(Creates 1 qashqai)",
                event -> useCarAbstractFactory()));

        verticalLayout.add(new Button(
                "Test State Design Pattern",
                event -> useCarAbstractFactory()));

        verticalLayout.add(new Button(
                "Observer Design Pattern",
                event -> useCarAbstractFactory()));

        verticalLayout.add(new Button(
                "Composite Design Pattern",
                event -> useCarAbstractFactory()));
    }

    private void useSimpleCarFactory() {
        SimpleCarFactory simpleCarFactory = applicationContext
                .getBean(SimpleCarFactory.class);
        Car pulsar = simpleCarFactory.create("Pulsar");
        pulsar.polish();
        pulsar.makeTurnKeyReady();

    }

    private void useStaticCarFactory() {
        Car qashqai = StaticCarFactory.create("Qashqai");
        qashqai.polish();
        qashqai.makeTurnKeyReady();
        Car qashqai2 = StaticCarFactory.create("Qashqai");
        // forgot to polish ?
        qashqai2.makeTurnKeyReady();
    }

    private void useCarFactoryMethod() {
        AbstractFactoryMethod jukeFactoryMethod = applicationContext
                .getBean(JukeFactoryMethod.class);
        jukeFactoryMethod.create();
        jukeFactoryMethod.create();
        AbstractFactoryMethod pulsarFactoryMethod =  applicationContext
                .getBean(PulsarFactoryMethod.class);
        pulsarFactoryMethod.create();
    }

    private void useCarFactoryMethodWrongWay() {
        // we added some details to the car like engine, door and chassis
        AbstractFactoryMethod pulsarFactoryMethod =  applicationContext
                .getBean(PulsarFactoryMethod.class);
        Car car = pulsarFactoryMethod.create();
        car.setChassis(new PulsarChassis());
        ArrayList<Door> door = new ArrayList<>();
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        car.setDoor(door);
        car.setEngine(new PulsarEngine());

        // we see here a copy paste work without changing the car parts
        AbstractFactoryMethod jukeFactoryMethod = applicationContext
                .getBean(JukeFactoryMethod.class);
        Car juke1 = jukeFactoryMethod.create();
        //pulsar doors on juke ?? this is wrong
        juke1.setChassis(new PulsarChassis());
        ArrayList<Door> door2 = new ArrayList<>();
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        juke1.setDoor(door2);
        juke1.setEngine(new PulsarEngine());
        Car juke2 = jukeFactoryMethod.create();
        juke2.setChassis(new PulsarChassis());
        ArrayList<Door> door3 = new ArrayList<>();
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        door.add(new PulsarDoor());
        juke2.setDoor(door3);
        juke2.setEngine(new PulsarEngine());}


    private void useCarAbstractFactory() {
        QashqaiFactoryMethod qashqaiFactoryMethod = applicationContext
                .getBean(QashqaiFactoryMethod.class);
        qashqaiFactoryMethod.create(new QashQaiCarPartFactory());
    }
}