package com.example.listhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LongTouchList extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_touch_list);

        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.food, android.R.layout.simple_list_item_1);

        listview = (ListView) findViewById(R.id.list_longtouch) ;
        listview.setAdapter(adapter) ;

    }
    private View.OnLongClickListener pressHoldListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View pView) {
            // Do something when your hold starts here.
            isSpeakButtonLongPressed = true;
            mFrameLayout.setBackgroundResource(R.drawable.trash_can);
            yourCheckBox.setVisibility(VIEW.INVISIBLE);
            return true;
        }
    };

    private View.OnTouchListener pressTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View pView, MotionEvent pEvent) {
            pView.onTouchEvent(pEvent);
            // We're only interested in when the button is released.
            if (pEvent.getAction() == MotionEvent.ACTION_UP) {
                // We're only interested in anything if our speak button is currently pressed.
                if (isSpeakButtonLongPressed) {
                    // Do something when the button is released.
                    yourCheckBox.setVisibility(View.VISIBLE);
                    mFrameLayout.setBackground(null);
                    isSpeakButtonLongPressed = false;
                }
            }
            return false;
        }
    };

}