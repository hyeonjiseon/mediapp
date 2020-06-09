package company.co.mediprac;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PotionListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    private List<Item> potionList = null;
    private ArrayList<Item> mList;
    public PotionListViewAdapter(Context context, List<Item> potionList) {
        this.context = context;
        this.potionList = potionList;
        inflater = LayoutInflater.from(context);
        this.mList = new ArrayList<Item>();
        this.mList.addAll(potionList);
    }

    public class ViewHolder {
        TextView ITEM_NAME;
        TextView ENTP_NAME;
    }

    @Override
    public int getCount() {
        return potionList.size();
    }

    @Override
    public Item getItem(int position) {
        return potionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        final Item item = potionList.get(position);


        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list, null);
            // Locate the TextViews in listview_item.xml
            holder.ITEM_NAME = (TextView) view.findViewById(R.id.item_name);
            holder.ENTP_NAME = (ImageView) view.findViewById(R.id.entp_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.item_name.setText(item.item_name);
        holder.entp_name.setText(item.entp_name);
        //Glide.with(context).load(item.icon).into(holder.iv_icon);

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, BrewingActivity.class);;
                ...
                context.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        potionList.clear();
        if (charText.length() == 0) {
            potionList.addAll(mList);
        } else {
            for (Item item : mList) {
                String name = context.getResources().getString(item.name);
                if (name.toLowerCase().contains(charText)) {
                    potionList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}
