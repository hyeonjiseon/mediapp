package company.co.mediprac;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class TextresultActivity extends AppCompatActivity implements RecyclerviewAdapter.onItemListener {

    //private List<Recent> mList;
    public String requestUrl;
    Recent bus = null;
    public String key="BZAkHyL1OvsaKk4INUgYd1ra39ts5cl%2BDojvvOH%2BQkW3FCIifva%2FTa5ZTKvrIt03W97NKmFMZH4Oq%2B6jIwy5bA%3D%3D";
    //private RecyclerviewAdapter adapter;

    //LinearLayoutManager mLayoutManager;
    ArrayList<Recent> mList;
    //ArrayList<Recent> mList = null;
    //ArrayList<Recent> items = new ArrayList<>();
    //private List<Recent> itemList;
    //ArrayList<Recent> items = null;
    XmlPullParser xpp;
    String data;

//  EditText edit;
//    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textresult);

        //setUpRecyclerView();
        //RecyclerView recyclerView = findViewById(R.id.recyclerview_medlist);
        //recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(this);
//         LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//         layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//         recyclerView.setLayoutManager(layoutManager);

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);

        // AsyncTask
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

        //edit = (EditText)findViewById(R.id.edit);
        //edit.addTextChangedListener((TextWatcher) this);

        //String text = edit.toString();
//        List<Recent> potionList = new ArrayList<Recent>();
//
//        for(int i=0;i<30;i++){
//            Recent rc = new Recent(i+"","");
//            potionList.add(rc);
//        }
//
//        for(int i=0;i<30;i++){
//            Recent rc = new Recent(i+""+i,"");
//            potionList.add(rc);
//        }
//
//        for(int i=0;i<30;i++){
//            Recent rc = new Recent(i+""+i+""+i,"");
//            potionList.add(rc);
//        }

        //검색창 - 잘 안됨
//        edit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s){
//                String text = edit.getText().toString().toLowerCase(Locale.getDefault());
//                adapter.filter(text);
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after){
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int count, int after){
//                // TODO Auto-generated method stub
//                adapter.getFilter().filter(charSequence);
//            }
//        });
    }

//    private void setUpRecyclerView() {
//        RecyclerView recyclerView = findViewById(R.id.recyclerview_medlist);
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        //adapter = new RecyclerviewAdapter(this, items);
        //items = new ArrayList<>();//샘플데이터
//        fillData();

//        adapter = new RecyclerviewAdapter(getApplicationContext(), (ArrayList<Recent>) itemList);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        //adapter = new RecyclerviewAdapter(getApplicationContext(), item);

        //데이터셋 변경 시 adapter.dataSetChanged(exampleList);
        //어댑터의 리스너 호출
        //adapter.setOnClickListener(this);


        // recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(adapter);
//

   // }

//    private void fillData() {
//        itemList = new ArrayList<>();
//        itemList.add(new Recent("종근당1", "종근당2"));
//        itemList.add(new Recent("흑설탕1", "흑설탕2"));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                RecyclerviewAdapter adapter = new RecyclerviewAdapter(getApplicationContext(), (ArrayList<Recent>) mList);
                Log.e("NEWTEXT",newText);
                adapter.getFilter().filter(newText);
                return false;
                //return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "클릭" + position, Toast.LENGTH_SHORT).show();
    }

    public class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            requestUrl = "http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductList?&ServiceKey=" + key;
            try {
                boolean b_ITEM_NAME = false;
                boolean b_ENTP_NAME = false;

                URL url = new URL(requestUrl);
                InputStream is = url.openStream();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new InputStreamReader(is, "UTF-8"));

                String tag;
                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            mList = new ArrayList<Recent>();
                            break;
                        case XmlPullParser.END_DOCUMENT:
                            break;
                        case XmlPullParser.END_TAG:
                            if (parser.getName().equals("item") && bus != null) {
                                mList.add(bus);
                            }
                            break;
                        case XmlPullParser.START_TAG:
                            if (parser.getName().equals("item")) {
                                bus = new Recent();
                            }
                            if (parser.getName().equals("ITEM_NAME")) b_ITEM_NAME = true;
                            if (parser.getName().equals("ENTP_NAME")) b_ENTP_NAME = true;
                            break;
                        case XmlPullParser.TEXT:
                            if (b_ITEM_NAME) {
                                bus.setITEM_NAME(parser.getText());
                                b_ITEM_NAME = false;
                            } else if (b_ENTP_NAME) {
                                bus.setENTP_NAME(parser.getText());
                                b_ENTP_NAME = false;
                            }
                            break;
                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            RecyclerView recyclerView = findViewById(R.id.recyclerview_medlist);
            RecyclerviewAdapter adapter = new RecyclerviewAdapter(getApplicationContext(), (ArrayList<Recent>) mList);
            recyclerView.setAdapter(adapter);

            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

//            //데이터셋 변경 시
            //adapter.dataSetChanged(filterList);
//            //어댑터의 리스너 호출
            //adapter.setOnClickListener(this);is

             recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
             recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
             recyclerView.setAdapter(adapter);
//

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(dividerItemDecoration);
        }
    }

    //    @Bind(R.id.listview)
//    ListView listview;
//    @Bind(R.id.editsearch)
//    EditText editsearch;
//    @Bind(R.id.Layout_Internet)
//    RelativeLayout internetLayout;

    //Button을 클릭했을 때 자동으로 호출되는 callback method....
//    public void mOnClick(View v){
//
//        switch (v.getId()){
//            case R.id.button:
//                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
//                new Thread(new Runnable() {
//                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        try {
//                            data=getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//                        // UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기 때문에
//                        // runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                // TODO Auto-generated method stub
//                                text.setText(data);//TextView에 문자열  data 출력
//                            }
//                        });
//                    }
//                }).start();
//                break;
//        }
//    }
}

