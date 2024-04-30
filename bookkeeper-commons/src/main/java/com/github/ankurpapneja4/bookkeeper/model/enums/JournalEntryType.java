package com.github.ankurpapneja4.bookkeeper.model.enums;

public enum JournalEntryType {

    PURCHASE( "Purchase Invoice"),
    TAX("Tax Voucher");

    private String value;

    private JournalEntryType(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }

}
