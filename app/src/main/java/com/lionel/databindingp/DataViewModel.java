package com.lionel.databindingp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class DataViewModel extends AndroidViewModel {
    private DataBean data = new DataBean();

    public DataViewModel(@NonNull Application application) {
        super(application);
    }

    public void initData() {
        data.setStr1("STR001!");
        data.setStr2("STR002!");
    }

    public DataBean getData() {
        return data;
    }

    public void changeData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    data.getStr1().postValue("STR001 after 5 sec");   // in background thread, should call postValue(), not setValue()
                    data.getStr2().postValue("STR002 after 5 sec");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
