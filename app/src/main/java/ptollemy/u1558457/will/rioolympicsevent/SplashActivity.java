package ptollemy.u1558457.will.rioolympicsevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements AnimationListener {

    ImageView splashImage;
    Animation animFadeIn;
    Animation animFadeOut;
    TextView rioOlympicsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImage = (ImageView)findViewById(R.id.rio_splash_image);
        rioOlympicsTxt = (TextView)findViewById(R.id.rioOlympics_text);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        animFadeOut.setAnimationListener(this);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    splashImage.setAnimation(animFadeIn);
                    sleep(6000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        timerThread.start();
    }

    @Override
    public void onAnimationEnd(Animation animation){
        if(animation == animFadeIn){
            splashImage.startAnimation(animFadeOut);
            rioOlympicsTxt.startAnimation(animFadeOut);
        }
        else if(animation == animFadeOut){
            Intent i = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
        else{
            //Do Nothing
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation){
        //Do something
    }

    @Override
    public void onAnimationStart(Animation animation){
        //Do something
    }

}
