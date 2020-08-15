package com.example.cap_carassistpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.cap_carassistpro.MainActivity.osImages1;
import static com.example.cap_carassistpro.MainActivity.osNameList1;

public class CustomAdapter1 extends BaseAdapter {


    String [] result1;
    Context context1;
    int [] imageId1;
    private static LayoutInflater inflater=null;
    private AdapterView gridview;

    public CustomAdapter1(MainActivity mainActivity, String[] osNameList, int[] osImages) {
        // TODO Auto-generated constructor stub
        result1=osNameList1;
        context1=mainActivity;
        imageId1=osImages1;
        inflater = (LayoutInflater)context1.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result1.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView os_text1;
        ImageView os_img1;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView1;

        rowView1 = inflater.inflate(R.layout.sample_gridlayout, null);
        holder.os_text1 =(TextView) rowView1.findViewById(R.id.os_texts);
        holder.os_img1 =(ImageView) rowView1.findViewById(R.id.os_images);

        holder.os_text1.setText(result1[position]);
        holder.os_img1.setImageResource(imageId1[position]);

        /*
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();
                switch (position)
                {
                    case 0://Toast.makeText(context, "You Clicked 1 -"+result[position], Toast.LENGTH_SHORT).show();

                    case 1:Toast.makeText(context, "You Clicked 1 -"+result[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;

                }

            }
        });


      */



        return rowView1;


    }



}
