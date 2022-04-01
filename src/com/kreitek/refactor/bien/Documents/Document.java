package com.kreitek.refactor.bien.Documents;

public abstract class Document {
    private String documentNumber;

    public Document(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public abstract boolean validate();
}
