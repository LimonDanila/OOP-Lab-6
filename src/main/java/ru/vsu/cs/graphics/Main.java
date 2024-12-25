package ru.vsu.cs.graphics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.vsu.cs.logic.*;

public class Main extends Application {

    private CustomDeque<Integer> deque;
    private TextField addFirstField;
    private TextField addLastField;
    private Button addFirstBtn;
    private Button addLastBtn;
    private Button peekFirstBtn;
    private Button peekLastBtn;
    private Button pollFirstBtn;
    private Button pollLastBtn;
    private Button popBtn;
    private Button pushBtn;
    private Button removeFirstBtn;
    private Button removeLastBtn;
    private Label outputLabel;

    @Override
    public void start(Stage primaryStage) {
        deque = new CustomDeque<>();
        primaryStage.setTitle("Deque Demo");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));


        addFirstField = new TextField();
        addLastField = new TextField();

        addFirstBtn = new Button("addFirst");
        addLastBtn = new Button("addLast");
        peekFirstBtn = new Button("peekFirst");
        peekLastBtn = new Button("peekLast");
        pollFirstBtn = new Button("pollFirst");
        pollLastBtn = new Button("pollLast");
        popBtn = new Button("pop");
        pushBtn = new Button("push");
        removeFirstBtn = new Button("removeFirst");
        removeLastBtn = new Button("removeLast");

        outputLabel = new Label("Deque is empty");

        grid.add(outputLabel, 0, 0, 3, 1);
        grid.add(new Label("Add first:"), 0, 1);
        grid.add(addFirstField, 1, 1);
        grid.add(addFirstBtn, 2, 1);

        grid.add(new Label("Add last:"), 0, 2);
        grid.add(addLastField, 1, 2);
        grid.add(addLastBtn, 2, 2);

        grid.add(peekFirstBtn, 0, 3);
        grid.add(peekLastBtn, 1, 3);
        grid.add(pollFirstBtn, 0, 4);
        grid.add(pollLastBtn, 1, 4);
        grid.add(popBtn,0,5);
        grid.add(new Label("Для Push напишите число в первое поле"), 2, 5);
        grid.add(pushBtn,1,5);
        grid.add(removeFirstBtn, 0, 6);
        grid.add(removeLastBtn, 1, 6);


        addFirstBtn.setOnAction(e -> {
            if (!addFirstField.getText().isEmpty()) {
                try {
                    int value = Integer.parseInt(addFirstField.getText());
                    deque.addFirst(value);
                    updateOutput();
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Invalid input!");
                }
            }else {outputLabel.setText("Input field is empty!");}

            addFirstField.clear();
        });

        addLastBtn.setOnAction(e -> {
            if (!addLastField.getText().isEmpty()) {
                try {
                    int value = Integer.parseInt(addLastField.getText());
                    deque.addLast(value);
                    updateOutput();
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Invalid input!");
                }
            } else {outputLabel.setText("Input field is empty!");}
            addLastField.clear();
        });

        peekFirstBtn.setOnAction(e -> {
            Integer first = deque.peekFirst();
            if (first == null) {
                outputLabel.setText("Deque is empty!");
            } else {
                outputLabel.setText("First element: " + first);
            }

        });


        peekLastBtn.setOnAction(e -> {
            Integer last = deque.peekLast();
            if(last == null) {
                outputLabel.setText("Deque is empty!");
            } else {
                outputLabel.setText("Last element: " + last);
            }

        });
        pollFirstBtn.setOnAction(e -> {
            Integer polled = deque.pollFirst();
            if (polled == null) {
                outputLabel.setText("Deque is empty!");
            } else {
                outputLabel.setText("Polled first element: " + polled);
            }
            updateOutput();
        });

        pollLastBtn.setOnAction(e -> {
            Integer polled = deque.pollLast();
            if (polled == null) {
                outputLabel.setText("Deque is empty!");
            } else {
                outputLabel.setText("Polled last element: " + polled);
            }
            updateOutput();
        });

        popBtn.setOnAction(e->{
            Integer popped = deque.pop();
            if(popped == null){
                outputLabel.setText("Deque is empty!");
            } else {
                outputLabel.setText("Popped element: " + popped);
            }
            updateOutput();
        });

        pushBtn.setOnAction(e->{
            if(!addFirstField.getText().isEmpty()){
                try{
                    int value = Integer.parseInt(addFirstField.getText());
                    deque.push(value);
                    updateOutput();
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Invalid input!");
                }
            } else {outputLabel.setText("Input field is empty!");}
            addFirstField.clear();
        });


        removeFirstBtn.setOnAction(e -> {
            try {
                Integer removed = deque.removeFirst();
                outputLabel.setText("Removed first element: " + removed);
                updateOutput();
            } catch (java.util.NoSuchElementException ex) {
                outputLabel.setText("Deque is empty!");
            }
        });

        removeLastBtn.setOnAction(e -> {
            try {
                Integer removed = deque.removeLast();
                outputLabel.setText("Removed last element: " + removed);
                updateOutput();
            } catch (java.util.NoSuchElementException ex) {
                outputLabel.setText("Deque is empty!");
            }
        });

        Scene scene = new Scene(grid, 650, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateOutput() {
        if (deque.isEmpty()) {
            outputLabel.setText("Deque is empty");
        } else {
            outputLabel.setText("Deque: " + deque);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
