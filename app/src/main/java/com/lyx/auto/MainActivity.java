package com.lyx.auto;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SlideView<String> mSlideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mSlideView = findViewById(R.id.sv_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mSlideView.init(getSlideList());
    }

    private List<String> getSlideList() {
        List<String> list = new ArrayList<>();

//        list.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1927821551,3520994304&fm=26&gp=0.jpg");
//        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1204267144,1810294424&fm=26&gp=0.jpg");
//        list.add("http://img2.imgtn.bdimg.com/it/u=292814720,3759197718&fm=26&gp=0.jpg");
//        list.add("http://e.hiphotos.baidu.com/zhidao/pic/item/a8773912b31bb0515407da93347adab44aede06e.jpg");


        String sdState = Environment.getExternalStorageState();
        if (!sdState.equals(Environment.MEDIA_MOUNTED)) {
            return list;
        }

        String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aslide/";
        Log.e("======  dir:  ", dir);

        File file = new File(dir);


        File[] files = file.listFiles();

        if (files == null) {
            return null;
        }

        for (File f : files) {
            Log.i("----", "文件：" + f.getName());
            list.add("file://" + dir + f.getName());
        }


        return list;
    }
}
