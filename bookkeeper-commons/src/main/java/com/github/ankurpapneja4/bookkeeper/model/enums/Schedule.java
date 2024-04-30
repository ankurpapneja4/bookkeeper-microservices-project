package com.github.ankurpapneja4.bookkeeper.model.enums;

public enum Schedule {

    SALES("PRODUCT SALE"),

    PURCHASE("PRODUCT PURCHASE"),

    SELLER("SUNDRY CREDITORS"),

    TAXES("TAX ACCOUNTS");

    private String value;

    private Schedule(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
