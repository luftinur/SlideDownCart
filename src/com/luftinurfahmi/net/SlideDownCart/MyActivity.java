package com.luftinurfahmi.net.SlideDownCart;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

public class MyActivity extends Activity {
    private Menu menu;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // get the menu item id to change the title button while the layout is visible and gone
        MenuItem mnTitle = menu.findItem(R.id.cart);
        mnTitle.setTitle("Show Cart");

        switch (item.getItemId()){
            case R.id.cart:

                LinearLayout cartLayout = (LinearLayout) findViewById(R.id.cart_container);
                LinearLayout bottom = (LinearLayout) findViewById(R.id.other_container);

                // check visibility
                // if visibility gone then showing up.
                if(cartLayout.getVisibility() == View.GONE)
                {

                    cartLayout.setVisibility(View.VISIBLE);
                    Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.anim_slide_down);
                    cartLayout.startAnimation(slideDown);
                    bottom.startAnimation(slideDown);
                    mnTitle.setTitle("Close Cart");

                }else{


                    Animation slideUp = AnimationUtils.loadAnimation(this,R.anim.anim_slide_up);
                    cartLayout.startAnimation(slideUp);

                    // pull bottom layout corresponding with cartlayout height with TranslateAnimation class.
                    TranslateAnimation ta = new TranslateAnimation(0,0,cartLayout.getHeight(),0);
                    ta.setDuration(600);
                    bottom.startAnimation(ta);
                    cartLayout.setVisibility(View.GONE);


                }


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
