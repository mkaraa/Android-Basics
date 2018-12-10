package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcomeTxt, doubletap;
    private ValueAnimator colorAnim;

    private static final int RED = 0xffFF0000;
    private static final int BLUE = 0xff0000FF;

    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doubletap = findViewById(R.id.doubleTapTxt);
        welcomeTxt = findViewById(R.id.textView);

        colorAnim = ObjectAnimator.ofInt(welcomeTxt, "textColor", RED, BLUE);
        colorAnim.setDuration(1000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent event) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            return true;
        }




    }
}
