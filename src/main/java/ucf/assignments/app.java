/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Emilly Wasson
 */


package ucf.assignments;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class app extends Application {
    TodoList tl;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 300, 300));
        stage.show();
    }

    private Parent createContent() {
        return new TodoListView();
    }
}

class TodoList {
    ObservableList<Item> list;
    String title;
    String description;
    String date;

    TodoList(String _title, String _description, String _date) {
        title = _title;
        description = _description;
        date = _date;
        list = FXCollections.observableArrayList();
    }

    void add(String content) {
        Item item = new Item(content);
        list.add(item);
    }

    void remove(int index) {
        list.remove(index);
    }

    void edit(String _title, String _description, String _date) {
        title = _title;
        description = _description;
        date = _date;
    }

    void display(int mode) {
        switch (mode) {
            case 0:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).complete) {

                    }
                    break;
                }
            case 1:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).complete) {

                    }
                    break;
                }
            case 2:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).complete) {

                    }
                    break;
                }
        }
    }
}

class Item {
    boolean complete;
    String content;
    // TODO: Add a date property to each item

    Item (String _content) {
        content = _content;
        complete = false;
    }

    void check() {
        complete = true;
    }
}
