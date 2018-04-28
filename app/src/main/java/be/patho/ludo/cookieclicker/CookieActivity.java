package be.patho.ludo.cookieclicker;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CookieActivity extends AppCompatActivity {

    private ImageView cookie;
    private TextView points;
    private ImageView btnmulti;
    private TextView msgmulti;
    private TextView msgmulti2;
    private ImageView btnAutoClick;
    private TextView msgAutoClick;
    private TextView msgAutoClick2;
    private TextView clickMulti;
    private boolean isMsgActive = false;
    private boolean isMsgActive2 = false;
    private int timer = 2000;
    private boolean onePlay = false;
    private boolean onePlay2 = false;
    private boolean onePlay3 = false;
    private boolean onePlay4 = false;
    private boolean onePlay5 = false;
    private boolean isTimerActive = false;


    private int clicks = 30000 ;
    private int multiplicator = 1;

    private void checkPoint() {
        if(clicks >= (50 * multiplicator) && !isMsgActive) {

            scaleView(points,1,1.5f);

            msgmulti2.setText("1 clique compte pour " + (multiplicator + 1 ) + " clicks , Coût : " + (50 * multiplicator) /2 + " points");
            btnmulti.setVisibility(View.VISIBLE);
            msgmulti.setVisibility(View.VISIBLE);
            msgmulti2.setVisibility(View.VISIBLE);
            btnmulti.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgmulti.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgmulti2.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));

            isMsgActive = true;
        }
        else if (clicks >= 500  && !isMsgActive2 && !onePlay) {
            msgAutoClick2.setText("Auto-Click : 1 click /2s , côut : 500");
            btnAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick2.setVisibility(View.VISIBLE);
            btnAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick2.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));

            isMsgActive2 = true;
        }

        if (clicks >= 1000 && !isMsgActive2 && onePlay && !onePlay2) {
            msgAutoClick2.setText("1 Clique par senconde, Cout : 1000");
            btnAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick2.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            btnAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick2.setVisibility(View.VISIBLE);

            isMsgActive2 = true;
        }


        if (clicks >= 1500 && !isMsgActive2 && onePlay2 && !onePlay3) {
            msgAutoClick2.setText("1 Clique par demi-senconde, Cout : 1500");
            btnAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick2.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            btnAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick2.setVisibility(View.VISIBLE);

            isMsgActive2 = true;
        }

        if (clicks >= 2000 && !isMsgActive2 && onePlay3 && !onePlay4) {
            msgAutoClick2.setText("1 Clique par 0.2 seconde, Cout : 2000");
            btnAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick2.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            btnAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick2.setVisibility(View.VISIBLE);

            isMsgActive2 = true;
        }

        if (clicks >= 10000 && !isMsgActive2 && onePlay4 && !onePlay5) {
            msgAutoClick2.setText("1 Clique par 0.2 seconde, Cout : 10000");
            btnAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            msgAutoClick2.startAnimation(AnimationUtils.makeInAnimation(CookieActivity.this, true));
            btnAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick.setVisibility(View.VISIBLE);
            msgAutoClick2.setVisibility(View.VISIBLE);

            isMsgActive2 = true;
        }





        if(multiplicator >= 2) {
            clickMulti.setVisibility(View.VISIBLE);
            clickMulti.setText("Chaque clique est multiplié par  x " + multiplicator);
            clickMulti.startAnimation(AnimationUtils.loadAnimation(CookieActivity.this, R.anim.fadout));
        }

        cookie.startAnimation(AnimationUtils.loadAnimation(CookieActivity.this,R.anim.shake_animation));
    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(false); // Needed to keep the result of the animation
        anim.setDuration(175);
        v.startAnimation(anim);
    }

    private void multiClick(){
        if(pay(50 * multiplicator/2)){
            multiplicator += 1;

            points.setText("Points : " + clicks);
            isMsgActive = false;

            btnmulti.setVisibility(View.GONE);
            msgmulti.setVisibility(View.GONE);
            msgmulti2.setVisibility(View.GONE);
        } else {
            clickMulti.setText("Vous n'avez pas assez de points");
            btnmulti.setVisibility(View.GONE);
            msgmulti.setVisibility(View.GONE);
            msgmulti2.setVisibility(View.GONE);
            isMsgActive = false;
        }

    }

    private boolean pay(int prix) {
        if (clicks >= prix) {
            clicks -= prix;
            points.setText("Points : " + clicks);
            return true;
        }
        else {
            return false;
        }
    }

    private void autoClick() {
       new Handler().postDelayed(
            new Runnable() {
                @Override
                    public void run() {
                          clicks += multiplicator;
                          points.setText("Points : " + clicks);
                          checkPoint();
                          autoClick();
                    }
            }, timer);
    }

    private void outMsg() {
        btnAutoClick.setVisibility(View.GONE);
        msgAutoClick.setVisibility(View.GONE);
        msgAutoClick2.setVisibility(View.GONE);
        isMsgActive2 = false;
    }

    private void manageTimer () {
        if(!onePlay && pay(500)){
            onePlay = true;
            autoClick();
            outMsg();
        }else if (!onePlay2 && onePlay && pay(1000) ) {
            timer = 1000;
            onePlay2= true;
            outMsg();
        }else if (!onePlay3 && onePlay2 && pay(1500) ) {
            timer = 500;
            onePlay3= true;
            outMsg();
        }else if (!onePlay4 && onePlay3 && pay(2000) ) {
            timer = 200;
            onePlay4= true;
            outMsg();
        }else if (!onePlay5 && onePlay4 && pay(10000) ) {
            timer = 100;
            onePlay5= true;
            outMsg();
        }
        else {
            clickMulti.setText("Vous n'avez pas assez de points");
            outMsg();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

        View decorView = getWindow().getDecorView();
        // Full Screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        this.cookie = (ImageView) findViewById(R.id.cookie);
        this.points = (TextView) findViewById(R.id.points);
        this.btnmulti = (ImageView) findViewById(R.id.pointer);
        this.msgmulti =  (TextView) findViewById(R.id.msgmulti);
        this.msgmulti2 =  (TextView) findViewById(R.id.msgmulti2);
        this.btnAutoClick = (ImageView) findViewById(R.id.autoclick);
        this.msgAutoClick = (TextView) findViewById(R.id.msgautoclick);
        this.msgAutoClick2 = (TextView) findViewById(R.id.msgautoclick2);
        this.clickMulti = (TextView) findViewById(R.id.clickmulti);

        btnmulti.setVisibility(View.GONE);
        msgmulti.setVisibility(View.GONE);
        msgmulti2.setVisibility(View.GONE);
        btnAutoClick.setVisibility(View.GONE);
        msgAutoClick.setVisibility(View.GONE);
        msgAutoClick2.setVisibility(View.GONE);



        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiClick();
            }
        });

        msgmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiClick();
            }
        });

        msgmulti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiClick();
            }
        });

        btnAutoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageTimer();

            }
        });

        msgAutoClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                manageTimer();
            }
        });

        msgAutoClick2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                manageTimer();
            }
        });


        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks +=  multiplicator;
                checkPoint();
                points.setText("Points : " + clicks);

            }
        });
    }
}
