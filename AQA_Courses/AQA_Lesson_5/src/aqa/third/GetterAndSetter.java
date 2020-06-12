package aqa.third;

public class GetterAndSetter {
    private int number = 10;
    private boolean bool;
    private char ch = 'a';
    private double dob = 44.44;
    private String str = "Hello Private";

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public double getDob() {
        return dob;
    }

    public void setDob(double dob) {
        this.dob = dob;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
