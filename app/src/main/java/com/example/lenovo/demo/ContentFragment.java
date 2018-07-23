package com.example.lenovo.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {

    private RecyclerView mRecyleView = null;
    private RecycleAdapter mAdapter = null;
    private static List<String> imageUrlList = new ArrayList<>();

    //for test
    static {
        imageUrlList.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4269080372,2540720570&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=84653295,2801014711&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3336320333,4115709500&fm=27&gp=0.jpg");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.content_scrolling,container,false);
        mRecyleView = view.findViewById(R.id.recyler_list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyleView.setLayoutManager(manager);
        mRecyleView.setNestedScrollingEnabled(false);
        mAdapter = new RecycleAdapter(getContext(), imageUrlList);
        mRecyleView.setAdapter( mAdapter);
        return view;
    }
}
