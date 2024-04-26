package com.github.ankurpapneja4.bookkeeper.accountservice.domain;

public enum Schedule {

    CAPITAL("CAPITAL ACCOUNT"),
    BANK("BANK"),
    CASH("CASH"),
    EXP( "EXPENSES"),
    SALES("SALE"),
    PUR("PURCHASE"),
    EMPLOYEE("SALARY"),
    BUYER("SUNDRY CREDITORS"),
    SELLER("SUNDRY DEBTORS"),
    TDS("TDS");

    private String value;

    private Schedule(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
