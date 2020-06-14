package company.co.mediprac;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask <String, Void, String> {

    public String requestUrl;
    ArrayList<Recent> items = null;
    private ArrayList<Recent> filterList;
    Recent bus = null;
    XmlPullParser xpp;
    public String key="BZAkHyL1OvsaKk4INUgYd1ra39ts5cl%2BDojvvOH%2BQkW3FCIifva%2FTa5ZTKvrIt03W97NKmFMZH4Oq%2B6jIwy5bA%3D%3D";
    String data;

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
                        items = new ArrayList<Recent>();
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item") && bus != null){
                            items.add(bus);
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
//        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview_medlist);
//        RecyclerviewAdapter adapter = new RecyclerviewAdapter(getApplicationContext(), items);
//        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String charString = constraint.toString();
//                if (charString.isEmpty()) {
//                    filterList = mList;
//                } else {
//                    ArrayList<String> filteringList = new ArrayList<>();
//                    for (String name : mList) {
//                        if (name.toLowerCase().contains(charString.toLowerCase())) {
//                            filteringList.add(name);
//                        }
//                    }
//                    filterList = filteringList;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = filterList;
//                return filterResults;
//            }
//        }
//    }






















}
