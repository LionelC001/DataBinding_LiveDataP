package com.lionel.databindingp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private ViewDataBinding dataBinding;
    private DataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataBinding.setVariable(BR.dataViewModel, viewModel);
        dataBinding.setLifecycleOwner(this);


//        viewModel.getData().observe(this, new Observer<DataBean>() {
//            @Override
//            public void onChanged(@Nullable DataBean dataBean) {
//                Log.d("<>", new Gson().toJson(dataBean));
//            }
//        });

        viewModel.getStr1().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String str1) {
                Log.d("<>", str1);
            }
        });

        viewModel.getStr2().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String str2) {
                Log.d("<>", str2);
            }
        });

        viewModel.initData();
//        viewModel.changeData();
    }
}
