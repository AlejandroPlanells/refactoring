package com.kreitek.refactor.bien.Documents;

public class Cif extends Document{

    public Cif(String documentNumber) {
        super(documentNumber);
    }

    @Override
    public boolean validate() {
        return false;
    }
}
