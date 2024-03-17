package lt.viko.eif.mjakovcenko.bankapp;

import lt.viko.eif.mjakovcenko.bankapp.db.DBLoader;
import lt.viko.eif.mjakovcenko.bankapp.menu.Menu;
import lt.viko.eif.mjakovcenko.bankapp.model.Client;
import lt.viko.eif.mjakovcenko.bankapp.util.JaxbUtil;
/**
 * Main class is responsible for initiating the application's
 * components and interactions. This class might include operations such as loading database configurations
 * and presenting the main menu to the user.
 */
public class Main {
public static void main(String[] args){
    // new DBLoader();
    Menu.showMenu();
}

}