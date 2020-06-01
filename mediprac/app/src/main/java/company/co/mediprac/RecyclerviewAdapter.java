package company.co.mediprac;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder { // 아이템 뷰를 저장하는 뷰홀더 클래스.
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v.findViewById(R.id.result);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerviewAdapter(String[] myDataset) {// 생성자에서 데이터 리스트 객체를 전달받음.
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //viewType 형태의 아이템 뷰를 위한 뷰홀더 객체 생성.
        // create a new view

        TextView text = (TextView)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_medlist, parent, false);

        MyViewHolder vh = new MyViewHolder(text);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) { //position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { //전체 아이템 갯수 리턴.
        return mDataset.length;
    }
}

class medlist {

}