package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MySpinnerAdapter  extends ArrayAdapter<String> {
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflator;
    private ArrayList<Courses>  spinnerItemValues;

    private boolean flag=false;

    public MySpinnerAdapter(@NonNull Context context, int resource, @NonNull List values) {
        super(context, resource, values); //Do not forget to call super class constructor. By the help of it, now adapter know that howmany times getView method will be called.
        this.context = context;
        this.layoutResourceId = resource;
        spinnerItemValues = (ArrayList<Courses>) values;
    }

    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    public View getCustomView(int position,  View convertView,  ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null){
            inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflator.inflate(layoutResourceId,parent,false);
        }

        ConstraintLayout itemLayout = rowView.findViewById(R.id.itemLayout);
        TextView tv_main = rowView.findViewById(R.id.tv_main);
        ImageView leftPic = rowView.findViewById(R.id.left_pic);

        if(flag)
            itemLayout.setBackgroundColor(Color.MAGENTA);
        else
            itemLayout.setBackgroundColor(Color.BLUE);

        Courses item =spinnerItemValues.get(position);
        tv_main.setText(((Courses) item).getCourseName());
        leftPic.setImageResource(item.getImgID());

        return rowView;
    }

}
