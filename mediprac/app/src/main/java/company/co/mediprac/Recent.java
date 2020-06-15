package company.co.mediprac;

public class Recent {

    String ITEM_NAME;
    String ENTP_NAME;
    String ITEM_PERMIT_DATE;
    String INDUTY;
    String PRDLST_STDR_CODE; //195500002
    String SPCLTY_PBLC; //전문의약품

//    public Recent(){}
//    public Recent(String ITEM_NAME, String ENTP_NAME){
//        this.ITEM_NAME = ITEM_NAME;
//        this.ENTP_NAME = ENTP_NAME;
//    }

    public String getITEM_NAME() { return ITEM_NAME; }
    public String getENTP_NAME() { return ENTP_NAME; }
    public String getITEM_PERMIT_DATE() { return ITEM_PERMIT_DATE; }
    public String getINDUTY() { return INDUTY; }
    public String getPRDLST_STDR_CODE() { return PRDLST_STDR_CODE; }
    public String getSPCLTY_PBLC() { return SPCLTY_PBLC; }

    public void setITEM_NAME(String ITEM_NAME) { this.ITEM_NAME = ITEM_NAME; }
    public void setENTP_NAME(String ENTP_NAME) { this.ENTP_NAME = ENTP_NAME; }
    public void setITEM_PERMIT_DATE(String ITEM_PERMIT_DATE) { this.ITEM_PERMIT_DATE = ITEM_PERMIT_DATE; }
    public void setINDUTY(String INDUTY) { this.INDUTY = INDUTY; }
    public void setPRDLST_STDR_CODE(String PRDLST_STDR_CODE) { this.PRDLST_STDR_CODE = PRDLST_STDR_CODE; }
    public void setSPCLTY_PBLC(String SPCLTY_PBLC) { this.SPCLTY_PBLC = SPCLTY_PBLC; }

}
