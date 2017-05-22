package tw.timlu.progress;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;

import tw.timlu.progressview.ProgressView;

/**
 * Created by juntinglu on 2017/5/20.
 */

public class MainActivity extends AppCompatActivity {

    ProgressView d;
    int w, h;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float max = 100;
        final float c = 40;
        d = (ProgressView) findViewById(R.id.draw_view);
        d.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                w = d.getMeasuredWidth();
                h = d.getMeasuredHeight();
                d.setWH((w / (max / c)), h);
                return true;
            }
        });

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                d.setSWH(20, h);

            }
        }, 5000);

    }

}
