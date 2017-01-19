package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-18.
 */

public class StationInfo extends Api<StationInfoItem, StationInfo> implements StationInfoConst{
    private String mOperation;
    private String mARSID;
    private String mNodeID;

    private StationInfoItem mCurrentItem;
    private List<StationInfoItem> mItems;

     public StationInfo(String strAPIKey, String operation, String id) {
        super(strAPIKey);
         mItems = new ArrayList<>();
        this.mOperation = operation;
        switch (mOperation){
            case OPERATION_STATION_BY_STOP_ID:{
                this.mNodeID = id;
                break;
            }
            case OPERATION_STATION_BY_UID:{
                this.mARSID = id;
                break;
            }
        }
    }

    @Override
    public String getUrl() {
        String url = null;
        if(getOperation().equals(OPERATION_STATION_BY_STOP_ID)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/stationinfo/%s?serviceKey=%s&BusStopID=%s";
            url = String.format(url, getOperation(), getApiKey(), getNodeID());
        }else if(getOperation().equals(OPERATION_STATION_BY_UID)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/stationinfo/%s?serviceKey=%s&arsId=%s";
            url = String.format(url, getOperation(), getApiKey(), getARSID());
        }
        return url;
    }

    @Override
    public List getItems() {
        return mItems;
    }

    @Override
    public void startElement(String tag) {
        switch (tag){
            case ITEM_LIST:{
                mCurrentItem = new StationInfoItem();
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
            case ARO_BUSSTOP_ID:{
                mCurrentItem.setBusStopID(value);
                break;
            }
            case BUSSTOP_ENG_NM:{
                mCurrentItem.setBusStopEngName(value);
                break;
            }
            case BUSSTOP_NM:{
                mCurrentItem.setBusStopName(value);
                break;
            }
            case BUS_NODE_ID:{
                mCurrentItem.setBusNodeID(value);
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
            case ROAD_NM:{
                mCurrentItem.setRoadName(value);
                break;
            }
            case ROAD_NM_ADDR:{
                mCurrentItem.setRoadNameAddress(value);
                break;
            }
            case ROUTE_NO:{
                mCurrentItem.setRouteNumber(value);
                break;
            }
        }
    }

    public String getOperation() {
        return mOperation;
    }

    public String getARSID() {
        return mARSID;
    }

    public String getNodeID() {
        return mNodeID;
    }

}
