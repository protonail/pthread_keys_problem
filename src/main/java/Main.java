import com.sun.jna.Native;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(Main.class);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(createScene(primaryStage));
        primaryStage.show();
    }

    private Scene createScene(Stage parentStage) {
        Label lblValue = new Label("Value N/A");
        lblValue.setMinWidth(100.0);

        Button btnGetValue = new Button("Get Value");
        btnGetValue.setOnAction(event -> {
            lblValue.setText(String.valueOf(NativeWrapper.Get42()));
        });

        Button btnShowSaveDialog = new Button("Show Save Dialog and Get Value");
        btnShowSaveDialog.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.showSaveDialog(parentStage);

            lblValue.setText(String.valueOf(NativeWrapper.Get42()));
        });

        return new Scene(new HBox(7.0, lblValue, btnGetValue, btnShowSaveDialog));
    }

    public static class NativeWrapper {
        static {
            Native.register("pthread_keys_problem");
        }

        public static native int Get42();
    }
}
