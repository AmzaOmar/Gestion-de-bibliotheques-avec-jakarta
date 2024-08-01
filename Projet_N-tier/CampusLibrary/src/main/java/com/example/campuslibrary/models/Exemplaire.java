package com.example.campuslibrary.models;

public class Exemplaire {
    private int numero;
    private int reference_livre;
    private String validation;

    public Exemplaire(){}
    public Exemplaire(int reference_livre,String validation) {

        this.reference_livre=reference_livre;
        this.validation=validation;
    }
    public Exemplaire(int numero,int reference_livre,String
                      validation) {
        this.numero = numero;
        this.reference_livre=reference_livre;
        this.validation=validation;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public int getNumero() {

        return numero;
    }



    public int getReference_livre() {
        return reference_livre;
    }

    public void setReference_livre(int reference_livre) {
        this.reference_livre = reference_livre;
    }
}
