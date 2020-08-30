package dev.oscaz.doublemap;

public class MutableInt {

    private int num;

    public MutableInt() {
        this(0);
    }

    public MutableInt(int num) {
        this.num = num;
    }

    public void add(int add) {
        this.num += add;
    }

    public void sub(int sub) {
        this.num -= sub;
    }

    public void div(int div) {
        this.num /= div;
    }

    public void mul(int mul) {
        this.num *= mul;
    }

    public void mod(int mod) {
        this.num %= mod;
    }

    public int get() {
        return this.num;
    }

}
