import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	Button b4 = new Button();
	Button b5 = new Button();
	Label label = new Label();
	TextField text = new TextField();
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	
	//student Task #4:
	DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		b1.setText("Hello");
		b2.setText("Howdy");
		b3.setText("Chinese");
		b4.setText("Clear");
		b5.setText("Exit");
		label.setText("Feedback");
		//student Task #4:
		 data = new DataManager();
		 HBox.setMargin(b1, new Insets(10));
		 HBox.setMargin(b2, new Insets(10));
		 HBox.setMargin(b3, new Insets(10));
		 HBox.setMargin(b4, new Insets(10));
		 HBox.setMargin(b5, new Insets(10));
		 hbox1.setAlignment(Pos.CENTER);
		 hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		hbox1.getChildren().addAll(b1, b2, b3, b4, b5);
		hbox2.getChildren().addAll(label, text);
		getChildren().addAll(hbox1, hbox2);
		b1.setOnAction(new ButtonHandler());
		b2.setOnAction(new ButtonHandler());
		b3.setOnAction(new ButtonHandler());
		b4.setOnAction(new ButtonHandler());
		b5.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	private class ButtonHandler implements EventHandler<ActionEvent>{
	    

        
	     public void handle(ActionEvent event) {
	        if (event.getTarget()==b1) {
	            text.setText(data.getHello());
	        }
	        else if (event.getTarget()==b2) {
	            text.setText(data.getHowdy());
	        }
	        else if (event.getTarget()==b3) {
	            text.setText(data.getChinese());
	        }
	        else if (event.getTarget()==b4) {
	            text.setText("");
	        }
	        else if (event.getTarget()==b5) {
	            Platform.exit();
	            System.exit(0);
	        }
	    }
	  }
}