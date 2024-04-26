package com.github.ankurpapneja4.bookkeeper.accountservice.domain;

public enum JournalEntryType {

    CASH( "CASH"),
    SALE("SALE"),
    PUR("PURCHASE");

    private String value;

    private JournalEntryType(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }

}
