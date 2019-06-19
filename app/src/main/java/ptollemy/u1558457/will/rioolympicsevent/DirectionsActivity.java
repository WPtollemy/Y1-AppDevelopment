package ptollemy.u1558457.will.rioolympicsevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DirectionsActivity extends AppCompatActivity implements OnClickListener {

    private Button gotoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        gotoBtn = (Button)findViewById(R.id.goto_button);
        gotoBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId() == R.id.goto_button){
            Intent i = new Intent(this, GotoActivity.class);
            startActivity(i);
        }else{
            //Do nothing
        }
    }
}
