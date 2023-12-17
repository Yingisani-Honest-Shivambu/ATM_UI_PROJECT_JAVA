/**
 * 
 */
package ATM.Project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author YH SHIVAMBU
 *
 */
public class ATMInterfacePane extends GridPane{
	private Stage primarystage = null;
	private String Type = null;
	private boolean Withdrawal = false;
	private boolean Deposit = false;
	
	public ATMInterfacePane(Stage PrimaryStage) {
		this.primarystage = PrimaryStage;
		TypeSelector();
	}
    public void TypeSelector() {
    	GridPane selectorPane = new GridPane(); 
    	Stage stage = new Stage();
    	Scene scene = new Scene(selectorPane,300,200);
    	stage.setTitle("Select Type Of Transaction.");
    	stage.setScene(scene);
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.show();
    	
    	//The mode list 
    	ComboBox<String> cBox = new ComboBox<>();
    	ObservableList<String> options = FXCollections.observableArrayList("Withdrawal","Deposit Cash");
    	cBox.setItems(options);
    	
		cBox.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.equals("Withdrawal")){
					Type = new String(newValue);
					Withdrawal = true; 
					Deposit = false; 
				}
				else if(newValue.equals("Deposit")) {
					Type = new String(newValue);
					Deposit = true; 
					Withdrawal = false; 
				}
				else {
					Deposit = false; 
					Withdrawal = false; 
					
				}
			}
		});
		
		Text text1 = new Text("Welcome to Mzansi Bank.");
		Text text2 = new Text("Please select the type of transaction you wanna do."); 
		Label modeLabel = new Label("Type:"); 
		text1.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 16));
		text2.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.ITALIC , 12));
		modeLabel.setFont(Font.font("Arial", FontWeight.BLACK, 15));
		
		Button nextButton = new Button("Next"); 
		
		selectorPane.add(text1, 0, 0); 
		selectorPane.add(text2, 0, 1);  
		selectorPane.add(new HBox(12, modeLabel, cBox) ,0, 2); 
		selectorPane.add(nextButton, 0, 3); 
		selectorPane.setPadding(new Insets(10));
		selectorPane.setVgap(10);
		selectorPane.setAlignment(Pos.CENTER);
		
		nextButton.setOnAction((event) -> {
			
			if( ((Deposit == false) && (Withdrawal==true)) || ((Deposit == true) && (Withdrawal ==false)) )
			{	
				alert(AlertType.INFORMATION, "You are doing a "+Type+" Transaction"); 
				primarystage.show(); 
				stage.close(); 
				
				//gui setup for either seeder of leecher depending on what's selected
				guiSetup();
			}
		});
    }
    /**
	 * This method set up the user interface based of the choice of the user
	 */
	private void guiSetup()
	{
		if(Withdrawal == true){
			//gui setup for seeder
			WithdrawalGui();
			
		}
		else if(Deposit == true) {
			//gui setup for leecher
			DepositGui();
		}
		else {
		}
		
	}
	private void WithdrawalGui()
	{
		//Elements
		Label seederLabel = new Label("Withdrawal"); 
		Label portLabel = new Label("Available Balance:"); 
		TextField portField = new TextField("2023");
		Button bindButton = new Button("Withdrawal Amount");  
		Button addFilesButton = new Button("Withdraw"); 
		TextArea listArea = new TextArea("List: \n"); 
		TextArea statusArea = new TextArea("Status Area: \n"); 
		Button quitButton = new Button("Quit"); 
		
		//Arranging Elements
		HBox firstHBox = new HBox(5, portLabel, portField, bindButton);
		
		VBox vBox = new VBox(10, seederLabel, addFilesButton, firstHBox, listArea, statusArea, quitButton); 
		this.getChildren().add(vBox); 
		
		//Styling
		seederLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		portLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		listArea.setEditable(false);
		statusArea.setEditable(false);
		portField.setMaxWidth(55);
		
		//adding to the root
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		
		//Attributes
		
		
		//actions
		bindButton.setOnAction((event) ->
		{
			
			
		});
		
		addFilesButton.setOnAction((event) ->
		{
			//read the list file for the last file id wrote
			
			
			
		});
		quitButton.setOnAction((event) ->
		{
			
		});
	}
	/**
	 * This method defines the user interface of the leecher
	 */
	private void DepositGui()
	{
		//Elements
		Label leecherLabel = new Label("Deposit Funds"); 
		Label conToServerLabel = new Label("Connect To Seeder"); 
		Label addressLabel = new Label("Address");
		TextField addressField = new TextField("localhost"); 
		Label portLabel = new Label("Port");
		TextField portField = new TextField("2022"); 
		Button connectButton = new Button("Connect"); 
		Label requestLabel = new Label("Request"); 
		Button getListButton = new Button("Get List"); 
		Label getFileLabel = new Label("Get File"); 
		TextField getFileField = new TextField(); 
		Button getFileButton = new Button("Get File"); 
		TextArea listArea = new TextArea("List:\n"); 
		TextArea statusArea = new TextArea("Status Area:\n");
		
		//Arranging 
		HBox firstHBox = new HBox(10, addressLabel, addressField, portLabel, portField, connectButton); 
		HBox secHBox = new HBox(10, getListButton, getFileLabel, getFileField, getFileButton); 
		
		VBox vBox = new VBox(10, leecherLabel, conToServerLabel, firstHBox,requestLabel ,secHBox, listArea, statusArea); 
		
		//styling
		leecherLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		conToServerLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 17));
		conToServerLabel.underlineProperty().setValue(true);
		addressLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		requestLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 17));
		requestLabel.underlineProperty().setValue(true);
		addressLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		portLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		getFileLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		listArea.setEditable(false);
		statusArea.setEditable(false);
		statusArea.setMaxHeight(100);
		listArea.setMaxHeight(150);
		portField.setMaxWidth(55);
		getFileField.setMaxWidth(50);
		
		//adding
		this.getChildren().add(vBox); 
		
		//Positioning
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		
		//actions
		connectButton.setOnAction((event) -> 
		{
			
			
		});
		getListButton.setOnAction((event) -> 
		{
		
			
		});
		getFileButton.setOnAction((event) -> 
		{
			
			
		});
		
		
		
	}
	/**
	 * This method defines a general use case of the AlertType
	 * @param aT AlertType	
	 * @param message Alert message
	 */
	private void alert(AlertType aT, String message)
	{
		Alert alert = new Alert(aT); 
		alert.setContentText(message);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();
	}
}
