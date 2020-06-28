package company.co.mediprac;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CapinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capinfo);

        if(getIntent().getStringExtra("UD_DOC_DATA") != null) {
            String UD_DOC_DATA = getIntent().getStringExtra("UD_DOC_DATA"); //효능효과
            Log.d("UD", UD_DOC_DATA);

            TextView textView37 = (TextView) findViewById((R.id.textView37));
            textView37.setText("용법 용량");

            TextView textView36 = (TextView) findViewById(R.id.textView38);
            textView36.setText(UD_DOC_DATA);
        }

        if(getIntent().getStringExtra("NB_DOC_DATA") != null) {
            String NB_DOC_DATA = getIntent().getStringExtra("NB_DOC_DATA"); //효능효과

            TextView textView37 = (TextView) findViewById((R.id.textView37));
            textView37.setText("주의사항");

            TextView textView36 = (TextView) findViewById(R.id.textView38);
            textView36.setText(NB_DOC_DATA);
        }
    }
}
