package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(10, 20, 10, 20));

			HBox hbox = new HBox();
			Label enter = new Label("Enter a list of the teams in this tournament (comma separated): ");
			TextField list = new TextField("Enter a list of teams");
			Button submitList = new Button("Submit");
			hbox.getChildren().add(enter);
			hbox.getChildren().add(list);
			hbox.getChildren().add(submitList);
			root.setTop(hbox);
			
			GridPane gridPane = new GridPane();
			Label team1 = new Label("Team 01");
			Label team2 = new Label("Team 02");
			Label team3 = new Label("Team 03");
			Label team4 = new Label("Team 04");
			Button submit1 = new Button("Submit");
			TextField score1 = new TextField("scores...");
			TextField score2 = new TextField("scores...");	
			gridPane.add(new Label(""), 0, 0);
			gridPane.add(team1, 0, 2);
			gridPane.add(team4, 0, 4);
			gridPane.add(submit1, 0, 3);
			gridPane.add(score1, 1, 2);
			gridPane.add(score2, 1, 4);
			
			Button submit2 = new Button("Submit");
			TextField score3 = new TextField("scores...");
			TextField score4 = new TextField("scores...");	

			gridPane.add(team2, 0, 7);
			gridPane.add(team3, 0, 9);
			gridPane.add(submit2, 0, 8);
			gridPane.add(score3, 1, 7);
			gridPane.add(score4, 1, 9);
			
			gridPane.add(new Label("TBD"), 2, 3);
			gridPane.add(new Label("TBD"), 2, 8);
			Button disabledBtn = new Button("Submit");
			disabledBtn.setDisable(true);
			gridPane.add(disabledBtn, 2, 5);
			
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
		launch(args);
	}
}
