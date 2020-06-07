package company.co.mediprac;

import android.widget.RelativeLayout;

public class ItemItemView extends RelativeLayout {

    @Bind(R.id.item_name)
    Textview name;

    public ItemItemView(Context context){
        super(context);
        init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.item_view, this);
        ButterKnife.bind(this);
    }

    public void bind(Blog blog){
        name.setText(blog.getName());
    }
}
