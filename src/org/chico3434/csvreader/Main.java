package org.chico3434.csvreader;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();

        Scene scene = new Scene(vBox, 400, 300);

        HBox pane = new HBox();
        Label msg = new Label("Arraste para cá o CSV");
        pane.getChildren().add(msg);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-border-color: blue; -fx-border-style: dashed; -fx-border-width: 4px; -fx-padding: 100px");

        pane.setOnDragExited(e -> {
            msg.setText("Arraste para cá o CSV");
        });
        pane.setOnDragOver(e -> {
            msg.setText("Solte");
        });
        pane.setOnDragEntered(e -> {
            if (e.getDragboard().hasFiles()) {
                Table table = new Table(e.getDragboard().getFiles());
                table.show();
                stage.close();
            }
        });

        vBox.getChildren().add(pane);

        stage.setTitle("CSVReader");
        stage.setScene(scene);
        stage.show();
    }
}
