package company.co.mediprac;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> implements Filterable {

    //private List<Recent> filterList;
    //private List<Recent> mList;
    private ArrayList<Recent> mList;
    private ArrayList<Recent> filterList;
    //private static ArrayList<Recent> mList;
    private LayoutInflater mInflate;
    private Context mContext;
    SearchView searchView;

    public RecyclerviewAdapter(Context context, ArrayList<Recent> items) {
        //filterList = items;

        //super();

        this.filterList = items;
        //this.mList = new ArrayList<>(items);
        this.mList = items;
        //mList = new ArrayList<>(items);

        this.mInflate = LayoutInflater.from(context);
        this.mContext = context;
//        mList = new ArrayList<Recent>();
//        mList.addAll(filterList);
    }

    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MyViewHolder(view);
    }

    private onItemListener mListener;
    public void setOnClickListener(onItemListener listener){
        mListener = listener;
    }

    public void dataSetChanged(ArrayList<Recent> exampleList){
        filterList = exampleList;
        notifyDataSetChanged();
    }

//    @NonNull // 뷰 홀더는 각 리사이클러 뷰에 하나 이상으로 존재하게 되며, 각 한 줄을 표현
//    @Override // 각 뷰 홀더는 어댑터에 의해 관리되며 이 객체는 RecyclerView.Adapter 객체
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflate.inflate(R.layout.item, parent, false);
//        MyViewHolder viewHolder = new MyViewHolder(view);
//        return viewHolder;
//    } // 어댑터라는 존재가 필요한 만큼 뷰 홀더를 생성하고, 뷰 홀더안에 표시할 데이터와 연결

    @Override // 뷰 홀더가 필요한 위치에 할당 될 때, 어댑터는 onBindViewHolder() 함수를 호출
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //binding
//        holder.ITEM_NAME.setText(mList.get(position).ITEM_NAME);
//        holder.ENTP_NAME.setText(mList.get(position).ENTP_NAME);

        holder.ITEM_NAME.setText(filterList.get(position).getITEM_NAME());
        holder.ENTP_NAME.setText(filterList.get(position).getENTP_NAME());

//        if(mListener != null){
//            final int pos = position;
//            holder.itemView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v){
//                    mListener.onItemClicked(position);
//                }
//            });
//        }
    }

    public Filter getFilter(){
        return exampleFilter;
    }

    @Override // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() { //전체 아이템 갯수 리턴.
        //return this.filterList.size();
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder { // 아이템 뷰를 저장하는 뷰홀더 클래스.
         // each data item is just a string in this case
         //public TextView textView;
//         public TextView ITEM_NAME;
//         public TextView ENTP_NAME;
        private TextView ITEM_NAME, ENTP_NAME;

         public MyViewHolder(View itemView) {
             super(itemView);
             ITEM_NAME = itemView.findViewById(R.id.item_name);
             ENTP_NAME = itemView.findViewById(R.id.entp_name);
         }
    }

    public interface onItemListener{
        void onItemClicked(int position);
    }

     public Filter exampleFilter = new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence constraint) {
             //filterList.clear();
             String charString = constraint.toString();
             Log.e("CHAR String", charString);
             if (charString.isEmpty()) {
                 filterList = mList;
             } else {
                 ArrayList<Recent> filteringList = new ArrayList<>();
                // Log.e("CHAR String222", charString);
                 for (Recent item : mList) {
                     if (item.getITEM_NAME().contains(charString)) {//toLowerCase()., .toLowerCase()
                         filteringList.add(item);
                     }
                 }
                 Log.e("FilterlistLength", String.valueOf(filteringList.size()));
                 filterList = filteringList;
             }
             FilterResults filterResults = new FilterResults();
             filterResults.values = filterList;
             return filterResults;
         }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //filterList.clear();
            Log.e("CLEAR", String.valueOf(filterList));
            //filterList.addAll((List) results.values);

             filterList = (ArrayList<Recent>) results.values;
             notifyDataSetChanged();
        }
    };
}
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
//}