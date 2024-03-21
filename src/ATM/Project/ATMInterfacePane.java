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
import javafx.scene.control.TextInputControl;
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
	private boolean BalanceCheck = false;
	private double AvailableBalance =500.00;
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
    	ObservableList<String> options = FXCollections.observableArrayList("Withdrawal","Deposit Cash","Check Available Balance");
    	cBox.setItems(options);
    	
		cBox.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.equals("Withdrawal")){
					Type = new String(newValue);
					Withdrawal = true; 
					Deposit = false; 
					BalanceCheck=false;
				}
				else if(newValue.equals("Deposit Cash")) {
					Type = new String(newValue);
					Deposit = true; 
					Withdrawal = false; 
					BalanceCheck=false;
				}
				else if(newValue.equals("Check Available Balance")){
					Type = new String(newValue);
					Deposit = false; 
					Withdrawal = false; 
					BalanceCheck=true;
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
			
			if( ((Deposit == false) && (Withdrawal==true) &&(BalanceCheck == false)) || ((Deposit == true) && (Withdrawal ==false) &&(BalanceCheck == false)) || ((Deposit ==false)&&(Withdrawal ==false)&&(BalanceCheck ==true)))
			{	
				if(BalanceCheck==false) {
					alert(AlertType.INFORMATION, "You are doing a "+Type+" Transaction"); 
				}else if(BalanceCheck==true) {
					alert(AlertType.INFORMATION, "Checking Balance."); 
				}
				
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
		else if(BalanceCheck == true){
			BalanceGui();
		}
		
	}
	private void BalanceGui() {
		// TODO Auto-generated method stub
		//Elements
		Label BalanceLabel = new Label("Balance Check"); 
		Label AvailableBalanceLabel = new Label("Available Balance:"); 
		TextField portField = new TextField("2023");
		Button bindButton = new Button("Withdrawal Amount");  
		Button addFilesButton = new Button("Withdraw"); 
		TextArea listArea = new TextArea("List: \n"); 
		TextArea statusArea = new TextArea("Status Area: \n"); 
		Button quitButton = new Button("Quit"); 
		
		//Arranging Elements
		HBox firstHBox = new HBox(5, BalanceLabel, portField, bindButton);
		
		VBox vBox = new VBox(10, AvailableBalanceLabel, addFilesButton, firstHBox, listArea, statusArea, quitButton); 
		this.getChildren().add(vBox); 
		
		//Styling
		AvailableBalanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		BalanceLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
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
	private void WithdrawalGui()
	{
		//Elements
		Label MainLabel = new Label("Withdrawal"); 
		Label BalanceLabel = new Label("Available Balance:"); 
		TextField AvailableField = new TextField("R "+ AvailableBalance);
		AvailableField.setEditable(false);
		Label AmountWithdraw = new Label("Enter Withdrawal Amount");  
		Button WithdrawButton = new Button("Withdraw"); 
		TextField WithdrawalAmount = new TextField(); 
		WithdrawalAmount.setPromptText("R100");
		TextArea statusArea = new TextArea("Status Area: \n"); 
		Label $Account_Type = new Label("Account Type:"); 
		ComboBox<String> cBox1 = new ComboBox<>();
    	ObservableList<String> Options = FXCollections.observableArrayList("Cheque","Savings","Credit");
    	cBox1.setItems(Options);
    	cBox1.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.equals("Cheque")){
					//Type = new String(newValue);
				
				}
				else if(newValue.equals("Savings")) {
					//Type = new String(newValue);
				
				}
				else if(newValue.equals("Credit")){
					//Type = new String(newValue);
					
				}
			}
		});
    	Button quitButton = new Button("Quit"); 
		
		//Arranging Elements
		HBox firstHBox = new HBox(5, MainLabel,BalanceLabel, AvailableField);
		
		VBox vBox = new VBox(10, MainLabel,  firstHBox,AmountWithdraw ,WithdrawalAmount, $Account_Type,cBox1,WithdrawButton, statusArea, quitButton); 
		this.getChildren().add(vBox); 
		
		//Styling
		MainLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		MainLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		
		statusArea.setEditable(false);
		AvailableField.setMaxWidth(55);
		
		//adding to the root
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		
		//Attributes
		
		
	
		
		WithdrawButton.setOnAction((event) ->
		{
			//var Amounttowithdraw = WithdrawalAmount.getText();
			//read the list file for the last file id wrote
            withdraw( Integer.parseInt(WithdrawalAmount.getText()));
            
			if((Integer.parseInt(WithdrawalAmount.getText()) > AvailableBalance)) {
				alert(AlertType.INFORMATION, "You Have Insufficient Funds!"); 
				statusArea.setText("Status: \n  Your Withdrawal Transaction Was Unsuccesful!");
				return;
			}else if((Integer.parseInt(WithdrawalAmount.getText()) < 0)) {
				//alert(AlertType.INFORMATION, "You cant withdraw a negative amount!"); 
				statusArea.setText("Status: \n  Your Withdrawal Transaction Was Unsuccesful!");
				return;
			}
			statusArea.setText("Status: \n  Your Withdrawal Transaction Was Succesful!");
			AvailableField.setText("R"+ AvailableBalance);
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
		Label DepositLabel = new Label("Deposit Funds"); 
		Label HeadingLabel = new Label("Enter Your Information"); 
		Label AccountNumberLabel = new Label("Account Number:");
		TextField AccountNumberField = new TextField(); 
		AccountNumberField.setPromptText("4251 5689 1234");
		Label RecRefLabel = new Label("Receipient Reference:");
		
		TextField RecRefTextField = new TextField();
		RecRefTextField.setPromptText("Yingisani Honest");
		Label ResenderRefLabel = new Label("Sender Refrence:");
		TextField ResenderRefTextField = new TextField();
		ResenderRefTextField.setPromptText("SHIVAMBU YH");
		Label AmountLabel = new Label("Amount");
		TextField AmountField = new TextField(); 
		AmountField.setPromptText("R200");
		Label ProcessLabel = new Label("Press Button To complete Transaction"); 
		Button DepositButton = new Button("Deposit");  
		TextArea statusArea = new TextArea("Status Area:\n");
		Label NewBalanceLabel = new Label("New Balance:");
		TextField NewField = new TextField(); 
		
		//Arranging 
		HBox firstHBox = new HBox(10, AccountNumberLabel, AccountNumberField, AmountLabel, AmountField); 
		HBox SecondtHBox = new HBox(10, RecRefLabel, RecRefTextField); 
		HBox ThirdfirstHBox = new HBox(10, ResenderRefLabel, ResenderRefTextField); 
		HBox secHBox = new HBox(10, DepositButton); 
		HBox FourththHBox = new HBox(10,NewBalanceLabel,NewField);
		
		VBox vBox = new VBox(10, DepositLabel, HeadingLabel, firstHBox,SecondtHBox,ThirdfirstHBox,ProcessLabel ,secHBox, statusArea,FourththHBox); 
		
		//styling
		DepositLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		HeadingLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 17));
		HeadingLabel.underlineProperty().setValue(true);
		RecRefLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		ResenderRefLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		ProcessLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 17));
		ProcessLabel.underlineProperty().setValue(true);
		RecRefLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		ResenderRefLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		AmountLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
		statusArea.setEditable(false);
		statusArea.setMaxHeight(100);
		AmountLabel.setMaxWidth(55);
		
		//adding
		this.getChildren().add(vBox); 
		
		//Positioning
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		
		
		DepositButton.setOnAction((event) -> 
		{
		  depositCash(Integer.parseInt(AmountField.getText()));
		  NewField.setText("R"+AvailableBalance);
		  
			
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
	
	private void withdraw(int $withdwal_Amount) {
		if ($withdwal_Amount > AvailableBalance) {
			alert(AlertType.INFORMATION, "You Have Insufficient Funds to make a withdraw Transaction!"); 
			//return $balance;
		}else if($withdwal_Amount <0){
			alert(AlertType.INFORMATION, "Amount cannot be less than 0!"); 
			//return $balance;
		}else {
			 AvailableBalance-=$withdwal_Amount;
		}
		
		
	}
	private void depositCash(double DepositAmount) {
		if(DepositAmount >0) {
			AvailableBalance+= DepositAmount;
		}else {
			alert(AlertType.INFORMATION, "Please provide a deposit Amount greater than 0!"); 
			
		}
	}
}
