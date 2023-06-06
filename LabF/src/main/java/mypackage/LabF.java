/*
Abe Brege
LabF
4/23/23
*/
package mypackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;



/**
 * JavaFX App
 */
public class LabF extends Application {
    
    private TextField firstName;
    private TextField lastName;
    private TextField sayHelloMessage;
    
    
    @Override
    public void start(Stage primaryStage) {
        //setting stage title
        primaryStage.setTitle("Greeter");
        
        //set
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 300, 190);
        
        //alignments
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setPadding(new Insets(25, 0, 0, 15));
        grid.setVgap(18);
        grid.setHgap(8);
        
        //adding labels
        grid.add(new Label("First Name:"), 0, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(new Label("Message:"), 0, 2);
        
        //adding text boxes
        firstName = new TextField();
        grid.add(firstName, 1, 0);
        
        
        lastName = new TextField();
        grid.add(lastName, 1, 1);
        
        
        sayHelloMessage = new TextField();
        sayHelloMessage.setEditable(false);
        grid.add(sayHelloMessage, 1, 2);
        
        //adding buttons
        Button sayHelloButton = new Button("Say Hello");
        Button clearButton = new Button("Clear");
        Button exitButton = new Button("Exit");
        
        //creating the box for the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(sayHelloButton);
        buttonBox.getChildren().add(clearButton);
        buttonBox.getChildren().add(exitButton);
        
        //positioning
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        
        //setting the padding on bottom wasn't working
        //so I tried what you do in CSS and it ended up working.
        //which is translating the Y axis negatively
        
        buttonBox.setTranslateY(-20);
        grid.add(buttonBox, 0, 4, 2, 1);
        
        //initiating the actions for the buttons
        sayHelloButton.setOnAction(event -> setHelloMessage());
        exitButton.setOnAction(event -> exitButtonClicked());
        clearButton.setOnAction(event -> clearButtonClicked());
        
        
        //display
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    //setting the action of the hello message button
    private void setHelloMessage(){
        if(!firstName.getText().isEmpty() && !lastName.getText().isEmpty()){
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        sayHelloMessage.setText("Hello " + firstNameText + " " + lastNameText + "!");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Entry");
            alert.setContentText("Oops! You forgot to add a first or last name, please try again.");
            alert.showAndWait();
        }
    }
    //setting the action of the exit button
    private void exitButtonClicked(){
        System.exit(0);
    }
    
    private void clearButtonClicked(){
        firstName.setText("");
        lastName.setText("");   
        sayHelloMessage.setText("");
    }

    public static void main(String[] args) {
        launch();
    }

}