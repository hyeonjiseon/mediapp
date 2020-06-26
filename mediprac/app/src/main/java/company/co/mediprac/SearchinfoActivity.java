package company.co.mediprac;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchinfo);

        String ITEM_NAME = getIntent().getStringExtra("item_name");
        TextView textView = (TextView)findViewById(R.id.item_name);
        textView.setText(ITEM_NAME);

        String ud = getIntent().getStringExtra("UD_DOC_DATA");
        Log.d("ud", ud);

        Button button_search = findViewById(R.id.result_btn1);
                button_search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                Intent intent_search = new Intent(getApplicationContext(), BasicinfoActivity.class);

                intent_search.putExtra("item_name", getIntent().getStringExtra("item_name"));
                intent_search.putExtra("entp_name", getIntent().getStringExtra("entp_name"));
                intent_search.putExtra("etc_otc_code", getIntent().getStringExtra("etc_otc_code"));
                intent_search.putExtra("item_permit_date", getIntent().getStringExtra("item_permit_date"));
                intent_search.putExtra("ENTP_NO", getIntent().getStringExtra("ENTP_NO"));
                intent_search.putExtra("bar_code", getIntent().getStringExtra("bar_code"));
                intent_search.putExtra("item_seq", getIntent().getStringExtra("item_seq"));
                intent_search.putExtra("chart", getIntent().getStringExtra("chart"));
                intent_search.putExtra("PACK_UNIT", getIntent().getStringExtra("PACK_UNIT"));
                intent_search.putExtra("PERMIT_KIND_NAME", getIntent().getStringExtra("PERMIT_KIND_NAME"));
                intent_search.putExtra("CANCEL_DATE", getIntent().getStringExtra("CANCEL_DATE"));
                intent_search.putExtra("MAKE_MATERIAL_FLAG", getIntent().getStringExtra("MAKE_MATERIAL_FLAG"));
                intent_search.putExtra("INDUTY_TYPE", getIntent().getStringExtra("INDUTY_TYPE"));
                intent_search.putExtra("CHANGE_DATE", getIntent().getStringExtra("CHANGE_DATE"));
                intent_search.putExtra("INGR_NAME", getIntent().getStringExtra("INGR_NAME"));

                startActivity(intent_search);
            }
        });

        Button result_btn2 = findViewById(R.id.result_btn2);
        result_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_btn2 = new Intent(getApplicationContext(), EffectinfoActivity.class);
                intent_btn2.putExtra("EE_DOC_DATA", getIntent().getStringExtra("EE_DOC_DATA"));
                startActivity(intent_btn2);
            }
        });

        Button result_btn3 = findViewById(R.id.result_btn3);
        result_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_btn3 = new Intent(getApplicationContext(), CapinfoActivity.class);
                intent_btn3.putExtra("UD_DOC_DATA", getIntent().getStringExtra("UD_DOC_DATA"));
                startActivity(intent_btn3);
            }
        });


        String MATERIAL_NAME = getIntent().getStringExtra("material_name");//원료성분


    }
}
