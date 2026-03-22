package additionGUI;
//import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/*
 * Author: COP2551C
 * Date: 
 * Description: coding the addition of two doubles using a GUI coded with javaFX  (see the other video using the 'swing' library
 */

public class additionGUI extends Application
{
	//necessary text boxes for the output:
	private TextField aText, bText;
	private Label resultLabel;
	public static void main(String[] args) 
	{
		 launch(args);
	}//end main
	//---------------------------------------------------------- 
	public void start(Stage stage) 
	{
		//setting up the two input boxes:
		aText = new TextField("0.00");
		bText = new TextField("0.00");
		//laying down both the text fields and their related labels
		HBox aPane = new HBox(new Label("a: "), aText);
		HBox bPane = new HBox(new Label("b: "), bText);
		//let's add a button and code the related event and set its related HBox
		Button add = new Button("Add");
		add.setOnAction(e -> performAddition());
		HBox buttonPane = new HBox(add);
		//let's format this button within its HBox
		HBox.setHgrow(add,  Priority.ALWAYS);
		add.setMaxWidth(Double.POSITIVE_INFINITY);
		//let's format the labels:
		resultLabel = new Label("a + b = 0.0");
		resultLabel.setTextFill(Color.BLUE);
		resultLabel.setStyle("-fx-font-weight:bold");
		resultLabel.setAlignment(Pos.TOP_LEFT);
		resultLabel.setMaxWidth(Double.POSITIVE_INFINITY);
		//major overall alignment:
		VBox coreBox = new VBox(5, aPane, bPane, buttonPane, resultLabel);
		coreBox.setPadding(new Insets(15,8,15,8));
		coreBox.setStyle("-fx-border-color: black ; -fx-border-width:2px");
		//building and working on the scene
		Scene Addscene = new Scene(coreBox); //just created a scene and put in it the coreBox with everything in it
		stage.setScene(Addscene);
		stage.setTitle("ADDITION");
		stage.setResizable(true);
		stage.show();
	}//end start
	//------------------------------------------------------------------------------
	private void performAddition()
	{
		double a = 0.0;
		double b = 0.0;
		//taking care of input a:
		try
		{
			String aStr = aText.getText();  //whatever value the user enter in aText is now inside the var aStr
			//validate  ...this is your own validation NOT the current exception handling
			a = Double.parseDouble(aStr);
		}//end try
		catch(NumberFormatException e)
		{
			resultLabel.setText("Invalid data entered for a!");
			resultLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
			return;
		}//end catch for a
		//..................................................
		//taking care of input b: 
		try
		{
			String bStr = bText.getText();  //whatever value the user enter in aText is now inside the var aStr
			//validate  ...this is your own validation NOT the current exception handling
			b = Double.parseDouble(bStr);
		}//end try
		catch(NumberFormatException e)
		{
			resultLabel.setText("Invalid data entered for b!");
			resultLabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			return;
		}//end catch for b
		//==================================================ready to add:
		resultLabel.setText("a + b = " + (a + b));
		
	}//end perform addition

}//end class additionGUI
