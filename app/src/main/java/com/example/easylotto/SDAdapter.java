package com.example.easylotto;


import java.io.File;
import android.os.Environment;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;
public class SDAdapter {

    public void saveGameToDisk(String Spielnummer, Integer Spieleranzahl, String Ziehungsdatum, Integer Volumen) {
        Spiel test = new Spiel(Spielnummer, Spieleranzahl, Ziehungsdatum, Volumen);
        //requestPermissions();
        File dump = new File(Environment.getExternalStorageDirectory(), Spielnummer + ".json");
        try {

            ObjectMapper mapper = new ObjectMapper();
            FileWriter out = new FileWriter(dump);
            mapper.writeValue(out, Spielnummer);
            out.close();
            System.out.println("file dumped to " + dump.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error opening Log." + e);
        }
    }

    public List<Spiel> readFromDisk() {
        //requestPermissions();
        File dir = Environment.getExternalStorageDirectory();
        File[] listOfFiles = dir.listFiles();

        List<Spiel> DoingsList = new ArrayList<Spiel>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".json")) {
                String SpielID = listOfFiles[i].getName().substring(0, listOfFiles[i].getName().indexOf("."));

                Spiel d = new Spiel(SpielID,10,"01.01.1990",1000);
                DoingsList.add(d);
                System.out.println("read as a Game: " + listOfFiles[i]);
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Not a Game file: " + listOfFiles[i].getName());
            }
        }
        return DoingsList;
    }
}