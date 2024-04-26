package com.github.ankurpapneja4.bookkeeper.accountservice.domain;

public enum Schedule {

    CAP("CAPITAL ACCOUNT"),
    BANK("BANK"),
    CSH("CASH"),
    EXP( "EXPENSES"),
    SALE("SALE"),
    PUR("PURCHASE"),
    CR("SUNDRY CREDITORS"),
    DR("SUNDRY DEBTORS");

    private String name;

    private Schedule(String scheduleName){
        this.name = name;
    }
    public String scheduleName(){
        return name;
    }
}
