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

        String search_name = getIntent().getStringExtra("item_name");
        Log.e("search_name", search_name);

        String ENTP_NAME = getIntent().getStringExtra("entp_name");
        String ETC_OTC_CODE = getIntent().getStringExtra("etc_otc_code");
        String ITEM_PERMIT_DATE = getIntent().getStringExtra("item_permit_date");

        TextView textView = (TextView)findViewById(R.id.item_name);
        textView.setText(search_name);

    }



//    Intent infointent = new Intent(mContext, SearchinfoActivity.class);
//                     infointent.putExtra("item_name", arrayitem.getITEM_NAME());
//                     infointent.putExtra("entp_name", arrayitem.getENTP_NAME());
//                     infointent.putExtra("etc_otc_code", arrayitem.getETC_OTC_CODE());
//                     infointent.putExtra("item_permit_date", arrayitem.getITEM_PERMIT_DATE());
}
