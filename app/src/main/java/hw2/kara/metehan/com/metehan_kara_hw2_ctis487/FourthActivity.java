package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    Bundle b;
    Intent intent;
    TextView n;
    Button okeyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        n = findViewById(R.id.namett);
        okeyBtn = findViewById(R.id.okeyBtn);

        intent = getIntent();
        b= intent.getExtras();

        n.setText(b.getString("customerName"));

        okeyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity newACt =new DialogActivity(FourthActivity.this, b);
                newACt.show();
            }
        });
    }
}
