package com.example.homework02_program1;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Name: David Sargent
//Date: 10-21-2026
//Desc: com.example.homework02_program1.ColorAdapter Class, handles the data-transfer, color assembling, text luminance
public class ColorAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listofColors;


    //Gather our O-C, three ints,
    public ColorAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listofColors = ls;
    }
    @Override
    public int getCount()
    {
        return listofColors.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listofColors.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.color_cell, null);
        }
        // Find the GUI elements within the color_cell.xml
        TextView colorText = convertView.findViewById(R.id.tv_cell_rgb);
        TextView hexText = convertView.findViewById(R.id.tv_cell_hex);

        //Gather data from list of colors
        ColorInfo color = listofColors.get(position);
        String colorString = "Red: " + color.getRedNum() + "; Green: " + color.getGreenNum() + "; Blue: " + color.getBlueNum() + ";";
        String hextString = color.getHexCode(); // Empty for now <- Format?

        colorText.setText(colorString);
        hexText.setText(hextString);

        return convertView;
    }
}
