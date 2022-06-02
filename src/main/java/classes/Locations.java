package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Locations {
    //State,City,Latitude,Longitude  <- order  of each String[]
    private ArrayList<String[]> strLocationArrayList = new ArrayList<>();

    {
        String callFileStr;
        try {
            File callFile = new File("src/main/resources/locations.txt");
            Scanner reader = new Scanner(callFile);
            while (reader.hasNextLine()) {
                callFileStr = reader.nextLine();
                String[] textLine = callFileStr.split(",");
                strLocationArrayList.add(textLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Locations(){

    }

    public ArrayList<String> locationNamesList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (String[] strItem : strLocationArrayList){
            String newPlace =   strItem[1] + ", " + strItem[0];
            nameList.add(newPlace);
        }
        Collections.sort(nameList);
        return nameList;
    }




}
