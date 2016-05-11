/*
 * file: GUI.java
 * author: Tyler Cavera
 * course: Formal Languages and Computability
 * assignment: Final Project
 * due date: May 2nd, 2016
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


 public class GUI extends Application {
	MenuBar menuBar = new MenuBar();
    Menu fileOpt = new Menu("File");
    Menu colorOpt = new Menu("Color Schemes");
    static HTMLEditor theEditor;
    Button colorBtn = new Button("Color Me!");
    StringBuilder openFileStringBuilder;
   
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
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        
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
        
        colorBtn.setOnAction(new EventHandler<ActionEvent> (){
        	public void handle(ActionEvent t) {
        		 try{
        	          DFA.reset();
        	          theEditor.setHtmlText(DFA.process(removeHTML(theEditor.getHtmlText())));
        	          
        	          }
        	          catch(Exception e) {
        	            e.printStackTrace();
        	          }
        	}
        });
        
        fileOpt.getItems().addAll(openFileOpt,saveFileOpt,exitOpt);
        colorOpt.getItems().addAll(normalColorOpt,nightColorOpt);
        menuBar.getMenus().addAll(fileOpt,colorOpt);
        GridPane layout = new GridPane();
        
        layout.add(menuBar, 0, 0);
        layout.add(theEditor, 0, 1);
        layout.add(colorBtn, 0, 2);
        colorBtn.setTranslateX(300);

        Scene scene = new Scene(layout, 700, 700, Color.GREY);
        stage.setScene(scene);
        stage.show();
    }
 
    private String removeHTML(String input) {
    	return input.replaceAll("\\<[^>]*>","");
    }
    
    public void openFile() throws Exception{
		JFileChooser chooser = new JFileChooser(); 
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "text"); 
		chooser.setFileFilter(filter); 
		openFileStringBuilder = new StringBuilder(); 
    
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			java.io.File file = chooser.getSelectedFile();
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				openFileStringBuilder.append(input.nextLine()); 
				openFileStringBuilder.append("\n");
			}
			input.close();
		} else{
			openFileStringBuilder.append("No file was chosen.");
		}
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}