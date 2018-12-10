package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    private ValueAnimator colorAnim;
    TextView whichLngTxt;
    Spinner spinner;
    EditText name;


    ArrayList<Courses> spinnerValues = new ArrayList<Courses>();

    private static final int RED = 0xffFF0000;
    private static final int BLUE = 0xff0000FF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner = findViewById(R.id.spinner);
        name = findViewById(R.id.editText);
        prepareData();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        whichLngTxt = findViewById(R.id.whichLangTxt);
        colorAnim = ObjectAnimator.ofInt(whichLngTxt, "textColor", RED, BLUE);
        colorAnim.setDuration(1000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

        MySpinnerAdapter spinnerAdapter = new MySpinnerAdapter(this, R.layout.spinner_layout,  spinnerValues);
        spinner.setAdapter(spinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(name.getText().toString().equals("") || name.getText().toString() == null){
                    Toast.makeText(SecondActivity.this, "Please Enter a Name To Continue !", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("image", spinnerValues.get(position).getImgID());
                    b.putString("courseName", spinnerValues.get(position).getCourseName());
                    b.putString("customerName", name.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
    });
}
    public void prepareData(){

        Collections.addAll(spinnerValues, new Courses("PHP",R.drawable.php), new Courses("JAVA",R.drawable.java)
        ,new Courses("PHYTON",R.drawable.phyton),
        new Courses("C#",R.drawable.csharp));

    }
}
