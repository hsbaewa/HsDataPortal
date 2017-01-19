package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-18.
 */

public class BusPosInfo extends Api<BusPosInfoItem, BusPosInfo> implements BusPosInfoConst{

    private String mBusRouteCode;
    private List<BusPosInfoItem> mItems;
    private BusPosInfoItem mCurrentItem;

    public BusPosInfo(String strAPIKey, String busRouteId) {
        super(strAPIKey);
        mItems = new ArrayList<>();
        this.mBusRouteCode = busRouteId;
    }

    @Override
    public String getOperation() {
        return OPERATION_BUS_POS_BY_ROUTE_ID;
    }

    @Override
    public String getUrl() {
        String url = "http://openapitraffic.daejeon.go.kr/api/rest/busposinfo/%s?serviceKey=%s&busRouteId=%s";
        url = String.format(url, getOperation(), getApiKey(), getBusRouteCode());
        return url;
    }

    @Override
    public List<BusPosInfoItem> getItems() {
        return mItems;
    }

    @Override
    public void startElement(String tag) {
        switch (tag){
            case ITEM_LIST:{
                mCurrentItem = new BusPosInfoItem();
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
            case ARR_TIME:{
                mCurrentItem.setEventTime(value);
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
            case DIR:{
                mCurrentItem.setDir(value);
                break;
            }
            case EVT_CD:{
                mCurrentItem.setEventCode(value);
                break;
            }
            case GPS_LATI:{
                mCurrentItem.setLatitude(value);
                break;
            }
            case GPS_LONG:{
                mCurrentItem.setLongtitude(value);
                break;
            }
            case ROUTE_CD:{
                mCurrentItem.setRouteCode(value);
                break;
            }
            case STRE_DT:{
                mCurrentItem.setStoreDate(value);
                break;
            }
            case TOTAL_DIST:{
                mCurrentItem.setTotalDistance(value);
                break;
            }
            case ud_type:{
                mCurrentItem.setUDType(value);
                break;
            }
        }
    }

    public String getBusRouteCode() {
        return mBusRouteCode;
    }

}
