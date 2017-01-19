package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-18.
 */

public class Arrive extends Api<ArriveItem, Arrive> implements ArriveConst{
    private String mOperation;
    private String mID;

    private List<ArriveItem> mItems;
    private ArriveItem mCurrentItem;

    public Arrive(String strAPIKey, String operation, String ID) {
        super(strAPIKey);
        mOperation = operation;
        mID = ID;
        mItems = new ArrayList<>();
    }

    @Override
    public String getOperation() {
        return mOperation;
    }

    public String getID() {
        return mID;
    }

    @Override
    public String getUrl() {
        String url = null;
        if(getOperation().equals(OPERATION_ARRIVE_INFO_BY_UID)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/arrive/%s?serviceKey=%s&arsId=%s";
            url = String.format(url, getOperation(), getApiKey(), getID());
        }else if(getOperation().equals(OPERATION_ARRIVE_INFO_BY_STOP_ID)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/arrive/%s?serviceKey=%s&BusStopID=%s";
            url = String.format(url, getOperation(), getApiKey(), getID());
        }
        return url;
    }

    @Override
    public List<ArriveItem> getItems() {
        return mItems;
    }

    @Override
    public void startElement(String tag) {
        switch (tag){
            case ITEM_LIST:{
                mCurrentItem = new ArriveItem();
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
            case BUS_NODE_ID:{
                mCurrentItem.setBusNodeID(value);
                break;
            }
            case BUS_STOP_ID:{
                mCurrentItem.setBusStopID(value);
                break;
            }
            case CAR_REG_NO:{
                mCurrentItem.setCarRegistID(value);
                break;
            }
            case DESTINATION:{
                mCurrentItem.setDestination(value);
                break;
            }
            case EXTIME_MIN:{
                mCurrentItem.setExtimeMinute(value);
                break;
            }
            case EXTIME_SEC:{
                mCurrentItem.setExtimeSecond(value);
                break;
            }
            case INFO_OFFER_TM:{
                mCurrentItem.setInformationOfferTime(value);
                break;
            }
            case LAST_CAT:{
                mCurrentItem.setLastCategory(value);
                break;
            }
            case LAST_STOP_ID:{
                mCurrentItem.setLastStopID(value);
                break;
            }
            case MSG_TP:{
                mCurrentItem.setMessageType(value);
                break;
            }
            case ROUTE_CD:{
                mCurrentItem.setRouteCode(value);
                break;
            }
            case ROUTE_NO:{
                mCurrentItem.setRouteNumber(value);
                break;
            }
            case ROUTE_TP:{
                mCurrentItem.setRouteType(value);
                break;
            }
            case STATUS_POS:{
                mCurrentItem.setStatusPosition(value);
                break;
            }
            case STOP_NAME:{
                mCurrentItem.setStopName(value);
                break;
            }
        }
    }
}
