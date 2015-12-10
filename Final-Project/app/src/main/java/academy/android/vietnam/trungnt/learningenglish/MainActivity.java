package academy.android.vietnam.trungnt.learningeinglish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import academy.android.vietnam.trungnt.learningenglish.CustomOnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spn_jobs, spn_tutors, spn_courses;
    private Button btnRegister;
    private TextView txtTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnSpinnerItemSelection();
        addListenerOnButton();
    }

    public void addListenerOnSpinnerItemSelection() {
        spn_jobs = (Spinner) findViewById(R.id.spn_job);
        spn_jobs.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spn_tutors = (Spinner) findViewById(R.id.spn_tutor);
        spn_tutors.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spn_courses = (Spinner) findViewById(R.id.spn_course);
        spn_courses.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {

        spn_jobs = (Spinner) findViewById(R.id.spn_job);
        spn_tutors = (Spinner) findViewById(R.id.spn_tutor);
        spn_courses = (Spinner) findViewById(R.id.spn_course);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //txtTemp.setText(String.valueOf(spn_jobs.getSelectedItem()));
            }
        });
    }
}
