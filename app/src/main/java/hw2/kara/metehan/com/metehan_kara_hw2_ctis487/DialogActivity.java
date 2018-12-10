package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class DialogActivity extends Dialog implements View.OnClickListener{

    public Activity c;
    public Dialog d;
    public Button yes, no;
    Bundle b;
    TextView txtDia;



    public DialogActivity(Activity a, Bundle b) {
        super(a);
        this.b = b;
        // TODO Auto-generated constructor stub
        this.c = a;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        yes = (Button) findViewById(R.id.yesBtn);
        no = (Button) findViewById(R.id.noBtn);
        txtDia = findViewById(R.id.textView3);
        txtDia.setText("You are purchasing the course  " + b.getString("courseName") + "  now " + b.getString("customerName") + ". Do you approve?");

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yesBtn:
                c.finishAffinity();
                break;
            case R.id.noBtn:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
