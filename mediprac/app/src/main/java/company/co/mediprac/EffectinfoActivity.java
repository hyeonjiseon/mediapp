package company.co.mediprac;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EffectinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effectinfo);

        if(getIntent().getStringExtra("EE_DOC_DATA") != null) {
            String EE_DOC_DATA = getIntent().getStringExtra("EE_DOC_DATA"); //효능효과
            Log.e("EE_DOC_DATA", EE_DOC_DATA);

            TextView textView34 = (TextView) findViewById(R.id.textView34);
            textView34.setText("효능 효과");

            TextView textView36 = (TextView) findViewById(R.id.textView36);
            textView36.setText(EE_DOC_DATA);
        }

        if(getIntent().getStringExtra("chart") != null) {
            String CHART = getIntent().getStringExtra("chart");

            TextView textView34 = (TextView) findViewById(R.id.textView34);
            textView34.setText("제품 모양");

            TextView textView36 = (TextView) findViewById(R.id.textView36);
            textView36.setText(CHART);
        }

        if(getIntent().getStringExtra("STORAGE_METHOD") != null) {
            String STORAGE_METHOD = getIntent().getStringExtra("STORAGE_METHOD");

            TextView textView34 = (TextView) findViewById(R.id.textView34);
            textView34.setText("저장 방법");

            TextView textView36 = (TextView) findViewById(R.id.textView36);
            textView36.setText(STORAGE_METHOD);
        }

        if(getIntent().getStringExtra("VALID_TERM") != null) {
            String VALID_TERM = getIntent().getStringExtra("VALID_TERM");

            TextView textView34 = (TextView) findViewById(R.id.textView34);
            textView34.setText("유효 기간");

            TextView textView36 = (TextView) findViewById(R.id.textView36);
            textView36.setText(VALID_TERM);
        }

        if(getIntent().getStringExtra("material_name") != null) {

            String MATERIAL_NAME = getIntent().getStringExtra("material_name");//원료성분

            TextView textView34 = (TextView) findViewById(R.id.textView34);
            textView34.setText("원료 및 성분");

            TextView textView36 = (TextView) findViewById(R.id.textView36);
            textView36.setText(MATERIAL_NAME);
        }

    }
}
