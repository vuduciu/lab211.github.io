/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author bravee06
 */
public class Menu {
   
    
    String[] mainMenu = {"Quản lí lịch trình chuyến bay","Đặt vé máy bay và đặt chỗ cho hành khách","Quá trình check-in và phân bổ ghế cho hành khách","Quản lý phi hành đoàn và phân công công việc","Quản trị viên - Quản lý hệ thống","Lưu trữ dữ liệu về chuyến bay, đặt vé, và phân công"};
    String[] oneMenu = {"Thêm chuyến bay mới","Hiển thị danh sách chuyến bay"};
    
    
    public void showMenu(String[] menu,String titleMenu){
        System.out.println("==== " + titleMenu +" ====");
        int stt = 1;
        for(String option : menu){
            System.out.println(stt + " " + option);
            stt++;
        }
    }
    public void excute(){
        
    }

}
