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

        String UD_DOC_DATA = getIntent().getStringExtra("UD_DOC_DATA"); //효능효과
        Log.d("UD", UD_DOC_DATA);

        TextView textView36 = (TextView)findViewById(R.id.textView38);
        textView36.setText(UD_DOC_DATA);
    }
}
