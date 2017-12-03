package com.stegander.dashboard;

public class Service {

    int expected;
    String name;
    int prd;
    int utb;
    int tst;
    int utv;

    public Service(int expected, String name, int prd, int utb, int tst, int utv) {
        this.expected = expected;
        this.name = name;
        this.prd = prd;
        this.utb = utb;
        this.tst = tst;
        this.utv = utv;
    }

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrd() {
        return prd;
    }

    public void setPrd(int prd) {
        this.prd = prd;
    }

    public int getUtb() {
        return utb;
    }

    public void setUtb(int utb) {
        this.utb = utb;
    }

    public int getTst() {
        return tst;
    }

    public void setTst(int tst) {
        this.tst = tst;
    }

    public int getUtv() {
        return utv;
    }

    public void setUtv(int utv) {
        this.utv = utv;
    }

    public String getStatusPrd(){
        return getStatus(prd);
    }
    public String getStatusUtb(){
        return getStatus(utb);
    }
    public String getStatusTst(){
        return getStatus(tst);
    }
    public String getStatusUtv(){
        return getStatus(utv);
    }

    private String getStatus(int no){
        if(no == 0){
            return "red";
        } else if(no < expected){
            return "yellow";
        } else {
            return "green";
        }

    }
}
