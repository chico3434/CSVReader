package org.chico3434.csvreader;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.chico3434.csvreader.CSV.CSV;

import java.io.File;
import java.util.List;

public class Table extends Stage {

    public Table(List<File> files) {
        File file = files.get(0);

        CSV csv = new CSV(file);

        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(csv.getCells());
        data.remove(0);

        TableView<String[]> tv = new TableView<>();

        int size = csv.getCells().get(0).length;

        for (int i = 0; i < size; i++){
            TableColumn column = new TableColumn(csv.getCells().get(0)[i]);

            int colNo = i;
            column.setCellValueFactory(new Callback<CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tv.getColumns().add(column);
        }
        tv.setItems(data);
        Scene scene = new Scene(tv, 600, 400);
        setTitle(file.getName());
        setScene(scene);
    }
}
