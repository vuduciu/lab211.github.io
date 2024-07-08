/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recusion;

import java.util.Scanner;

/**co n dia de sap xep o coc nguon thu tu dia lon o duoi nho phai khong o tren dia lon 
 * nhiem vu chuyen n dia coc dich chuyen cau trong qua trinh chuyen qua trinh chuyen vao phai dam bao dai nho hon o
 * tren dia lon nhung duoc phep muon them 1 coc lam trung gian
 *
 * @author duc
 */
public class ThapHN {
     static int step =1;
     static void Thap(String nguon,String dich,String tg,int s1){
         
         if(s1==1){
             System.out.println(step+"Move a disk from "+nguon+" to "+dich);
         }else{
             Thap(nguon, tg, dich, s1-1);//chuyen n-1 dia tu coc nguon sang trung gian muon dich
             Thap(nguon,dich,tg,1);//chuyen mot diatu nguon sang dich
             Thap(tg,dich,nguon,s1-1);//chuyen n-1 dia tu trung gian ve dich muon nhuon la trung gian
             
         }
     }
     public static void main(String[] args) {
         int n;
         System.out.println("nhap vao so dia:");
         Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
         Thap("Coc nguon","Coc dich","co trung gian",n);
        
    }
    
        
    
    
}
