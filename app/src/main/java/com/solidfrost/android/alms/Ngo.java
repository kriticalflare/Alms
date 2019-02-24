package com.solidfrost.android.alms;

public class Ngo {

    String ngoId;
    String ngoName;
    String ngoArea;

    public Ngo(){

    }

    public Ngo(String ngoId, String ngoName, String ngoArea) {
        this.ngoId = ngoId;
        this.ngoName = ngoName;
        this.ngoArea = ngoArea;
    }

    public String getNgoId() {
        return ngoId;
    }

    public String getNgoName() {
        return ngoName;
    }

    public String getNgoArea() {
        return ngoArea;
    }
}
