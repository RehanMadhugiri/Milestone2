package application;
	
import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) { // Needs to be changed to display who come in first, second, and third place.
		try {
			GridPane gridPane = new GridPane();
			ScrollPane scroll = new ScrollPane(gridPane);
			BorderPane root = new BorderPane(scroll);
			root.setPadding(new Insets(10, 20, 10, 20));
			root.setTop(new Label("Enter a score in the text fields and press submit when both scores are added."));
			
			Label team1 = new Label("Team 01");
			Label team2 = new Label("Team 02");
			Label team3 = new Label("Team 03");
			Label team4 = new Label("Team 04");
			Label team5 = new Label("Team 05");
			Label team6 = new Label("Team 06"); 
			Label team7 = new Label("Team 07");
			Label team8 = new Label("Team 08");
			Label team9 = new Label("Team 09");
			Label team10 = new Label("Team 10");
			Label team11 = new Label("Team 11");
			Label team12 = new Label("Team 12");
			Label team13 = new Label("Team 13");
			Label team14 = new Label("Team 14");
			Label team15 = new Label("Team 15");
			Label team16 = new Label("Team 16");
			Button submit1_1 = new Button("Submit"); //Numbers next to submit button variable names indicate round and the button number of the round.
			TextField score1_1 = new TextField("score..."); //Numbers next to score variable names indicate round and the score number of the round.
			TextField score1_2 = new TextField("score...");	
			gridPane.add(new Label(""), 0, 0);
			gridPane.add(team1, 0, 2);
			gridPane.add(team16, 0, 4);
			gridPane.add(submit1_1, 0, 3);
			gridPane.add(score1_1, 1, 2);
			gridPane.add(score1_2, 1, 4);
			
			Button submit1_2 = new Button("Submit");
			TextField score1_3 = new TextField("score...");
			TextField score1_4 = new TextField("score...");	

			gridPane.add(team2, 0, 7);
			gridPane.add(team15, 0, 9);
			gridPane.add(submit1_2, 0, 8);
			gridPane.add(score1_3, 1, 7);
			gridPane.add(score1_4, 1, 9);
			
			Button submit1_3 = new Button("Submit");
			TextField score1_5 = new TextField("score...");
			TextField score1_6 = new TextField("score...");
			
			gridPane.add(new Label(""), 2, 10);
			gridPane.add(team3, 0, 12);
			gridPane.add(team14, 0, 14);
			gridPane.add(submit1_3, 0, 13);
			gridPane.add(score1_5, 1, 12);
			gridPane.add(score1_6, 1, 14);
			
			Button submit1_4 = new Button("Submit");
			TextField score1_7 = new TextField("score...");
			TextField score1_8 = new TextField("score...");
			
			gridPane.add(team4, 0, 17);
			gridPane.add(team13, 0, 19);
			gridPane.add(submit1_4, 0, 18);
			gridPane.add(score1_7, 1, 17);
			gridPane.add(score1_8, 1, 19);
			
			Button submit1_5 = new Button("Submit");
			TextField score1_9 = new TextField("score...");
			TextField score1_10 = new TextField("score...");
			
			gridPane.add(new Label(""), 2, 20);
			gridPane.add(team5, 0, 22);
			gridPane.add(team12, 0, 24);
			gridPane.add(submit1_5, 0, 23);
			gridPane.add(score1_9, 1, 22);
			gridPane.add(score1_10, 1, 24);
			
			Button submit1_6 = new Button("Submit");
			TextField score1_11 = new TextField("score...");
			TextField score1_12 = new TextField("score...");
			
			gridPane.add(team6, 0, 27);
			gridPane.add(team11, 0, 29);
			gridPane.add(submit1_6, 0, 28);
			gridPane.add(score1_11, 1, 27);
			gridPane.add(score1_12, 1, 29);
			
			Button submit1_7 = new Button("Submit");
			TextField score1_13 = new TextField("score...");
			TextField score1_14 = new TextField("score...");
			
			gridPane.add(new Label(""), 2, 30);
			gridPane.add(team7, 0, 32);
			gridPane.add(team10, 0, 34);
			gridPane.add(submit1_7, 0, 33);
			gridPane.add(score1_13, 1, 32);
			gridPane.add(score1_14, 1, 34);
			
			Button submit1_8 = new Button("Submit");
			TextField score1_15 = new TextField("score...");
			TextField score1_16 = new TextField("score...");
			
			gridPane.add(team8, 0, 37);
			gridPane.add(team9, 0, 39);
			gridPane.add(submit1_8, 0, 38);
			gridPane.add(score1_15, 1, 37);
			gridPane.add(score1_16, 1, 39);
	
			////////////////////////////////////// END OF CODE FOR FIRST ROUND SETUP //////////////////////////////////
			
			gridPane.add(new Label("TBD"), 2, 3); // TEAMS TBD. MIGHT NEED TO MAKE INTO SPECIFIC OBJECTS WITH VARIABLES SO THEY CAN BE CHANGED WHEN TEAMS MOVE ON
			gridPane.add(new Label("TBD"), 2, 8);
			gridPane.add(new Label("TBD"), 2, 13);
			gridPane.add(new Label("TBD"), 2, 18);
			gridPane.add(new Label("TBD"), 2, 23);
			gridPane.add(new Label("TBD"), 2, 28);
			gridPane.add(new Label("TBD"), 2, 33);
			gridPane.add(new Label("TBD"), 2, 38);
			
			TextField score2_1 = new TextField("score...");
			score2_1.setDisable(true);
			TextField score2_2 = new TextField("score...");
			score2_2.setDisable(true);
			TextField score2_3 = new TextField("score...");
			score2_3.setDisable(true);
			TextField score2_4 = new TextField("score...");
			score2_4.setDisable(true);
			TextField score2_5 = new TextField("score...");
			score2_5.setDisable(true);
			TextField score2_6 = new TextField("score...");
			score2_6.setDisable(true);
			TextField score2_7 = new TextField("score...");
			score2_7.setDisable(true);
			TextField score2_8 = new TextField("score...");
			score2_8.setDisable(true);
			
			Button submit2_1 = new Button("Submit");
			submit2_1.setDisable(true);
			Button submit2_2 = new Button("Submit");
			submit2_2.setDisable(true);
			Button submit2_3 = new Button("Submit");
			submit2_3.setDisable(true);
			Button submit2_4 = new Button("Submit");
			submit2_4.setDisable(true);
			
			gridPane.add(submit2_1, 2, 5);
			gridPane.add(submit2_2, 2, 15);
			gridPane.add(submit2_3, 2, 25);
			gridPane.add(submit2_4, 2, 35);
			gridPane.add(score2_1, 3, 3);
			gridPane.add(score2_2, 3, 8);
			gridPane.add(score2_3, 3, 13);
			gridPane.add(score2_4, 3, 18);
			gridPane.add(score2_5, 3, 23);
			gridPane.add(score2_6, 3, 28);
			gridPane.add(score2_7, 3, 33);
			gridPane.add(score2_8, 3, 38);
			gridPane.add(new Label(""), 3, 5);
			
            //////////////////////////////////////END OF CODE FOR SECOND ROUND SETUP //////////////////////////////////
			
			gridPane.add(new Label("TBD"), 4, 5); //SAME POSSIBLE ISSUE AS ROUND 1
			gridPane.add(new Label("TBD"), 4, 15);
			gridPane.add(new Label("TBD"), 4, 25);
			gridPane.add(new Label("TBD"), 4, 35);
			
			TextField score3_1 = new TextField("score...");
			score3_1.setDisable(true);
			TextField score3_2 = new TextField("score...");
			score3_2.setDisable(true);
			TextField score3_3 = new TextField("score...");
			score3_3.setDisable(true);
			TextField score3_4 = new TextField("score...");
			score3_4.setDisable(true);
			
			Button submit3_1 = new Button("Submit");
			submit3_1.setDisable(true);
			Button submit3_2 = new Button("Submit");
			submit3_2.setDisable(true);
			
			gridPane.add(submit3_1, 4, 10);
			gridPane.add(submit3_2, 4, 30);
			gridPane.add(score3_1, 5, 5);
			gridPane.add(score3_2, 5, 15);
			gridPane.add(score3_3, 5, 25);
			gridPane.add(score3_4, 5, 35);
			
            //////////////////////////////////////END OF CODE FOR THIRD ROUND SETUP //////////////////////////////////
			
			gridPane.add(new Label("TBD"), 6, 10); //SAME POSSIBLE ISSUE AS OTHER ROUNDS
			gridPane.add(new Label("TBD"), 6, 30);
			
			TextField score4_1 = new TextField("score...");
			score4_1.setDisable(true);
			TextField score4_2 = new TextField("score...");
			score4_2.setDisable(true);
			
			Button submit4_1 = new Button("Submit");
			submit4_1.setDisable(true);
			
			gridPane.add(submit4_1, 6, 20);
			gridPane.add(score4_1, 7, 10);
			gridPane.add(score4_2, 7, 30);
			
            //////////////////////////////////////END OF CODE FOR FOURTH ROUND SETUP //////////////////////////////////
			
			gridPane.add(new Label("WINNER: TEAM X"), 8, 20); //CHANGE THIS FOR LATER SO IT'S NOT LITERALLY TEAM X
			
			
			root.setLeft(gridPane);

			Scene scene = new Scene(root,1000,500);			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File teamsFile = new File(args[0]); // Takes file from command line. *Also might need to change everything from here on down depending on how they check for file input.*
		ArrayList<Challenger> challengers = new ArrayList<Challenger>();
		try {
			Scanner scnr = new Scanner(teamsFile);
			int seed = 1;
			while(scnr.hasNextLine()) {
				Challenger challenger = new Challenger(seed + " " + scnr.nextLine()); // Creates new challenger with seed number next to name.
				challengers.add(challenger);
				seed++;
			}
			// STILL MIGHT NEED TO ADD MORE CODE TO MAKE BRACKET STUFF
			scnr.close();
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		launch(args);
	}
}
