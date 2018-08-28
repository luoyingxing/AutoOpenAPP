package com.lyx.auto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * <p/>
 * Created by luoyingxing on 2018/8/28.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //标准的写法是需要判别Action的类型的
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent activity = new Intent(context, MainActivity.class);
            activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activity);
        }
    }
}