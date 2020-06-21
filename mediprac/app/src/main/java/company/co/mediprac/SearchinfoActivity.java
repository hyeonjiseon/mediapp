package company.co.mediprac;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchinfo);

        String ITEM_NAME = getIntent().getStringExtra("item_name");
        Log.e("ITEM_NAME", ITEM_NAME);

        TextView textView = (TextView)findViewById(R.id.item_name);
        textView.setText(ITEM_NAME);

        String ENTP_NAME = getIntent().getStringExtra("entp_name");
        String ETC_OTC_CODE = getIntent().getStringExtra("etc_otc_code");
        String ITEM_PERMIT_DATE = getIntent().getStringExtra("item_permit_date");
        Log.e("item_permit_date", ITEM_PERMIT_DATE);
        String ENTP_NO = getIntent().getStringExtra("ENTP_NO");
        Log.e("ENTP_NO", ENTP_NO);
        String BAR_CODE = getIntent().getStringExtra("bar_code");
        String ITEM_SEQ = getIntent().getStringExtra("item_seq");
        String CHART = getIntent().getStringExtra("chart");

        String MATERIAL_NAME = getIntent().getStringExtra("material_name");//원료성분

        String PACK_UNIT = getIntent().getStringExtra("PACK_UNIT");
        String PERMIT_KIND_NAME = getIntent().getStringExtra("PERMIT_KIND_NAME");
        String CANCEL_DATE = getIntent().getStringExtra("CANCEL_DATE");
        String MAKE_MATERIAL_FLAG = getIntent().getStringExtra("MAKE_MATERIAL_FLAG");
        String INDUTY_TYPE = getIntent().getStringExtra("INDUTY_TYPE");
        String CHANGE_DATE = getIntent().getStringExtra("CHANGE_DATE");
        String INGR_NAME = getIntent().getStringExtra("INGR_NAME");

        String EE_DOC_ID = getIntent().getStringExtra("EE_DOC_ID");
        Log.e("EE_DOC_ID", EE_DOC_ID);

    }
}
