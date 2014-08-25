package com.example.popupwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
    private Button popupButton;
    PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        popupButton = (Button)findViewById(R.id.btn_popup);
        popupButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                mPopupWindow.showAtLocation(findViewById(R.id.btn_popup), Gravity.CENTER, 20, 20);
            }
        });
        
        View root = this.getLayoutInflater().inflate(R.layout.popup, null);

        root.findViewById(R.id.btn_close).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        mPopupWindow = new PopupWindow(root, 280, 360);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
