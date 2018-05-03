/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mail: madhugiri@wisc.edu, nmerfeld@wisc.edu, xshao36@wisc.edu, awaldron2@wisc.edu
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
import java.util.Random;
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
				if(i == 0){
					submitYCoord = 3;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitYCoord += 5;						
					}
				}
				submitXCoord = 2 * i;
				if(i == 1){
					submitYCoord = 5;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 10;
					}
				}
				if(i == 2){
					submitYCoord = 10;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 20;
					}
				}
				if( i == 3){
					submitYCoord = 20;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
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
			
			
			for(int i = 0; i < bracket.getMatchups().size(); i++) {
				for(int j = 0; j < bracket.getMatchups().get(i).size(); j++) {
					int roundIndex = i; // Used in the ActionEvent
					int matchupIndex = j; // Used in the ActionEvent
					Matchup matchup = bracket.getMatchups().get(i).get(j);
					Button button = matchup.getButton();
					ArrayList<TextField> roundScores = teamScores.get(i);
					TextField score1 = roundScores.get(j*2);
					TextField score2 = roundScores.get(j*2 + 1);		
					ArrayList<Challenger> roundChallengers = teams.get(i);
					Challenger team1 = roundChallengers.get(j*2);
					Challenger team2 = roundChallengers.get(j*2+1);
					
					
					button.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							team1.setScore(Integer.parseInt(score1.getText()));
							team2.setScore(Integer.parseInt(score2.getText()));
							Challenger winner = matchup.getWinner(team1, team2);
							button.setDisable(true);
							try {
								Label resultLabel = teams.get(roundIndex+1).get(matchupIndex).getLabel();
								resultLabel.setText(winner.getName());
								teams.get(roundIndex+1).get(matchupIndex).setName(winner.getName());
								teamScores.get(roundIndex+1).get(matchupIndex).setDisable(false);
								Matchup resultMatchup = bracket.getMatchups().get(roundIndex+1).get(matchupIndex/2);
								resultMatchup.addChallenger(winner.getName());
								System.out.println(resultMatchup.getC1());
								System.out.println(resultMatchup.getC2());
								
								if( !(resultMatchup.getC1().getName().equals("TBD") || 
										resultMatchup.getC2().getName().equals("TBD")) ) {
									resultMatchup.getButton().setDisable(false);
								}
							} catch (IndexOutOfBoundsException e) {
								gridPane.add(new Label("Winner: " + winner.getName()), numRounds*10, 10);
							}
							
						}
					});
				}
			}
			
			
//			for(int i = 0; i < submitButtons.size(); i++) {
//				for(int j = 0; j < submitButtons.get(i).size(); j++) {
//					int roundIndex = i;
//					int buttonIndex = j;
//					Button button = submitButtons.get(i).get(j);
//					ArrayList<TextField> roundScores = teamScores.get(i);
//					TextField score1 = roundScores.get(j*2);
//					TextField score2 = roundScores.get(j*2 + 1);		
//					ArrayList<Challenger> roundChallengers = teams.get(i);
//					Challenger team1 = roundChallengers.get(j*2);
//					Challenger team2 = roundChallengers.get(j*2+1);
//			
//					button.setOnAction(new EventHandler<ActionEvent>() {
//
//				        @Override
//				        public void handle(ActionEvent event) {	
//				        	
//				        		Label label;
//				            if(Integer.parseInt(score1.getText()) > Integer.parseInt(score2.getText())) {
//				            		label = team1.getLabel();
//				            }
//				            else if(Integer.parseInt(score1.getText()) < Integer.parseInt(score2.getText())) {
//				            		label = team2.getLabel();
//				            }
//				            else {
//				            		Random random = new Random(2);
//				            		int result = random.nextInt();
//				            		if(result == 0) label = team1.getLabel();
//				            		else label = team2.getLabel();
//				            }
//				            
//				            
//				            button.setDisable(true);
//				            Label resultLabel = teams.get(roundIndex+1).get(buttonIndex).getLabel();
//				            resultLabel.setText(label.getText());
//				            teamScores.get(roundIndex+1).get(buttonIndex).setDisable(false);
//				            if(team1.getLabel().getText().equals("TBD") || team2.getLabel().getText().equals("TBD")) return;
//				            	Button activatedButton = submitButtons.get(roundIndex+1).get(buttonIndex/2);
//					        activatedButton.setDisable(false);
//				            
//				        }
//				    });
//				}
//			}
			
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
//					System.out.println(teamLabels.get(i).size());
					for(int j = 0; j < teams.get(i).size()/2; j ++){ // number of matchups in each round
						bracket.getMatchups().get(i).add(
								new Matchup(bracket.getAllChallengers()[j], bracket.getAllChallengers()[j+1], submitButtons.get(0).get(j)));
					}
				}
				
				else{
					for(int j = 0; j < teams.get(i).size() / 2; j ++){ // number of matchups in each round
						bracket.getMatchups().get(i).add(
								new Matchup(new Challenger("TBD"), new Challenger("TBD"), submitButtons.get(i).get(j)));
					}
				}
				
			}
		
			
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		launch(args);
	}
}
