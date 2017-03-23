import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
			Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
	        Scene scene = new Scene(root, 600, 400);

	        stage.setResizable(false);
	        stage.setTitle("Whac-A-Mole");
	        stage.setScene(scene);
	        stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

}
