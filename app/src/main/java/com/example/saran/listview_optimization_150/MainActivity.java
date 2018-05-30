package com.example.saran.listview_optimization_150;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] titlesection;
    String[] titledescription;
    int[] images = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,R.drawable.image_5,R.drawable.image_5,R.drawable.image_6,
            R.drawable.image_7,R.drawable.image_8,R.drawable.image_9,R.drawable.image_6};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listview);

        Resources res=getResources();
        titlesection=res.getStringArray(R.array.title);
        titledescription=res.getStringArray(R.array.titledes);

        CustomAdapter adapter= new CustomAdapter(this,titlesection,titledescription,images);
        lv.setAdapter(adapter);

    }
}
class CustomAdapter extends ArrayAdapter<String>
{

    Context context;
    String [] title;
    String [] desc;
    int [] imagesets;

    CustomAdapter(Context c,String [] title_a,String[] desc_a,int [] imagesets_a)
    {
        super(c,R.layout.single_row,R.id.textView,title_a);
        this.context=c;
        this.title=title_a;
        this.desc=desc_a;
        this.imagesets=imagesets_a;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View row =convertView;
        if (row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
        }
        ImageView myimage = (ImageView) row.findViewById(R.id.imageView);
        TextView myTitle = (TextView) row.findViewById(R.id.textView);
        TextView myDescription = (TextView) row.findViewById(R.id.textView2);

        myimage.setImageResource(imagesets[position]);
        myTitle.setText(title[position]);
        myDescription.setText(desc[position]);

        return row;
    }
}

