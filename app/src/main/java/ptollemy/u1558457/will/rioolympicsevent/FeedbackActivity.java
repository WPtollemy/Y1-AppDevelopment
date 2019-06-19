package ptollemy.u1558457.will.rioolympicsevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements OnClickListener {

    private Button sendFeedbackBtn;
    private EditText feedbackEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendFeedbackBtn = (Button)findViewById(R.id.sendfeedback_button);
        sendFeedbackBtn.setOnClickListener(this);

        feedbackEdit = (EditText)findViewById(R.id.feedback_edittext);
    }

    public void onClick(View v){
        if (v.getId() == R.id.sendfeedback_button){
            Toast.makeText(FeedbackActivity.this, "Thank you for your feedback", Toast.LENGTH_SHORT).show();
            feedbackEdit.setText("");
        }
    }
}
