/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Emilly Wasson
 */


package ucf.assignments;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DateTimeStringConverter;

public class TodoListView extends VBox {
    // Top menu bar
    private MenuBar mb = new MenuBar();

    private Menu file = new Menu("File"); // File button
    private MenuItem newList = new MenuItem("New");
    private MenuItem open = new MenuItem("Open");
    private MenuItem close = new MenuItem("Close");
    private MenuItem save = new MenuItem("Save");
    private MenuItem quit = new MenuItem("Quit");

    private Menu help = new Menu("Help"); // Help button

    // List view
    private VBox vb = new VBox();

    private TextField name = new TextField("");
    private TextField description = new TextField("");

    private HBox listAndScroll = new HBox();
    private ListView view = new ListView();
    private ScrollBar scroll = new ScrollBar();

    private HBox inputAndButton = new HBox();
    private CheckBox cb = new CheckBox();
    private TextField newItem = new TextField();
    private TextField newItemDate = new TextField();
    private Button addButton = new Button("+");
    // private DatePicker newDate = new DatePicker();

    private ChoiceBox dropDown = new ChoiceBox();

    private final TodoListViewModel viewModel = new TodoListViewModel();

    TodoListView() {
        createView();
        bindViewModel();
    }

    void createView() {
        newList.setOnAction(this::newList);
        open.setOnAction(this::openList);
        close.setOnAction(this::closeList);
        save.setOnAction(this::saveList);
        quit.setOnAction(this::quit);
        file.getItems().addAll(newList, open, close, save, quit);
        mb.getMenus().addAll(file, help);

        scroll.setOrientation(Orientation.VERTICAL);
        listAndScroll.getChildren().addAll(view, scroll);
        dropDown.getItems().addAll(
            "View All", "View Done", "View Incomplete"
        );

        addButton.setOnAction( this::add );
        inputAndButton.getChildren().addAll(newItem, newItemDate, addButton);
        vb.getChildren().addAll(name, description, listAndScroll, inputAndButton, dropDown);

        this.getChildren().addAll(mb, vb);
    }

    void bindViewModel() {
        name.textProperty().bindBidirectional(viewModel.nameProperty());
        description.textProperty().bindBidirectional(viewModel.descriptionProperty());
        view.itemsProperty().bindBidirectional(viewModel.viewProperty());
        dropDown.valueProperty().bindBidirectional(viewModel.dropDownProperty());
        newItem.textProperty().bindBidirectional(viewModel.newItemProperty());
        newItemDate.textProperty().bindBidirectional(viewModel.newItemDateProperty());
    }

    private void newList(ActionEvent evt) { }
    private void openList(ActionEvent evt) { }
    private void closeList(ActionEvent evt) { }
    private void saveList(ActionEvent evt) { }
    private void quit(ActionEvent evt) { System.exit(0); }

    private void add(ActionEvent evt) { viewModel.add(); }

    void remove(ActionEvent evt) { viewModel.remove();}

    void edit(ActionEvent evt) { viewModel.edit();}

    void display(ActionEvent evt) { viewModel.display();}
}
