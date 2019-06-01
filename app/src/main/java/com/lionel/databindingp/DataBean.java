package com.lionel.databindingp;

import android.arch.lifecycle.MutableLiveData;

/**
 * in pattern: dataBinding + liveData, the operated data(object) must be MutableLiveData class
 */
public class DataBean {
    private MutableLiveData<String> str1 = new MutableLiveData<>();
    private MutableLiveData<String> str2 = new MutableLiveData<>();

    public MutableLiveData<String> getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1.setValue(str1);
    }

    public MutableLiveData<String> getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2.setValue(str2);
    }
}
