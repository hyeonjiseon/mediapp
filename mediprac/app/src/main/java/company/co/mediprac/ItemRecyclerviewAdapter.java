package company.co.mediprac;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.moonmonkeylabs.realmsearchview.RealmSearchAdapter;
import io.realm.Realm;
import io.realm.RealmViewHolder;

public class ItemRecyclerviewAdapter extends RealmSearchAdapter<Item, ItemRecyclerviewAdapter.ViewHolder> {
    //RealmSearchAdapter는 검색 뷰에서 Realm 데이터를 찾거나 필터링 할 수 있는 베이스 어댑터이다.
    //RealmSearchAdapter는 컨텍스트와 Realm, filterColumn 이름 등 필터링할 객체들을 받는다.

    private ArrayList<Item> mList;
    private LayoutInflater mInflate;
    private Context mContext;

    public ItemRecyclerviewAdapter(Context context, Realm realm, String filterColumnName) {
        super(context, realm, filterColumnName);
    }

    public class ViewHolder extends RealmViewHolder {
        private final ItemItemView itemItemView;

        public ViewHolder(ItemItemView itemItemView){
            super(itemItemView);
            this.itemItemView = itemItemView;
        }
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType){ //뷰를 포함한 뷰홀더를 만든다.
        ViewHolder vh = new ViewHolder(new ItemItemView(viewGroup.getContext()));
        return vh;
    }

    @Override
    public void onBindRealmViewHolder (ViewHolder viewHolder, int position){
        final Item item = realmResults.get(position);
        viewHolder.itemItemView.bind(item);
    }

    public ViewHolder convertViewHolder(RealmViewHolder viewHolder) { // 아이템 뷰를 저장하는 뷰홀더 클래스.
        return ViewHolder.class.cast(viewHolder);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { //전체 아이템 갯수 리턴.
        return mList.size();
    }
}

    //private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    // Provide a suitable constructor (depends on the kind of dataset)
//    public RecyclerviewAdapter(String[] myDataset) {// 생성자에서 데이터 리스트 객체를 전달받음.
////        mDataset = myDataset;
////    }

    // Create new views (invoked by the layout manager)
//    @Override // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
//    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        //viewType 형태의 아이템 뷰를 위한 뷰홀더 객체 생성.
//        // create a new view
//
//        TextView text = (TextView)LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item, parent, false);
//
//        MyViewHolder vh = new MyViewHolder(text);
//        return vh;
//    }

    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) { //position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        holder.textView.setText(mDataset[position]);
//
//    }
//

//}


//package com.js.xmlpullparser_example;

