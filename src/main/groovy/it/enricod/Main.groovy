package it.enricod;

import it.enricod.*;

class Main {

    public static void main(String[] args) {
        def user = new User(nome: 'enrico', email: 'private@localhost', cognome: 'donelli')
        def userProxy= new UserProxy(fields: ['nome', 'cognome'], azioni:[]).wrap(user)  // Create proxy for user instance.
 
        assert 'enrico' == userProxy.nome
        try {
            userProxy.email
            assert false
        } catch (MissingPropertyException e) {
            assert 'Unknown property email' == e.message
        }
        assert 'enrico donelli' == userProxy.displayName()
         
        userProxy.cognome = "rossi";
        println userProxy.getAzioni();
        println userProxy.displayName();
    }
}