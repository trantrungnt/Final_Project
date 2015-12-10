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
    TextView selection;

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
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {

        spn_jobs = (Spinner) findViewById(R.id.spn_job);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "OnClickListener : " +
                                "\nSpinner job : "+ String.valueOf(spn_jobs.getSelectedItem()),

                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
