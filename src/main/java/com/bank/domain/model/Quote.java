package com.bank.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class Quote.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    /** The type. */
    private String type;
    
    /** The value. */
    private Value value;

    /**
     * Instantiates a new quote.
     */
    public Quote() {
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    
    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
