package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-18.
 */

public class BusRegInfo extends Api implements BusRegInfoConst{
    private String mOperation;
    private int mReqPage;
    private String mRouteID;
    private BusRegInfoItem mCurrentItem;

    private List<BusRegInfoItem> mItems;

    public BusRegInfo(String strAPIKey, int reqPage) {
        super(strAPIKey);
        mReqPage = reqPage;
        this.mOperation = OPERATION_BUS_REGISTINFO_ALL;
        mItems = new ArrayList<>();
    }

    public BusRegInfo(String strAPIKey, String routeID) {
        super(strAPIKey);
        mRouteID = routeID;
        this.mOperation = OPERATION_BUS_REGISTINFO_BY_ROUTEID;
        mItems = new ArrayList<>();
    }

    @Override
    public String getUrl() {
        String url = null;
        if(getOperation().equals(OPERATION_BUS_REGISTINFO_BY_ROUTEID)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/busreginfo/%s?serviceKey=%s&busRouteId=%s";
            url = String.format(url, getOperation(), getApiKey(), getRouteID());
        }else if(getOperation().equals(OPERATION_BUS_REGISTINFO_ALL)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/busreginfo/%s?serviceKey=%s&reqPage=%d";
            url = String.format(url, getOperation(), getApiKey(), getReqPage());
        }
        return url;
    }

    @Override
    public List<BusRegInfoItem> getItems() {
        return mItems;
    }

    @Override
    public void startElement(String tag) {
        switch (tag){
            case ITEM_LIST:{
                mCurrentItem = new BusRegInfoItem();
                break;
            }
        }
    }

    @Override
    public void endElement(String tag, String value) {
        switch (tag){
            case ITEM_LIST:{
                mItems.add(mCurrentItem);
                break;
            }
            case BUS_TYPE:{
                mCurrentItem.setBusType(value);
                break;
            }
            case CAR_REG_NO:{
                mCurrentItem.setCarRegistNumber(value);
                break;
            }
            case CHARACTER:{
                mCurrentItem.setCharacter(value);
                break;
            }
            case COMP_CD:{
                mCurrentItem.setCompanyNumber(value);
                break;
            }
            case ROUTE_CD:{
                mCurrentItem.setRouteCode(value);
                break;
            }
        }
    }

    public String getOperation() {
        return mOperation;
    }

    public int getReqPage() {
        return mReqPage;
    }

    public String getRouteID() {
        return mRouteID;
    }


    public static class BusRegInfoItem extends Item{
        String mBusType;
        String mCarRegistNumber;
        String mCharacter;
        String mCompanyNumber;
        String mRouteCode;

        public String getBusType() {
            return mBusType;
        }

        public void setBusType(String busType) {
            mBusType = busType;
        }

        public String getCarRegistNumber() {
            return mCarRegistNumber;
        }

        public void setCarRegistNumber(String carRegistNumber) {
            mCarRegistNumber = carRegistNumber;
        }

        public String getCharacter() {
            return mCharacter;
        }

        public void setCharacter(String character) {
            mCharacter = character;
        }

        public String getCompanyNumber() {
            return mCompanyNumber;
        }

        public void setCompanyNumber(String companyNumber) {
            mCompanyNumber = companyNumber;
        }

        public String getRouteCode() {
            return mRouteCode;
        }

        public void setRouteCode(String routeCode) {
            mRouteCode = routeCode;
        }
    }
}
