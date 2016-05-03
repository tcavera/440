/*
 * file: TextEditor.java
 * author: Tyler Cavera
 * course: Formal Languages and Computability
 * assignment: Final Project
 * due date: May 2, 2016
 * version 1.0
 * 
 * This is the file for the GUI of our Text Editor project. 
 *
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Scanner;
 

public class TextEditor extends Application {
	StringBuilder strBuilder;
    MenuBar menuBar = new MenuBar();
    Menu fileOpt = new Menu("File");
    Menu colorOpt = new Menu("Color Schemes");
    static HTMLEditor theEditor;
    String filePath = ""; 

    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Tyler's Text Editor");
        theEditor = new HTMLEditor();
        MenuItem openFileOpt = new MenuItem("Open File");
        MenuItem saveFileOpt = new MenuItem("Save File");
        MenuItem exitOpt = new MenuItem("Exit");
        MenuItem normalColorOpt = new MenuItem("Normal");
        MenuItem nightColorOpt = new MenuItem("Night");
        
            
        openFileOpt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	try {
					openFile();
				} catch (Exception e) {}
            	String theFile = strBuilder.toString().replaceAll("\n", "<p>");
				theEditor.setHtmlText(theFile);
            }
		});
        
        /*
        saveFileOpt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                saveFile();
            }
        });
        */
        
        exitOpt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        
        normalColorOpt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	theEditor.setHtmlText("<body style='background-color:white;color:black;'>");
            }
        });
        
        nightColorOpt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	theEditor.setHtmlText("<body style='background-color:black;color:white;'>");
            }
        });
        
        fileOpt.getItems().addAll(openFileOpt,saveFileOpt,exitOpt);
        colorOpt.getItems().addAll(normalColorOpt,nightColorOpt);
        menuBar.getMenus().addAll(fileOpt,colorOpt);
        GridPane layout = new GridPane();
        
        layout.add(menuBar, 0, 0);
        layout.add(theEditor, 0, 1);

        Scene scene = new Scene(layout, 700, 700, Color.GREY);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
    public void openFile() throws Exception{
		JFileChooser chooser = new JFileChooser(); 
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "text"); 
		chooser.setFileFilter(filter); 
		strBuilder = new StringBuilder(); 
    
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			java.io.File file = chooser.getSelectedFile();
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				strBuilder.append(input.nextLine()); 
				strBuilder.append("\n");
			}
			input.close();
		} else{
			strBuilder.append("No file was chosen.");
		}
	}
    

}