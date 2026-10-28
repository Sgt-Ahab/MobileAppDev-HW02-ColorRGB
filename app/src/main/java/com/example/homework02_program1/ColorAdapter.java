//Name: David Sargent
//Date: 10-21-2026
//Desc: com.example.homework02_program1.ColorAdapter Class, handles the data-transfer, color assembling, text luminance
package com.example.homework02_program1;

import static android.graphics.Color.rgb;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        //Since we reuse data, make vars colorNumber rN -> redNumber saves keystrokes
        int rN, gN, bN;
        rN = color.getRedNum();
        gN = color.getGreenNum();
        bN = color.getBlueNum();
        String colorString = "Red: " + rN + "; Green: " + gN + "; Blue: " + bN + ";";
        String hexString = "#" + color.getHexCode(); // Kept dirty in object, add Hash code here

        colorText.setText(colorString);
        hexText.setText(hexString);
        //Set the object's background
        convertView.setBackgroundColor(rgb(rN, gN, bN));

        //Luminance check
        double luminance = (rN * 0.2126) + (0.7152 * gN) + (0.0722 * bN);
        if (luminance < 128)
        {
            colorText.setTextColor(Color.WHITE);
            hexText.setTextColor(Color.WHITE);
        }
        else
        {
            colorText.setTextColor(Color.BLACK);
            hexText.setTextColor(Color.BLACK);
        }

        return convertView;
    }
}
