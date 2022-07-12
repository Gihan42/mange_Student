import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Appinitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/dashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    }

