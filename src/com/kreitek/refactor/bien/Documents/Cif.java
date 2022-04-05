package com.kreitek.refactor.bien.Documents;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cif extends Document{

    public Cif(String documentNumber) {
        super(documentNumber);
    }

    @Override
    public boolean validate() {
        String cif = this.getDocumentNumber().trim().replaceAll(" ", "").toUpperCase();

        if (cifPatronValidate(cif)){
            int numCtrl = cifCalculeNumCtrl(cifSumaParesImpares(cif));
            if (validateCtrlChar(numCtrl, cif)){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    private boolean validateCtrlChar(int numCtrl, String cif) {
        char cifFirstLetter = cif.charAt(0);
        char cifLastChar = cif.charAt(8);
        char cifCtrlLetter = "JABCDEFGHI".charAt(numCtrl);

        if ("PQSKW".indexOf(cifFirstLetter) != -1) {
            if (cifCtrlLetter != cifLastChar){
                return false;
            }

        } else if ("ABEH".indexOf(cifFirstLetter) != -1) {
            if (!(cifLastChar >= '0' && cifLastChar <= '9')){
                return false;
            }else{
                int lastChar = Integer.parseInt(Character.toString(cifLastChar));
                if (numCtrl != lastChar){
                    return false;
                }
            }
        } else {
            int lastChar = "JABCDEFGHI".indexOf(cifLastChar);
            if (lastChar < 0){
                lastChar = Integer.parseInt(Character.toString(cifLastChar));
                if (numCtrl != lastChar){
                    return false;
                }
            }

            if ((numCtrl != lastChar) && (cifCtrlLetter != cifLastChar)){
                return false;
            }
        }
        return true;
    }

    private int cifCalculeNumCtrl(int cifSumaParesImpares) {
        Integer numCtrl = 10 - (cifSumaParesImpares % 10);

        if (numCtrl == 10){ numCtrl = 0; }

        return numCtrl;
    }

    private int cifSumaParesImpares(String cif) {
        String cifNumbers = cif.substring(1,8);
        int sumaPares = 0;

        for (int i = 1; i <= cifNumbers.length() - 1; i = i + 2) {
            sumaPares += Integer.parseInt(cifNumbers.substring(i, i + 1));

        }

        int sumaImpares = 0;
        for (int i = 0; i <= cifNumbers.length() - 1; i = i + 2) {
            Integer cal = Integer.parseInt(cifNumbers.substring(i, i + 1)) * 2;
            if (cal.toString().length() > 1) {
                cal = Integer.parseInt(cal.toString().substring(0, 1)) + Integer.parseInt(cal.toString().substring(1, 2));
            }
            sumaImpares += cal;
        }

        Integer total = sumaPares + sumaImpares;

        return total;

        }

    private boolean cifPatronValidate(String cif) {
        final Pattern mask = Pattern.compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        final Matcher matcher = mask.matcher(cif);
        if (!matcher.matches()){
            return false;
        }else{
            return true;
        }
    }
}
