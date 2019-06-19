package ptollemy.u1558457.will.rioolympicsevent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class BookingActivity extends AppCompatActivity implements OnClickListener{

    private Button bookingsLinkBtn;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        bookingsLinkBtn = (Button)findViewById(R.id.bookings_link_button);
        bookingsLinkBtn.setOnClickListener(this);

        radioGroup = (RadioGroup)findViewById(R.id.answer_group);
    }

    public void onClick(View v) {

        if(v.getId() == R.id.bookings_link_button){
            int radioId = radioGroup.getCheckedRadioButtonId();
            String websiteLink = null;
            switch(radioId){
                case 0: websiteLink = "http://www.rio2016.com/en/tourist-information/africa";
                        break;
                case 1: websiteLink = "http://www.rio2016.com/en/tourist-information/asia";
                        break;
                case 2: websiteLink = "http://www.rio2016.com/en/tourist-information/central-america";
                        break;
                case 3: websiteLink = "http://www.rio2016.com/en/tourist-information/europe";
                        break;
                case 4: websiteLink = "http://www.rio2016.com/en/tourist-information/north-america";
                        break;
                case 5: websiteLink = "http://www.rio2016.com/en/tourist-information/oceana";
                        break;
                case 6: websiteLink = "http://www.rio2016.com/en/tourist-information/south-america";
                        break;
            }
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/other-locations");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        }

/*        if (v.getId() == R.id.bookings_link_button && radioGroup.getCheckedRadioButtonId() == R.id.answer_one) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/africa");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else if (v.getId() == R.id.bookings_link_button && (radioGroup.getCheckedRadioButtonId() == R.id.answer_two)) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/asia");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else if (v.getId() == R.id.bookings_link_button && radioGroup.getCheckedRadioButtonId() == R.id.answer_three) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/central-america");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else if (v.getId() == R.id.bookings_link_button && radioGroup.getCheckedRadioButtonId() == R.id.answer_four) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/europe");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else if (v.getId() == R.id.bookings_link_button && radioGroup.getCheckedRadioButtonId() == R.id.answer_five) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/north-america");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else if (v.getId() == R.id.bookings_link_button && radioGroup.getCheckedRadioButtonId() == R.id.answer_six) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/oceana");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else if (v.getId() == R.id.bookings_link_button && radioGroup.getCheckedRadioButtonId() == R.id.answer_seven) {
            Uri uri = Uri.parse("http://www.rio2016.com/en/tourist-information/oceana");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        }
        */
    }
}
