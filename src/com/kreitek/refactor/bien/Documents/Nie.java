package com.kreitek.refactor.bien.Documents;

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

    public boolean isValidLetter(String nieNumbers, String nie) {
        String nieChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        int nieNumValidate = Integer.parseInt(nieNumbers) % 23;
        char nieLetter = nie.charAt(8);
        if (nieChars.charAt(nieNumValidate) == nieLetter){
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
