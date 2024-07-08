
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Manager {

    //display  menu
    public static int menu() {
        System.out.println("----------Menu-----------");
        System.out.println("1. Add new word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search word.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    //add new word
    public static void addNewWord(HashMap<String, String> hm) {
        System.out.println("----------Add-----------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        //check key word english exist or not

        hm.put(english, vietnam);
        System.err.println("Add successful.");

    }

    //delete word
    public static void deleteWord(HashMap<String, String> hm) {
        System.out.println("----------Delete-----------");
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        if (!hm.containsKey(english)) {
            System.err.println("Word not found in the data.");
            return;
        }
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    //translate
    public static void translate(HashMap<String, String> hm) {
        System.out.println("----------Translate-----------");
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    //check key englist exist
    public static boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
