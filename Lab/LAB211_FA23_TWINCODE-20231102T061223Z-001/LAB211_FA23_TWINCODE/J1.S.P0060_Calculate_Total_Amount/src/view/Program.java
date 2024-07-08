
package view;

import controller.Transaction;
import model.Person;


public class Program {
    public void excute(){
        InputGUI inputGUI = new InputGUI();
        ResultGUI resultGUI = new ResultGUI();
        Transaction transaction = new Transaction();
        String titleMenu = "Shopping program";
        Person person = inputGUI.inputTransactionData(titleMenu);
        int[] bills = person.getBills();
        int total = transaction.calcTotal(bills);
        boolean payment_status = person.getWallet().payMoney(total);
        resultGUI.showResult(payment_status, total);
    }
}
