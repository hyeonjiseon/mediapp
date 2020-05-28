package company.co.mediprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button QR_searchbtn = findViewById(R.id.QR_searchbtn);
//        QR_searchbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent QR_intent = new Intent(getApplicationContext(), Search_ResultList.class); //일단 바로 검색결과 띄음
//                startActivity(QR_intent);
//            }
//        });

        Button text_searchbtn= findViewById(R.id.text_searchbtn);
//        text_searchbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent text_intent = new Intent (getApplicationContext(), Search_Text.class); //일단 바로 검색결과 띄음
//                startActivity(text_intent);
//            }
//        });

    }
}
