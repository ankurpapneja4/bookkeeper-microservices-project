package com.github.ankurpapneja4.bookkeeper.accountservice.domain;

public enum JournalEntryType {

    PUR( "Purchase Invoice"),
    Tax("Tax Voucher");

    private String value;

    private JournalEntryType(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }

}
