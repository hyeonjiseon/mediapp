package company.co.mediprac;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

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

    private RecyclerviewAdapter adapter;
    RecyclerView recyclerView;
    EditText edit;
    LinearLayoutManager mLayoutManager;
    //ArrayList<Recent> items = null;
    ArrayList<Recent> items = new ArrayList<>();

    public String requestUrl;
    ArrayList<Recent> list = null;
    Recent bus = null;
    XmlPullParser xpp;
    public String key="BZAkHyL1OvsaKk4INUgYd1ra39ts5cl%2BDojvvOH%2BQkW3FCIifva%2FTa5ZTKvrIt03W97NKmFMZH4Oq%2B6jIwy5bA%3D%3D";
    String data;


    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textresult);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_medlist);
        edit = (EditText)findViewById(R.id.edit);

        edit.addTextChangedListener((TextWatcher) this);

        //adapter = new RecyclerviewAdapter(this, items);
        adapter = new RecyclerviewAdapter(getApplicationContext(), items);

        // use a linear layout manager
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // recyclerView.setLayoutManager(layoutManager);
        // recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // AsyncTask
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

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

        // specify an adapter (see also next example)
        //mAdapter = new RecyclerviewAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);

        //검색창
        edit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s){
//                String text = edit.getText().toString().toLowerCase(Locale.getDefault());
//                adapter.filter(text);
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after){
//                //TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int count, int after){
//                // TODO Auto-generated method stub
//                //adapter.getFilter().filter(charSequence);
//            }

            @Override
            public void afterTextChanged(Editable editable){

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after){
                //TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after){
                //adapter.getFilter().filter(charSequence);
            }

        });

        class MyAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... strings){
                requestUrl = "http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductList?&ServiceKey="+key;
                try{
                    boolean b_ITEM_NAME = false;
                    boolean b_ENTP_NAME = false;

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
                                list = new ArrayList<Recent>();
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
                                    bus = new Recent();
                                }
                                if(parser.getName().equals("ITEM_NAME")) b_ITEM_NAME = true;
                                if(parser.getName().equals("ENTP_NAME")) b_ENTP_NAME = true;
                                break;
                            case XmlPullParser.TEXT:
                                if(b_ITEM_NAME){
                                    bus.setITEM_NAME(parser.getText());
                                    b_ITEM_NAME = false;
                                } else if(b_ENTP_NAME){
                                    bus.setENTP_NAME(parser.getText());
                                    b_ENTP_NAME = false;
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
                RecyclerviewAdapter adapter = new RecyclerviewAdapter(getApplicationContext(), items);
                recyclerView.setAdapter(adapter);
            }
        }

//        void filter (String text) {
//            List<Recent> temp = new ArrayList();
//            for(Recent d: potionList){
//                //or use .dqual(text) with you want equal match
//                //use .toLowerCase() for better matches
//                if(d.getITEM_NAME().contains(text)){
//                    temp.add(d);
//                }
//            }
//            //update recyclerview
//            adapter.updateList(temp);
//        }


    }

//    @Bind(R.id.listview)
//    ListView listview;
//    @Bind(R.id.editsearch)
//    EditText editsearch;
//    @Bind(R.id.Layout_Internet)
//    RelativeLayout internetLayout;
//


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

    //XmlPullParser를 이용하여 Naver 에서 제공하는 OpenAPI XML 파일 파싱하기(parsing)

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    String getXmlData() throws UnsupportedEncodingException {
//        StringBuffer buffer=new StringBuffer();
//        String str= edit.getText().toString();//EditText에 작성된 Text얻어오기
//        String med_name = URLEncoder.encode(str, java.nio.charset.StandardCharsets.UTF_8.toString());//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..
//        //med_name을 넘겨줘야 할 듯
//
//        String queryUrl="http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductList?&pageNo=1&numOfRows=10&ServiceKey="+key+"&ITEM_NAME="+med_name;
//
//        try{
//            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성
//            InputStream is= url.openStream(); //url위치로 입력스트림 연결
//
//            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml파싱을 위한
//            XmlPullParser xpp= factory.newPullParser();
//            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기
//
//            String tag;
//
//            xpp.next();
//            int eventType= xpp.getEventType();
//
//            while( eventType != XmlPullParser.END_DOCUMENT ){
//                switch( eventType ){
//                    case XmlPullParser.START_DOCUMENT:
//                        buffer.append("파싱 시작...\n\n");
//                        break;
//
//                    case XmlPullParser.START_TAG:
//                        tag= xpp.getName();//태그 이름 얻어오기
//
//                        if(tag.equals("item"));// 첫번째 검색결과
//                        else if(tag.equals("ITEM_NAME")){
//                            buffer.append("품목명 : ");
//                            xpp.next();
//                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n"); //줄바꿈 문자 추가
//                        }
//                        else if(tag.equals("ENTP_NAME")){
//                            buffer.append("업체명 : ");
//                            xpp.next();
//                            buffer.append(xpp.getText());//category 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n");//줄바꿈 문자 추가
//                        }
//                        else if(tag.equals("ITEM_PERMIT_DATE")){
//                            buffer.append("품목 허가 일자 :");
//                            xpp.next();
//                            buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n");//줄바꿈 문자 추가
//                        }
//                        else if(tag.equals("INDUTY")){
//                            buffer.append("업종 : ");
//                            xpp.next();
//                            buffer.append(xpp.getText());//category 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n");//줄바꿈 문자 추가
//                        }
//                        else if(tag.equals("PRDLST_STDR_CODE")){
//                            buffer.append("품목일련번호 : ");
//                            xpp.next();
//                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n"); //줄바꿈 문자 추가
//                        }
//                        else if(tag.equals("SPCLTY_PBLC")){
//                            buffer.append("전문/일반 구분 :");
//                            xpp.next();
//                            buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n");//줄바꿈 문자 추가
//                        }
//                        else if(tag.equals("PRODUCT_PRMISN_NO")){
//                            buffer.append("품목허가번호 :");
//                            xpp.next();
//                            buffer.append(xpp.getText());//telephone 요소의 TEXT 읽어와서 문자열버퍼에 추가
//                            buffer.append("\n");//줄바꿈 문자 추가
//                        }
//                        break;
//
//                    case XmlPullParser.TEXT:
//                        break;
//
//                    case XmlPullParser.END_TAG:
//                        tag= xpp.getName(); //테그 이름 얻어오기
//
//                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
//                        break;
//                }
//
//                eventType= xpp.next();
//            }
//
//        } catch (Exception e){// TODO Auto-generated catch blocke.printStackTrace();
//            e.printStackTrace();
//        }
//
//        buffer.append("파싱 끝\n");
//        return buffer.toString();//StringBuffer 문자열 객체 반환
//
//    }//getXmlData method....
}

}