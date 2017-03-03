package it.enricod;


class User {
    String nome
    String cognome
    String email

    String displayName() {
        return nome + " " + cognome;
    }
}