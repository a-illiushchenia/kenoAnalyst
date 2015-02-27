package com.illiushchenie.kenoAnalyst;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by a.illiushchenia on 24.02.2015.
 */
public class MenuDisplay {
    public void displayMenu(){


        HashMap<String, Boolean> statusFlags = new HashMap<String, Boolean>();
        statusFlags.put("flagMenuPointInputError", false);
        statusFlags.put("flagExit", false);

        while(true) {
            Integer menuPointInt = null;

            printMenu(statusFlags.get("flagMenuPointInputError"));
            statusFlags.put("flagMenuPointInputError", false);

            try {
                menuPointInt = getUserInputNumber();
            }catch (NumberFormatException e){
                statusFlags.put("flagMenuPointInputError", true);
            }

            if (!statusFlags.get("flagMenuPointInputError")) {
                defineAndExecuteAction(menuPointInt, statusFlags);
            }

            if (statusFlags.get("flagExit")){
                return;
            }
        }
    }

    private void defineAndExecuteAction(Integer menuPointInt, HashMap<String, Boolean> statusFlags) {
        switch (menuPointInt) {
            case 1:
                break;
            case 0:
                statusFlags.put("flagExit", true);
                break;
            default:
                statusFlags.put("flagMenuPointInputError", true);
        }
    }

    private Integer getUserInputNumber() throws NumberFormatException{
        Integer menuPointInt = null;

        Scanner scanner = new Scanner(System.in);
        String menuPoint = scanner.nextLine();
        menuPoint = menuPoint.trim();
        menuPointInt = Integer.parseInt(menuPoint);

        return menuPointInt;
    }

    private void printMenu(Boolean flagMenuPointInputError) {

        if (flagMenuPointInputError) {
            System.out.println("Vi dopustili oshibky pri vvode punkta menu");
        }
        System.out.println("Vvedite:");
        System.out.println("1 - dlia podscheta statistiki za ves period");
        System.out.println("0 - dlia vihoda iz programmi");
    }


}
