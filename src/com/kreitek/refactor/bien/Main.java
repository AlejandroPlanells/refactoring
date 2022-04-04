package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.Documents.Cif;
import com.kreitek.refactor.bien.Documents.Dni;
import com.kreitek.refactor.bien.Documents.Document;
import com.kreitek.refactor.bien.Documents.Nie;

import java.util.ArrayList;
import java.util.List;

class  Main {
    public static void main(String args[]) {

        printBanner();
        List<Document> documents = createDocuments();
        printAllDocuments(documents);

    }

    private static void printAllDocuments(List<Document> documents) {
        for (Document document: documents) {
            System.out.printf("DNI %s es: %s %n",document.getDocumentNumber(),document.validate());
        }
    }

    private static List<Document> createDocuments() {
        Document dniTrue = new Dni("11111111H");
        Document dniFalse = new Dni("24324356A");
        Document nieTrue = new Nie("X0932707B");
        Document nieFalse = new Nie("Z2691139Z");
        Document cifTrue = new Cif("W9696294I");
        Document cifFalse = new Cif("W9696294A");

        List<Document> documents = new ArrayList<>();
        documents.add(dniTrue);
        documents.add(dniFalse);
        documents.add(nieTrue);
        documents.add(nieFalse);
        documents.add(cifTrue);
        documents.add(cifFalse);

        return documents;
    }

    private static void printBanner() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }
}