package com.example.lenovo.demo;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


//https://blog.csdn.net/yanxiaosa/article/details/70859927 使用文件内容，IO耗时问题
//提示框
public class FontUtil {

    private static final String  TAG = FontUtil.class.getName();
    private Context ctx = null;

    public static final Map<String,List<Font>> fontList = new HashMap<>();

    public FontUtil(Context context){
        ctx = context;
    }

    public void initFont(){

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {  //这里进行数据读取
                StringBuilder stringBuilder = new StringBuilder();
                InputStream inputStream = ctx.getResources().getAssets().open("printerConf.json");
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String jsonLine;
                while ((jsonLine = reader.readLine()) != null) {
                    stringBuilder.append(jsonLine);
                }
                reader.close();
                isr.close();
                inputStream.close();
                emitter.onNext(stringBuilder.toString());
                emitter.onComplete();
            }
        }).map(new Function<String, Map<String,List<Font>>>() { //map进行数据转换
            @Override
            public Map<String,List<Font>> apply(String s) throws Exception {
                Log.e(TAG, "read String"+s);
                Map<String,List<Font>> fontList = new HashMap<>();//这里做Gson解析 将String转换为对应的字体类
                Type type = new TypeToken<Map<String,List<Font>>>(){}.getType();
                fontList = new Gson().fromJson(s,type);
                return fontList;
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Observer<Map<String, List<Font>>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe");
            }

            @Override
            public void onNext(Map<String, List<Font>> stringListMap) {
                Log.e(TAG, "onNext" + stringListMap);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e(TAG, "onError" + e);
            }

            @Override
            public void onComplete(){
                Log.e(TAG, "onComplete");
            }
        });

    }


}
