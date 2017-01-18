package kr.co.hs.dataportal.bus;

import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-17.
 */

public class BusRouteInfo extends Api implements BusRouteInfoConst{

    private String mOperation;
    private int mReqPage;

    public BusRouteInfo(String strAPIKey, String operation, int reqPage) {
        super(strAPIKey);
        this.mOperation = operation;
        this.mReqPage = reqPage;
    }

    @Override
    public String getUrl() {
        String url = "http://openapitraffic.daejeon.go.kr/api/rest/busRouteInfo/%s?serviceKey=%s&reqPage=%d";
        url = String.format(url, getOperation(), getApiKey(), getReqPage());
        return url;
    }

    @Override
    public List getItems() {
        return null;
    }

    @Override
    public void startElement(String tag) {

    }

    @Override
    public void endElement(String tag, String value) {

    }

    public String getOperation() {
        return mOperation;
    }

    public int getReqPage() {
        return mReqPage;
    }






    public static class RouteItem extends Item{

    }

    public static final class StationByRouteItem extends RouteItem{
        String mBusStopEngName;
        String mBusStopName;
        String mBusStopType;
        String mBusNodeID;
        String mBusStopID;
        String mGPSLatitude;
        String mGPSLongtitude;
        String mRoadName;
        String mRoadNameAddress;
        String mRouteCode;
        String mTotalDistance;
    }

    public static final class RouteInfoItem extends RouteItem{

    }
}
