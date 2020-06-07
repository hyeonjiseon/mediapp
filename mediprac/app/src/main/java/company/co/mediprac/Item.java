package company.co.mediprac;

import io.realm.RealmObject;

public class Item extends RealmObject {

    private String ITEM_NAME;

    public Item(){}

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

}
