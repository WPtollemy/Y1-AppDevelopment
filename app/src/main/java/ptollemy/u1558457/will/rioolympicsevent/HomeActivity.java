package ptollemy.u1558457.will.rioolympicsevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements OnClickListener{

    Button detailsBtn;
    Button directionsBtn;
    Button bookingBtn;
    Button feedbackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        detailsBtn = (Button)findViewById(R.id.details_button);
        detailsBtn.setOnClickListener(this);
        directionsBtn = (Button)findViewById(R.id.directions_button);
        directionsBtn.setOnClickListener(this);
        bookingBtn = (Button)findViewById(R.id.bookings_button);
        bookingBtn.setOnClickListener(this);
        feedbackBtn = (Button)findViewById(R.id.feedback_button);
        feedbackBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v.getId() == R.id.details_button){
            Intent i = new Intent(this, DetailsActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.directions_button){
            Intent i = new Intent(this, DirectionsActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.bookings_button) {
            Intent i = new Intent(this, BookingActivity.class);
            startActivity(i);
        }else if (v.getId() == R.id.feedback_button){
            Intent i = new Intent(this, FeedbackActivity.class);
            startActivity(i);
        }else{
            //Do nothing
        }
    }
}
