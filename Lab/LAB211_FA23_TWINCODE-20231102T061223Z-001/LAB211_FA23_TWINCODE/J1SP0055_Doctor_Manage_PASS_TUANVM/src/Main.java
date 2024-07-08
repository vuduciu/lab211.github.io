
import view.ConsoleUI;
import controller.Application;

public class Main {
    
    public static void main(String[] args) {
        ConsoleUI cui = new ConsoleUI();
        // create object View and pass to Application
        Application application = new Application(cui);    
        // call function to run program
        application.run();
    }

}
