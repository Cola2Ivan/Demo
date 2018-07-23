package com.example.lenovo.demo.presenter;

import com.example.lenovo.demo.Font;

import java.util.List;

public interface IPresenter<IView> {
    List<Font> getFontList();
}
