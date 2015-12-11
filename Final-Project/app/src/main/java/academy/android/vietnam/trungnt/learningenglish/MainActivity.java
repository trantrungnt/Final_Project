package academy.android.vietnam.trungnt.learningeinglish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import academy.android.vietnam.trungnt.learningenglish.CustomOnItemSelectedListener;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spn_jobs, spn_tutors, spn_courses;
    private Button btnRegister;
    private EditText edit_txtName, edit_txtPhone, edit_txtEmail, edit_txtHour, edit_txtTutionFee;
    private RadioButton rdSex, rdPay;
    private TextView tvPhone, tvEmail;

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

        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        edit_txtName = (EditText) findViewById(R.id.edit_txtName);
        Editable nameEditable = edit_txtName.getText();
        final String name = nameEditable.toString();

        edit_txtPhone = (EditText) findViewById(R.id.edit_txtPhone);
        Editable phoneEditable = edit_txtPhone.getText();
        final String phone = phoneEditable.toString();

        edit_txtEmail = (EditText) findViewById(R.id.edit_txtEmail);
        Editable emailEditable = edit_txtEmail.getText();
        final String email = emailEditable.toString();

        edit_txtHour = (EditText) findViewById(R.id.edit_txtHour);
        Editable hourEditable = edit_txtHour.getText();
        final String hour = hourEditable.toString();

        edit_txtTutionFee = (EditText) findViewById(R.id.edit_txtTutionFee);
        Editable tution_feeEditable = edit_txtTutionFee.getText();
        final String tution_fee = tution_feeEditable.toString();

        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (edit_txtName.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,
                           edit_txtName.getHint()  + ": ?",
                            Toast.LENGTH_SHORT).show();
                }

                if (edit_txtPhone.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,
                            tvPhone.getText() + ": ?",
                            Toast.LENGTH_SHORT).show();
                }

                if (edit_txtEmail.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,
                            tvEmail.getText() + ": ?",
                            Toast.LENGTH_SHORT).show();
                }

                if (edit_txtHour.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,
                            edit_txtHour.getHint()  + ": ?",
                            Toast.LENGTH_SHORT).show();
                }

                if (edit_txtTutionFee.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,
                            edit_txtTutionFee.getHint()  + ": ?",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
