package com.lionel.databindingp;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        viewModel.initData();
        viewModel.changeData();
    }
}
