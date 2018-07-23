package com.example.lenovo.demo;

public class Font {
    public String font_name = null;

    public int default_scale = 0;

    public int dpi = 203;

    @Override
    public String toString() {
        return "Font{" +
                "font_name='" + font_name + '\'' +
                ", default_scale=" + default_scale +
                ", dpi=" + dpi +
                '}';
    }
}
