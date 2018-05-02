/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mail: awaldron2@wisc.edu
 * Due: 5/3/2018
 * Files: Milestone3/src/application/Main.java, Milestone3/src/application/Bracket.java,
 *        Milestone3/src/application/Challenger.java, Milestone3/src/application/Matchup.java
 * Other Sources Used: None.
 * Known Bugs:
 */
package application;
	
import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	public static Bracket bracket;
	//public static ArrayList<Label> teamLabels;
	private static ArrayList<ArrayList<TextField>> teamScores;
	private static ArrayList<ArrayList<Button>> submitButtons;
	private static ArrayList<ArrayList<Challenger>> teams;
	private static int numSubmit;
	private static int numTextFields;
	private static int numTBDLabels;
	private static int numRounds;
	
	@Override
	public void start(Stage primaryStage) { // Needs to be changed to display who come in first, second, and third place.
		try {
			GridPane gridPane = new GridPane();
			ScrollPane scroll = new ScrollPane(gridPane);
			BorderPane root = new BorderPane(scroll);
			root.setPadding(new Insets(10, 20, 10, 20));
			root.setTop(new Label("Enter a score in the text fields and press submit when both scores are added."));
			
//			int teamYCoord = 2;
//			for(int i=0; i<teamLabels.size(); i+=2) {
//				gridPane.add(teamLabels.get(i), 0, teamYCoord);
//				gridPane.add(teamLabels.get(i+1), 0, teamYCoord + 2);
//				teamYCoord += 5;
//			}
			
			
			int submitYCoord;
			int submitXCoord;
			
			for(int i = 0; i < numRounds; i++){
				submitXCoord = i;
				if(i == 0) {
					submitYCoord = 3;
					for(int j = 0; j < submitButtons.get(i).size(); j++){
						gridPane.add(submitButtons.get(i).get(j), submitXCoord, submitYCoord);
						submitYCoord += 5;
					}
				}
				
				submitXCoord = 2 * i;
				if(i == 1) {
					submitYCoord = 5;
					for(int j = 0; j < submitButtons.get(i).size(); j++){
						gridPane.add(submitButtons.get(i).get(j), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 10;
					}
				}
				
				if(i == 2) {
					submitYCoord = 10;
					for(int j = 0; j < submitButtons.get(i).size(); j++){
						gridPane.add(submitButtons.get(i).get(j), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 20;
					}
				}
				
				if( i == 3) {
					submitYCoord = 20;
					for(int j = 0; j < submitButtons.get(i).size(); j++){
						gridPane.add(submitButtons.get(i).get(j), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 20;
					}
				}
			}
			
			int scoreXCoord = 1;
			int scoreYCoord = 2;
			for(int i=0; i<numRounds; i++) {
				if(i==0) {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 2);
						scoreYCoord += 5;
					}
					scoreYCoord = 3;
				} else if(i==1) {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						teamScores1.setDisable(true);
						teamScores2.setDisable(true);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 5);
						scoreYCoord += 10;
					}
					scoreYCoord = 5;
				} else if(i==2) {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						teamScores1.setDisable(true);
						teamScores2.setDisable(true);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 10);
						scoreYCoord += 20;
					}
					scoreYCoord = 10;
				} else {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						teamScores1.setDisable(true);
						teamScores2.setDisable(true);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 20);
						scoreYCoord*=2;
					}
				}
				scoreXCoord+=2;
			}
			
			int TBDLabelXCoord = 0;
			int TBDLabelYCoord = 2;
			for(int i=0; i<numRounds; i++) {
				if(i==0) {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 2);
						TBDLabelYCoord +=5;
					}
					TBDLabelYCoord = 3;
				} else if(i==1) {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 5);
						TBDLabelYCoord+=10;
					}
					TBDLabelYCoord = 5;
				} else if(i==2) {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 10);
						TBDLabelYCoord+=20;
					}
					TBDLabelYCoord = 10;
				} else {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 20);

						TBDLabelYCoord+=40;
					}
				}
				TBDLabelXCoord += 2;
			}
			
			
			for(int i = 0; i < submitButtons.size(); i++) {
				for(int j = 0; j < submitButtons.get(i).size(); j++) {
					Button button = submitButtons.get(i).get(j);
					Label label = teams.get(i).get(j).getLabel();
					ArrayList<TextField> roundScores = teamScores.get(i);
					TextField score1 = roundScores.get(j*2);
					TextField score2 = roundScores.get(j*2 + 1);
					
					
					//Label team1 = teamLabels.get();
					button.setOnAction(new EventHandler<ActionEvent>() {

				        @Override
				        public void handle(ActionEvent event) {
				            System.out.println("Hello World!");
				            button.setDisable(true);
				            label.setText("TEST");
				        }
				    });
				}
			}
			
