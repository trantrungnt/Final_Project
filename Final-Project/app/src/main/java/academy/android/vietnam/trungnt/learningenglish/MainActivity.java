package academy.android.vietnam.trungnt.learningeinglish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Spinner spn_jobs, spn_tutors, spn_courses;
    private Button btnRegister;
    private EditText edit_txtName, edit_txtPhone, edit_txtEmail, edit_txtHour, edit_txtTutionFee;
    private RadioButton rdMale, rdFemale, rdYes, rdNo;
    private TextView tvPhone, tvEmail, tvSex, tvStatusPay;

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
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                spn_jobs = (Spinner) findViewById(R.id.spn_job);
                spn_tutors = (Spinner) findViewById(R.id.spn_tutor);
                spn_courses = (Spinner) findViewById(R.id.spn_course);

                tvPhone = (TextView) findViewById(R.id.tvPhone);
                tvEmail = (TextView) findViewById(R.id.tvEmail);
                tvSex = (TextView) findViewById(R.id.tvSex);
                tvStatusPay = (TextView) findViewById(R.id.tvStatusPay);

                rdMale = (RadioButton) findViewById(R.id.male);
                rdFemale = (RadioButton) findViewById(R.id.female);
                rdYes = (RadioButton) findViewById(R.id.yes);
                rdNo = (RadioButton) findViewById(R.id.no);

                edit_txtName = (EditText) findViewById(R.id.edit_txtName);
                Editable nameEditable = edit_txtName.getText();
                String name = nameEditable.toString();

                edit_txtPhone = (EditText) findViewById(R.id.edit_txtPhone);
                Editable phoneEditable = edit_txtPhone.getText();
                String phone = phoneEditable.toString();

                edit_txtEmail = (EditText) findViewById(R.id.edit_txtEmail);
                Editable emailEditable = edit_txtEmail.getText();
                String email = emailEditable.toString();

                edit_txtHour = (EditText) findViewById(R.id.edit_txtHour);
                Editable hourEditable = edit_txtHour.getText();
                String hour = hourEditable.toString();

                edit_txtTutionFee = (EditText) findViewById(R.id.edit_txtTutionFee);
                Editable tution_feeEditable = edit_txtTutionFee.getText();
                String tution_fee = tution_feeEditable.toString();

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

                if(rdMale.isChecked()==false && rdFemale.isChecked()==false)
                {
                    Toast.makeText(MainActivity.this,
                            tvSex.getHint()  + ": ?",
                            Toast.LENGTH_SHORT).show();
                }

                if (rdYes.isChecked() == false && rdNo.isChecked() == false)
                {
                    Toast.makeText(MainActivity.this,
                            tvStatusPay.getHint()  + ": ?",
                            Toast.LENGTH_SHORT).show();
                }


                if(  (
                        edit_txtName.getText().length() != 0 &&
                        edit_txtPhone.getText().length() != 0 &&
                        edit_txtEmail.getText().length() != 0 &&
                        edit_txtHour.getText().length() != 0 &&
                        edit_txtTutionFee.getText().length() !=0
                     )
                   )
                {
                    /*Toast.makeText(MainActivity.this,
                        String.valueOf(spn_tutors.getSelectedItem())  + ": ?",
                                                    Toast.LENGTH_SHORT).show();*/

                    String message = createInformationMail(name,
                            String.valueOf(spn_jobs.getSelectedItem()),
                            rdMale.isChecked(),
                            rdFemale.isChecked(),
                            phone,
                            email,
                            hour,
                            tution_fee,
                            String.valueOf(spn_tutors.getSelectedItem()),
                            String.valueOf(spn_courses.getSelectedItem()),
                            rdYes.isChecked(),
                            rdNo.isChecked());

                    //String message = name;
                    // Use an intent to launch an email app.
                    // Send the order summary in the email body.
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:antoree@gmail.com")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT,
                            getString(R.string.order_summary_email_subject));
                    intent.putExtra(Intent.EXTRA_TEXT, message);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private String createInformationMail(String name,
                                         String job,
                                         boolean male,
                                         boolean female,
                                         String phone,
                                         String email,
                                         String hour,
                                         String tution_fee,
                                         String tutor,
                                         String course,
                                         boolean yes,
                                         boolean no
                                         )
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.label_name) + " " + name);
        builder.append("\n" + getString(R.string.label_job) + " " + job);

        if(male==true && female==false)
            builder.append("\n" + getString(R.string.label_sex) + " " + getString(R.string.label_male));
        if(male==false && female==true)
            builder.append("\n" + getString(R.string.label_sex) + " " + getString(R.string.label_female));

        builder.append("\n" + getString(R.string.label_phone) + " " + phone);
        builder.append("\n" + getString(R.string.label_email) + " " + email);
        builder.append("\n" + getString(R.string.label_hour) + " " + hour);
        builder.append("\n" + getString(R.string.label_pay) + " " + tution_fee + " (VND)");
        builder.append("\n" + getString(R.string.label_tutor) + " " + tutor);
        builder.append("\n" + getString(R.string.label_course) + " " + course);

        if(yes==true && no==false)
            builder.append("\n" + getString(R.string.label_pay) + " " + getString(R.string.label_yes));
        if(yes==false && no==true)
            builder.append("\n" + getString(R.string.label_pay) + " " + getString(R.string.label_no));

        builder.append("\n" + getString(R.string.information));

        return builder.toString();
    }
}
