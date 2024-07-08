/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bravee06
 */
public class FileManage implements IFileManage{

    @Override
    public void saveToFile(List objList, String fileName,String titleData) {
       
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(titleData + "\n");
            for (Object obj : objList) {
                fw.write(obj + "\n");
            }
        } catch (IOException ex) {
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
        } catch (IOException ex) {
        }
        
        return result;
    }
    
}
