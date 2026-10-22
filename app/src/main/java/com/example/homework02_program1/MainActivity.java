//Name: David Sargent
//Date: 10-21-2026
//Desc: Main Activity, runs the background color shift, text color shift, and saving the data
//      To the color_cell.xml in the listView for view and reload
package com.example.homework02_program1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //Access GUI elements[Grouped By Type]
    TextView tv_j_redView;
    TextView tv_j_blueView;
    TextView tv_j_greenView;
    TextView tv_j_hexView;
    SeekBar sb_j_redBar;
    SeekBar sb_j_blueBar;
    SeekBar sb_j_greenBar;
    Button btn_j_saveColor;
    ListView lv_j_colorList;
    ColorAdapter colorAdapter;
    private ArrayList<com.example.homework02_program1.ColorInfo> listofColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_vert_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Establish the loop handoff, bundle from com.example.homework02_program1.ColorInfo gets constructed
        //By adapter to populate on the listview
        //Background color must be used, and luminance check for text


        //Wire J -> XML
        lv_j_colorList = findViewById(R.id.lv_main_colors);
        tv_j_redView = findViewById(R.id.tv_main_red);
        tv_j_blueView = findViewById(R.id.tv_main_blue);
        tv_j_greenView = findViewById(R.id.tv_main_green);
        tv_j_hexView = findViewById(R.id.tv_main_hex);
        sb_j_redBar = findViewById(R.id.sb_main_red);
        sb_j_blueBar = findViewById(R.id.sb_main_blue);
        sb_j_greenBar = findViewById(R.id.sb_main_green);
        btn_j_saveColor = findViewById(R.id.btn_main_save);
        listofColors = new ArrayList<>();
        //================================================
        //Function Calls
        addColorButtonClickEvent();
        addDummyDataToArrayList();
        DisplayAllColorData();
        //Adapter init + nesting
        colorAdapter = new ColorAdapter(this, listofColors);
        lv_j_colorList.setAdapter(colorAdapter);
    }
    private void addColorButtonClickEvent()
    {
        //Listen for button on click, gather the red + green + blue -> pass to Adapter
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void addDummyDataToArrayList()
    {
        //Create colors to populate the list
        //Fill Colorinfo;
        //Add to array list
        ColorInfo c = new ColorInfo(134, 233, 25);
        listofColors.add(c);
        c = new ColorInfo(25, 187, 209);
        listofColors.add(c);
        c = new ColorInfo(249, 249, 249);
        listofColors.add(c);
    }
    private void DisplayAllColorData()
    {
        for(int i = 0; i < listofColors.size(); i++)
        {
            String message = "Color Info: R-" + listofColors.get(i).getRedNum() + "; G-" + listofColors.get(i).getGreenNum() + "; B-" + listofColors.get(i).getBlueNum();
            Log.d("Color-Display",message);
        }
    }

}