package com.kreitek.refactor.bien.Documents;

import java.util.Locale;

public class Nie extends Document{


    public Nie(String documentNumber) {
        super(documentNumber);
    }

    @Override
    public boolean validate() {
        String nie = this.getDocumentNumber().trim().replaceAll(" ", "").toUpperCase();

        if (nie.length() != 9){
            return false;
        }else{
            char nieFirstLetter = nie.charAt(0);

            if (nieFirstLetter == 'X'){
                nie = "0" + nie.substring(1,9);
            }else if (nieFirstLetter == 'Y'){
                nie = "1" + nie.substring(1,9);
            }else if (nieFirstLetter == 'Z'){
                nie = "2" + nie.substring(1,9);
            }else{
                System.out.println("La letra no es ni X, Y, Z, por lo que no es NIE.");
                return false;
            }

            String nieNumbers = nie.substring(0,8);

            if (isNumeric(nieNumbers) && isValidLetter(nieNumbers,nie)){
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean isValidLetter(String dniNumbers, String dni) {
        String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniNumValidate = Integer.parseInt(dniNumbers) % 23;
        char dniLetter = dni.charAt(8);
        if (dniChars.charAt(dniNumValidate) == dniLetter){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNumeric(String dniNumbers) {
        try {
            Integer.parseInt(dniNumbers);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
