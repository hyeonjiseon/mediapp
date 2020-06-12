package company.co.mediprac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> implements Filterable {

    //private List<Recent> fList;
    private ArrayList<Recent> filterList;
    private static ArrayList<Recent> mList;
    private LayoutInflater mInflate;
    private Context mContext;
    SearchView searchView;

    public RecyclerviewAdapter(Context context, ArrayList<Recent> items) {
        this.filterList = items;
        this.mList = items;
        this.mInflate = LayoutInflater.from(context);
        this.mContext = context;
//        mList = new ArrayList<Recent>();
//        mList.addAll(filterList);
    }

//    public void updateList(List<Recent> list) {
//        fList = list;
//        notifyDataSetChanged();
//    }

    @NonNull // 뷰 홀더는 각 리사이클러 뷰에 하나 이상으로 존재하게 되며, 각 한 줄을 표현
    @Override // 각 뷰 홀더는 어댑터에 의해 관리되며 이 객체는 RecyclerView.Adapter 객체
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    } // 어댑터라는 존재가 필요한 만큼 뷰 홀더를 생성하고, 뷰 홀더안에 표시할 데이터와 연결

    @Override // 뷰 홀더가 필요한 위치에 할당 될 때, 어댑터는 onBindViewHolder() 함수를 호출
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        final Recent item = filterList.get(position);
//        holder.ITEM_NAME.setText(item.getITEM_NAME());
//        holder.ENTP_NAME.setText(item.getENTP_NAME());
        //binding
        holder.ITEM_NAME.setText(mList.get(position).ITEM_NAME);
        holder.ENTP_NAME.setText(mList.get(position).ENTP_NAME);
    }

    @Override // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() { //전체 아이템 갯수 리턴.
        return this.filterList.size();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        filterList.clear();
        if (charText.length() == 0) {
            filterList.addAll(mList);
        } else {
            for (Recent recent : mList) {
                String name = recent.getITEM_NAME();
                if (name.toLowerCase().contains(charText)) {
                    filterList.add(recent);
                }
            }
        }
        notifyDataSetChanged();
    }

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            adapter.filter(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.filter(newText);
            return true;
        }
    });











//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String charString = constraint.toString();
//                if (charString.isEmpty()) {
//                    fList = mList;
//                } else {
//                    ArrayList<String> filteringList = new ArrayList<>();
//                    for (String name : mList) {
//                        if (name.toLowerCase().contains(charString.toLowerCase())) {
//                            filteringList.add(name);
//                        }
//                    }
//                    fList = filteringList;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = fList;
//                return filterResults;
//            }
//        }
//    }


            public static class MyViewHolder extends RecyclerView.ViewHolder { // 아이템 뷰를 저장하는 뷰홀더 클래스.
                // each data item is just a string in this case
                //public TextView textView;
                public TextView ITEM_NAME;
                public TextView ENTP_NAME;

                public MyViewHolder(View itemView) {
                    super(itemView);
                    ITEM_NAME = itemView.findViewById(R.id.item_name);
                    ENTP_NAME = itemView.findViewById(R.id.entp_name);
                }
//        public MyViewHolder(TextView v) {
//            super(v);
//            textView = v.findViewById(R.id.result);
//        }
            }

//     @Override
//     public Filter getFilter() {
//         return new Filter() {
//             @Override
//             protected FilterResults performFiltering(CharSequence constraint) {
//                 String charString = constraint.toString();
//                 if (charString.isEmpty()) {
//                     filterList = mList;
//                 } else {
//                     ArrayList<String> filteringList = new ArrayList<>();
//                     for (String name : mlist) {
//                         if (name.toLowerCase().contains(charString.toLowerCase())) {
//                             filteringList.add(name);
//                         }
//                     }
//                     filterList = filteringList;
//                 }
//                 FilterResults filterResults = new FilterResults();
//                 filterResults.values = filterList;
//                 return filterResults;
//             }
//         }
//     }
//
//    @Override
//    protected void publishResults(CharSequence constraint, FilterResults results) {
//        fList = (ArrayList<String>) results.values;
//        notifyDataSetChanged();
//    }
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

