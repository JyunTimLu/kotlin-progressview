package tw.timlu.progress;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ToggleButton;

import tw.timlu.progressview.ProgressView;
import tw.timlu.progressview.RoundProgressView;

/**
 * Created by juntinglu on 2017/5/20.
 */

public class MainActivity extends AppCompatActivity {

    RoundProgressView d;
    int w, h;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float max = 100;
        final float c = 40;
        d = (RoundProgressView) findViewById(R.id.draw_view);
        d.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                w = d.getMeasuredWidth();
                h = d.getMeasuredHeight();
                d.setWH((w / (max / c)), h);
                d.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                d.setSWH(1000, h);

            }
        }, 5000);


    }

}
