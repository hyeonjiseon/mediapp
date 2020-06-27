package company.co.mediprac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button QR_searchbtn = findViewById(R.id.QR_searchbtn);
        QR_searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent QR_intent = new Intent(getApplicationContext(), BaresultActivity.class); //일단 바로 검색결과 띄음
                startActivity(QR_intent);
            }
        });

        Button button3 = findViewById(R.id.text_searchbtn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_textsearch = new Intent(getApplicationContext(), TextresultActivity.class); //일단 바로 검색결과 띄음
                startActivity(intent_textsearch);
            }
        });
    }
}
