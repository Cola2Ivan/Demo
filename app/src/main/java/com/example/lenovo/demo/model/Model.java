package com.example.lenovo.demo.model;

import com.example.lenovo.demo.Font;
import com.example.lenovo.demo.FontUtil;

import java.util.List;

public class Model implements IModel {
    @Override
    public List<Font> getFont(String devName) {
        return FontUtil.fontList.get(devName);
    }
}
