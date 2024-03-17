package lt.viko.eif.mjakovcenko.bankapp.menu;

import lt.viko.eif.mjakovcenko.bankapp.db.ClientLoader;
import lt.viko.eif.mjakovcenko.bankapp.db.DBLoader;
import lt.viko.eif.mjakovcenko.bankapp.db.GenericObjectLoader;
import lt.viko.eif.mjakovcenko.bankapp.model.Client;
import lt.viko.eif.mjakovcenko.bankapp.server.JavaServer;
import lt.viko.eif.mjakovcenko.bankapp.util.JaxbUtil;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

/**
 * Menu class represents switch-case system. 1 case loads all data about clients using ClientLoader class loadClients() method.
 * 2 case loads all data about employees using EmployeeLoader class loadEmployee() method.
 *
 * @see ClientLoader
 */
public class Menu {

    /**
     * displayMenu method shows possible choices for the switch-case.
     * @param input user's input in console.
     * @return method returns user's input converted to integer.
     */
    public static int displayMenu(Scanner input){
        System.out.println("Make a selection");
        System.out.println("------------------");
        System.out.printf("| 1) %20s \n", "Load clients");
        System.out.printf("| 2) %20s \n", "Convert to xml");
        System.out.printf("| 3) %20s \n", "Convert to pojo");
        System.out.printf("| 4) %20s \n", "Send file over network");
        System.out.printf("| 6) %20s \n", "Quit");
        return input.nextInt();
    }

    /**
     * showMenu method uses user's input to choose what case to do.
     * case 1: loads data about clients.
     * case 2: converts object to xml file
     * case 3: converts xml file to pojo classes.
     * case 4: starts servers and sends xml file over network.
     * case 5: starts server and sends xsd file over network.
     * case 6: exits from application.
     */
    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        int userChoice;
        do{
            userChoice = displayMenu(input);
            switch(userChoice){
                case 1:
                    ClientLoader.loadClients();
                    break;
                case 2:
                    try {
                        JaxbUtil.convertToXML(GenericObjectLoader.loadById(Client.class,1));
                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        JaxbUtil.transformToPojo(GenericObjectLoader.loadById(Client.class,1),"Client.xml");
                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    JavaServer javaServer = new JavaServer();
                    javaServer.start(7777,"Client.xml");
                    break;
                case 5:
                    JavaServer javaServer1 = new JavaServer();
                    javaServer1.start(7777,"client.xsd");
                    break;
                case 6:
                    System.out.println("Quitting");
                    System.exit(0);
                    break;
                default:

                    break;

            }
        }while(userChoice!=6);
    }
}