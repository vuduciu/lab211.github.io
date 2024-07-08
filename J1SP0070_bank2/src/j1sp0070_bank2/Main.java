/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0070_bank2;

import static j1sp0070_bank2.Bank.checkMenu;
import static j1sp0070_bank2.Bank.login;
import static j1sp0070_bank2.Bank.menu;
import java.util.Locale;

/**
 *
 * @author duc
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        
        Locale vn = new Locale("vn", "VN");
        Locale en = Locale.US;
        menu();
        int choice = checkMenu(1, 3);
        switch (choice) {
            case 1:
                login(vn);
                break;
            case 2:
                login(en);
            case 3:
                break;
        }
    }
}
