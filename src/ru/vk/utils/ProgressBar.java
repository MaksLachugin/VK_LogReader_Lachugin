package ru.vk.utils;

import java.io.IOException;

public class ProgressBar {
    long max;
    String anim = "|/-\\";

    public void setMax(long max) {
        this.max = max;
    }

    public long getMax() {
        return max;
    }

    public String getAnim() {
        return anim;
    }

    public ProgressBar(long max) {
        setMax(max);
    }

    public void now(long i) throws IOException {
        String data = "\r" + anim.charAt((int) (i % anim.length())) + " " + (int) (((float) i / getMax()) * 100) + "%";
        System.out.write(data.getBytes());
    }

    public void end() {
        System.out.println();
    }

}
