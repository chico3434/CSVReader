package org.chico3434.csvreader.CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSV {
    private List<String[]> cells;

    public CSV(File file) {
        cells = new ArrayList<>();
        abrir(file);
    }

    public void abrir(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Iterator it = br.lines().iterator();
            while (it.hasNext()){
                String linha = (String) it.next();
                cells.add(linha.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getCells() {
        return cells;
    }
}
