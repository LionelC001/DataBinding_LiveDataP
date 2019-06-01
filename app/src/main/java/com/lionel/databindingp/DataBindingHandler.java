package com.lionel.databindingp;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.TextView;

public class DataBindingHandler {

    @BindingAdapter(value = {"msg1", "msg2"}, requireAll = false)
    public static void formatMsg(TextView view, String str1, String str2) {
        Log.d("<>", "formatMsg");
        view.setText(str1 + " space " + str2);
    }
}
