package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView langTxt, custNameTxt, paymentTxt;
    ImageView img;
    Button orderBtn;
    Bundle b;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        paymentTxt = findViewById(R.id.paymentTxt);
        langTxt = findViewById(R.id.langNameTxt);
        custNameTxt = findViewById(R.id.customerNameTxt);
        img = findViewById(R.id.imageView3);
        orderBtn = findViewById(R.id.button);

        intent = getIntent();
        b = intent.getExtras();

        langTxt.setText(b.getString("courseName"));
        if(b.getString("courseName").equals("PHP")){
            paymentTxt.setText("250 TL");
        }
        else if(b.getString("courseName").equals("JAVA")){
            paymentTxt.setText("310 TL");
        }
        else if(b.getString("courseName").equals("PHYTON")){
            paymentTxt.setText("300 TL");
        }
        else if(b.getString("courseName").equals("C#")){
            paymentTxt.setText("270 TL");
        }
        b.putString("",paymentTxt.getText().toString());
        
        custNameTxt.setText(b.getString("customerName"));
        img.setImageResource(b.getInt("image"));

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ThirdActivity.this, FourthActivity.class);
                intent2.putExtras(b);
                startActivity(intent2);
            }
        });
    }
}
