package com.webmanchuria.www.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    LinearLayout seekLayout11,seekLayout12,seekLayout21,seekLayout22,seekLayout23;
    int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekLayout11 = (LinearLayout) findViewById(R.id.L1L1);
        seekLayout12 = (LinearLayout) findViewById(R.id.L1L2);
        seekLayout21 = (LinearLayout) findViewById(R.id.L2L1);
        seekLayout22 = (LinearLayout) findViewById(R.id.L2L2);
        seekLayout23 = (LinearLayout) findViewById(R.id.L2L3);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        updateBackground();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                updateBackground();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    protected void updateBackground() {
        value = new Integer(seekBar.getProgress()).intValue();

        seekLayout12.setBackgroundColor(
                0xA352CC + value<<8
        );
        seekLayout21.setBackgroundColor(
                0xB2B2B2 + value<<8
        );
        seekLayout22.setBackgroundColor(
                0xFF7519 + value <<8
        );
        seekLayout23.setBackgroundColor(
               0xFF66CC + value <<8
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //return true;
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("This is my Android App developed for Coursera Assessment:");
            alertDialog.setMessage("Click Below to Learn More.");
            alertDialog.setCancelable(false);
            alertDialog.setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    return;
                }
            });
            alertDialog.setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent baseIntent = new Intent(Intent.ACTION_VIEW);
                    baseIntent.setData(Uri.parse("http://www.moma.org"));
                    startActivity(baseIntent);
                }
            });
            alertDialog.create();
            alertDialog.show();
            /*alertDialog.setPositiveButton(android.R.string.search_go,new DialogInterface().onClickListener(){
                public void onClick(DialogInterface dialog,int which)
                {

                }
            });
            alertDialog.setNegativeButton(android.R.string.no,new DialogInterface().onClickListener(){
                public void onClick(DialogInterface dialog,int which)
                {

                }
            });
            alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialog.show();*/
        }

        return super.onOptionsItemSelected(item);
    }
}