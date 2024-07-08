/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bravee06
 */
public class FileManage implements IFileManage {

    @Override
    public void saveToFile(List objList, String fileName) {
        
        try (FileWriter fw = new FileWriter(fileName)) {
            
            for (Object obj : objList) {
                if(obj == null){
                    continue;
                }
                fw.write(obj + "\n");
            }
            System.out.println("Save Data Success");
        } catch (IOException ex) {
            Logger.getLogger(FileManage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Override
    public List<String> loadFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {                
                if (!line.isEmpty()) {
                    result.add(line);
                }            
            }
            System.out.println("Load Data Success");
        } catch (IOException ex) {
            Logger.getLogger(FileManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
}
