package com.example.lenovo.demo.presenter;

import com.example.lenovo.demo.Font;
import com.example.lenovo.demo.model.IModel;
import com.example.lenovo.demo.model.Model;
import com.example.lenovo.demo.view.IView;

import java.util.List;

public class Presenter<T extends IView> implements IPresenter {
    private T mIview;
    private IModel model = new Model();

    @Override
    public List<Font> getFontList() {
        return model.getFont("");
    }
}
