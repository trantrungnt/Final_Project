package academy.android.vietnam.trungnt.learningenglish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import academy.android.vietnam.trungnt.learningeinglish.R;

/**
 * Created by TrungNT on 12/12/2015.
 */
public class AuthorActivity extends AppCompatActivity {
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        //Close UI Author
        processCloseAuthor();
    }

    private void processCloseAuthor()
    {
        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //close this Author Activity
                finish();
            }
        });
    }
}
