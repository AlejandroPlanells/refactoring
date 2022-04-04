package com.kreitek.refactor.bien.Documents;

import java.util.Locale;

public class Dni extends Document{


    public Dni(String documentNumber) {
        super(documentNumber);
    }

    @Override
    public boolean validate() {
        String dni = this.getDocumentNumber().trim().replaceAll(" ", "").toUpperCase();

        if (dni.length() != 9){
            return false;
        }else{
            String dniNumbers = dni.substring(0,8);
            if (isNumeric(dniNumbers) && isValidLetter(dniNumbers, dni)){
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
