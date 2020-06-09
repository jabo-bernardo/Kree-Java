package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.Debug;

import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Prefs extends Component {
    private File data;
    private void createFile() {
        try {
            this.data = new File("data.txt");
            if (data.createNewFile()) {
                Debug.log("File created: " + data.getName());
            } else {
                Debug.log("File already exists.");
            }
        } catch (IOException e) {
            Debug.error("An error occurred.");
            e.printStackTrace();
        }
    }

    public Prefs() {
        this.name = "Prefs";
        createFile();
    }

    @Override
    public void Update() {

    }

    public void storeFloat(String name, float value) {
        try {
            FileWriter myWriter = new FileWriter("data.txt");
            myWriter.write(name + "=" + value);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public float getFloat(String name) {
        try {
            Scanner myReader = new Scanner(data);
            String value = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String var_name = "";
                boolean still_add = true;
                boolean search = false;
                for(int i=0;i<data.length();i++) {
                    if(!still_add && search) {
                        value+=data.charAt(i);
                    }
                    if(data.charAt(i)!='=' && still_add) {
                        var_name+=data.charAt(i);
                    } else {
                        still_add=false;
                        if(var_name.equals(name)) {
                            search = true;
                        }
                    }
                }
                Debug.error(value);
                return Float.parseFloat(value);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0f;
    }

    @Override
    public void Render(Graphics g) {

    }

}
