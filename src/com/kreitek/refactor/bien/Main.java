package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.Documents.Dni;
import com.kreitek.refactor.bien.Documents.Document;
import com.kreitek.refactor.bien.Documents.Nie;

class  Main {
    public static void main(String args[]) {

        printBanner();

        Document nie = new Nie("Y8298641w");
        System.out.println(nie.validate());

        //Document dni = new Dni("66604205T");
        //System.out.println(dni.validate());

        printBanner();


        // creamos un DNI correcto
        DNI dniCorrecto = new DNI(DocumentType.DNI, "11111111H", null);
        Boolean esValido = (dniCorrecto.validarDNI() == 1);

        // creamos un DNI incorrecto
        DNI dniIncorrecto01 = new DNI(DocumentType.DNI, "24324356A", null);
        Boolean esValido01 = (dniIncorrecto01.validarDNI() == 1);

        // creamos un NIE correcto
        DNI nieCorrecto = new DNI(DocumentType.NIE, "X0932707B", null);
        Boolean esValidoNie = (nieCorrecto.validarDNI() == 1);

        // creamos un NIE incorrecto
        DNI nieIncorrecto = new DNI(DocumentType.NIE, "Z2691139Z", null);
        Boolean esValidoNieIncorrecto = (nieIncorrecto.validarDNI() == 1);

        // creamos un CIF correcto
        DNI cifCorrecto = new DNI(DocumentType.CIF, "W9696294I", null);
        Boolean esValidoCIF = (cifCorrecto.validarDNI() == 1);

        // creamos un CIF incorrecto
        DNI cifIncorrecto = new DNI(DocumentType.CIF, "W9696294A", null);
        Boolean esValidoCifIncorrecto = (cifIncorrecto.validarDNI() == 1);



        System.out.println( "DNI " + dniCorrecto.numDNI + " es: " + esValido.toString());
        System.out.println( "DNI " + dniIncorrecto01.numDNI + " es: " + esValido01.toString());
        System.out.println( "NIE " + nieCorrecto.numDNI + " es: " + esValidoNie.toString());
        System.out.println( "NIE " + nieIncorrecto.numDNI + " es: " + esValidoNieIncorrecto.toString());
        System.out.println( "CIF " + cifCorrecto.numDNI + " es: " + esValidoCIF.toString());
        System.out.println( "NIE " + cifIncorrecto.numDNI + " es: " + esValidoCifIncorrecto.toString());

    }

    private static void printBanner() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }
}