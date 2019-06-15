package serwis;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Stage primaryStage;
    private AnchorPane rootLayout;
    
    /*private final ObservableList<Obraz> data =
            FXCollections.observableArrayList(
            	new Obraz ("1", "2","3","4","5","6","7","8","9")
            );   */
    
    
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Witam");
        
        initRootLayout();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void initRootLayout() {
	    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Wstep.fxml"));
            rootLayout = (AnchorPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	    }
}
