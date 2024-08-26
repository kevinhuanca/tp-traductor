package com.ulp.traductor;

public class Palabra {
    private String es;
    private String en;
    private int img;

    public Palabra(String es, String en, int img) {
        this.es = es;
        this.en = en;
        this.img = img;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
