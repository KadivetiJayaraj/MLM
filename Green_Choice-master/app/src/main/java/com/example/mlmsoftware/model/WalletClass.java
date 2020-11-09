package com.example.mlmsoftware.model;

public class WalletClass {

    public String date;
    public String particular;
    public double credited,debited;

    public WalletClass(String date, String particular, double credited, double debited) {
        this.date = date;
        this.particular = particular;
        this.credited = credited;
        this.debited = debited;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public double getCredited() {
        return credited;
    }

    public void setCredited(double credited) {
        this.credited = credited;
    }

    public double getDebited() {
        return debited;
    }

    public void setDebited(double debited) {
        this.debited = debited;
    }
}
