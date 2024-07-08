/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FlightManagementSystem;
import controller.Validation;

/**
 *
 * @author bravee06
 */
public class Menu {
   
    
    String[] mainMenu = {"Quản trị viên: Quản lí lịch trình chuyến bay","Khách hàng:Đặt vé máy bay và đặt chỗ","Khách Hàng: Check-in và đặt ghế","Quản trị viên: Quản lý phi hành đoàn và phân công công việc","Lưu trữ dữ liệu về chuyến bay, đặt vé, và phân công"};
    String[] oneMenu = {"Thêm chuyến bay mới","Hiển thị danh sách chuyến bay"};
    
    
    public int showMenu(String[] menu,String titleMenu){
        Validation valid = new Validation();
        System.out.println("==== " + titleMenu +" ====");
        int stt = 1;
        for(String option : menu){
            System.out.println(stt + " " + option);
            stt++;
        }
        return valid.checkInt("Chọn chức năng: ", 1, stt);
    }
    public void excute(){
        FlightManagementSystem fms = new FlightManagementSystem();
       
      
        while(true){
        
        int optionMain = showMenu(mainMenu,"Quản lí hàng không");
        
        switch(optionMain){
            case 1: fms.addNewFlight();break;
            case 2: fms.bookPassengerReservation();break;
            case 3: fms.performCheckIn();break;
            case 4: fms.manageCrewAssignments();
            case 5: break;
            default: 
                System.exit(1);
         
        }
        }
        
    }
    
    

}
