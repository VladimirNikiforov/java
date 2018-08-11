package org.stepic.java.asciiCharSequence;


import java.util.Arrays;

public class asciiCharSequence implements CharSequence {

    byte[] s;
    public asciiCharSequence(byte[] s) {
        this.s = s;
    }

    @Override
    public int length(){
        return s.length;
    }

    @Override
    public char charAt(int index){
        char s_indx = (char) s[index];
        return s_indx;
    }

    @Override
    public CharSequence subSequence(int start, int end){
        return new asciiCharSequence(Arrays.copyOfRange(s, start, end));
    };

    @Override
    public String toString() {
        return new String(s);
    }

}
