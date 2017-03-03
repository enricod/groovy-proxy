package it.enricod;

class UserProxy extends groovy.util.Proxy {
    List fields
    List azioni
    
    // Override getProperty for custom behavior by the proxy.
    Object getProperty(String propertyName) {
        if (propertyName in fields) {
            getAdaptee().getProperty(propertyName)
        } else {
            throw new MissingPropertyException("Unknown property $propertyName")
        }
    }

    void setProperty(String propertyName, Object value) {
        azioni.add("imposto ${propertyName} = ${value}");
        getAdaptee().setProperty(propertyName, value);
    }
}