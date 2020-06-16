package company.co.mediprac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    private  static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();

        Button button_search = findViewById(R.id.button);
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_search = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent_search);
            }
        });

        Button b = (Button)findViewById(R.id.button4);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(
//                        getApplicationContext(), // 현재 화면의 제어권자
//                        ShareActivity.class); // 다음 넘어갈 클래스 지정
//                startActivity(intent); // 다음 화면으로 넘어간다
//            }
//        });
    }
    public static Context getAppContext() {
        return MainActivity.context;
    }
}
