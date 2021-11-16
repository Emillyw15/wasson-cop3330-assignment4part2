/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Emilly Wasson
 */

package ucf.assignments;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.StringConverter;

import java.util.List;

public class TodoListViewModel {
    private final StringProperty name = new SimpleStringProperty("To-do List");
    private final StringProperty description = new SimpleStringProperty("Description");
    private final ListProperty<String> view = new SimpleListProperty();
    private final StringProperty dropDown = new SimpleStringProperty("View All");
    private final StringProperty newItem = new SimpleStringProperty("Item");
    private final StringProperty newItemDate = new SimpleStringProperty("YYYY-MM-DD");

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public List<String> getView() {
        return view.get();
    }

    public ListProperty viewProperty() {
        return view;
    }

    public void setView(ObservableList<String> view) {
        this.view.set(view);
    }

    public String getDropDown() {
        return dropDown.get();
    }

    public StringProperty dropDownProperty() {
        return dropDown;
    }

    public void setDropDown(String dropDown) {
        this.dropDown.set(dropDown);
    }

    public String getNewItem() {
        return newItem.get();
    }

    public StringProperty newItemProperty() {
        return newItem;
    }

    public void setNewItem(String value) {
        this.newItem.set(value);
    }

    public String getNewItemDate() {
        return newItemDate.get();
    }

    public StringProperty newItemDateProperty() {
        return newItemDate;
    }

    public void setNewItemDate(String value) {
        this.newItemDate.set(value);
    }

    void add() {
        // ListView has an "edit" function that we can use here
        try {
            getView().add(newItem.getValue());
        } catch (NullPointerException e) {
            System.out.println("List is null, recreating");
            ObservableList<String> list = FXCollections.observableArrayList();
            list.add(newItem.get() + " (due " + newItemDate.get() + ")");
            setView(list);
        }
        setNewItem("Item");
        setNewItemDate("YYYY-MM-DD");
    }

    void remove() {

    }

    void edit() {

    }

    void display() {

    }
}
