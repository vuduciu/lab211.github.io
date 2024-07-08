/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author bravee06
 */
public interface IFileManage {
    void saveToFile(List objList, String fileName,String titleData);
   
    List<String> loadFromFile(String fileName);
}
