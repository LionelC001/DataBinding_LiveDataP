package com.lionel.databindingp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

public class DataViewModel extends AndroidViewModel {
    private MutableLiveData<DataBean> data = new MutableLiveData<>();
    private MutableLiveData<String> str1 = new MutableLiveData<>();
    private MutableLiveData<String> str2 = new MutableLiveData<>();

    public DataViewModel(@NonNull Application application) {
        super(application);
    }

    public void initData() {
//        data.setValue(new DataBean());
//        data.getValue().setStr1("STR!");
//        data.getValue().setStr2("STR2!");
        str1.setValue("New1");
        str2.setValue("New2");
    }

//    public MutableLiveData<DataBean> getData() {
//        return data;
//    }

    public MutableLiveData<String> getStr1() {
        return str1;
    }

    public MutableLiveData<String> getStr2() {
        return str2;
    }


    public void changeData() {
        data.getValue().setStr1("NEW 1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("<>", "new THREAD");
                    Thread.sleep(5000);
                    data.getValue().setStr1("NEW 1-B");
                    data.postValue(data.getValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
