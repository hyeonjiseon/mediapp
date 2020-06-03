package company.co.mediprac;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class TextresultActivity extends AppCompatActivity {

    public String requestUrl;
    ArrayList<Item> list = null;
    Item bus = null;
    RecyclerView recyclerView;
    XmlPullParser xpp;

    public String key="BZAkHyL1OvsaKk4INUgYd1ra39ts5cl%2BDojvvOH%2BQkW3FCIifva%2FTa5ZTKvrIt03W97NKmFMZH4Oq%2B6jIwy5bA%3D%3D";
    String data;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textresult);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");//edit에서 받아옴

        TextView inputword = (TextView)findViewById(R.id.inputword);//받아온 edit name을 나타냄
        inputword.setText(name);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_medlist);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //AsyncTask
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

        // specify an adapter (see also next example)
        //mAdapter = new RecyclerviewAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);
    }

    public class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings){
            requestUrl = "http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductList?&ServiceKey="+key;
            try{
                boolean b_ITEM_NAME = false;

                URL url = new URL(requestUrl);
                InputStream is = url.openStream();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new InputStreamReader(is, "UTF-8"));

                String tag;
                int evenType = parser.getEventType();

                while(evenType != XmlPullParser.END_DOCUMENT){
                    switch(evenType){
                        case XmlPullParser.START_DOCUMENT:
                            list = new ArrayList<Item>();
                            break;
                        case XmlPullParser.END_DOCUMENT:
                            break;
                        case XmlPullParser.END_TAG:
                            if(parser.getName().equals("item") && bus != null){
                                list.add(bus);
                            }
                            break;
                        case XmlPullParser.START_TAG:
                            if(parser.getName().equals("item")){
                                bus = new Item();
                            }
                            if(parser.getName().equals("ITEM_NAME"))
                                b_ITEM_NAME = true;
                            break;
                        case XmlPullParser.TEXT:
                            if(b_ITEM_NAME){
                                bus.setITEM_NAME(parser.getText());
                                b_ITEM_NAME = false;
                            }
                            break;
                    }
                    evenType = parser.next();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            //어답터 연결
            RecyclerviewAdapter adapter = new RecyclerviewAdapter(getApplicationContext(), list);
            recyclerView.setAdapter(adapter);
        }
    }
}