//			Label winner = new Label("Champion");
//			gridPane.add(winner, 8, 20);
			
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
		File teamsFile = new File(args[0]);
		ArrayList<Challenger> challengers = new ArrayList<Challenger>();
		try {
			Scanner scnr = new Scanner(teamsFile);
			int seed = 1;
			while(scnr.hasNextLine()) {
				Challenger challenger = new Challenger(seed + " " + scnr.nextLine()); // Creates new challenger with seed number next to name.
				challengers.add(challenger);
				seed++;
			}
			scnr.close();
			
			bracket = new Bracket(challengers);
			
			numSubmit = challengers.size() - 1;
			numTextFields = (challengers.size() * 2) - 2;
			numTBDLabels = (challengers.size()) - 2;
			numRounds = (int) (Math.log(challengers.size()) / Math.log(2));
		
			
			teamScores = new ArrayList<ArrayList<TextField>>();
			for(int i=numRounds; i>0; i--) {
				teamScores.add(new ArrayList<TextField>());
				for(int j=0; j<Math.pow(2, i); j++) {
					teamScores.get(teamScores.size()-1).add(new TextField("scores..."));
				}
			}
			
			submitButtons = new ArrayList<ArrayList<Button>>();
			for(int i=numRounds; i>0; i--) {
				submitButtons.add(new ArrayList<Button>());
				for(int j=0; j<(Math.pow(2, i)/2); j++) {
					submitButtons.get(submitButtons.size()-1).add(new Button("Submit"));
				}
			}
			
			// Adding initial team names to teamLabels
			teams = new ArrayList<ArrayList<Challenger>>();
			for(int i = numRounds; i > 0; i--) {
				teams.add(new ArrayList<Challenger>());
				//System.out.println(teamLabels.size());
			}
			
			for(int i = numRounds; i > 0; i--) {
//				if(i == 1){
//					for(int j = 0; j < challengers.size(); j++) {
//						teamLabels.get(0).add(new Label(bracket.getActiveChallengers().get(j).getName()));
//					}
//				}
//				else{
//					for(int j = 0; j < (int)Math.pow(2, i); j++) {
//						teamLabels.get(4 - i).add(new Label("TBD"));
//					}
//				}
				for(int j = 0; j < Math.pow(2, i); j ++){
					if( i == numRounds){
						teams.get(0).add(new Challenger(bracket.getActiveChallengers().get(j).getName()));
					}
					else{
						teams.get(numRounds - i).add(new Challenger("TBD"));	
					}
				}
				//System.out.println(i-1 +" " + teamLabels.get(i - 1).size());

			}
			
			// adding matchups to matchup 
			for(int i = 0; i < teams.size(); i++) { // number of rounds
				bracket.getMatchups().add(new ArrayList<Matchup>());
				if(i == 0){
					for(int j = 0; j < teams.get(i).size()/2 - 1; j += 2){ // number of matchups in each round
						bracket.getMatchups().get(i).add(new Matchup(bracket.getAllChallengers()[j], bracket.getAllChallengers()[j+1]));
					}
				}
				
				else{
					for(int j = 0; j < teams.get(i).size(); j += 2){ // number of matchups in each round
						bracket.getMatchups().get(i).add(new Matchup(new Challenger("TBD"), new Challenger("TBD")));
					}
				}
				
		}
		
			
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		launch(args);
	}
}
