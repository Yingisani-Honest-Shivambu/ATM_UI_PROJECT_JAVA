/**
 * 
 */
package ATM.Project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author YH SHIVAMBU
 *
 */
public class Main extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		try
		{
			ATMInterfacePane root = new ATMInterfacePane(primarystage);
			Scene scene = new Scene(root); 
			
			primarystage.setTitle("Mzansi Bank");
			primarystage.setHeight(500);
			primarystage.setWidth(600);
			primarystage.setScene(scene); 
			
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
			System.err.println("Please Select the type of Transaction Type You wanna Make, start method");
		}
	}

}
