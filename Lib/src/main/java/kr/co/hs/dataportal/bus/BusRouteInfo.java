package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-17.
 */

public class BusRouteInfo<T extends RouteItem> extends Api<T, BusRouteInfo> implements BusRouteInfoConst{

    private String mOperation;
    private int mReqPage;
    private String mID;
    private List<T> mItems;
    private RouteItem mCurrentItem;

    public BusRouteInfo(String strAPIKey, String operation, int reqPage) {
        super(strAPIKey);
        this.mOperation = operation;
        this.mReqPage = reqPage;
        this.mItems = new ArrayList<>();
    }

    public BusRouteInfo(String strAPIKey, String operation, String id) {
        super(strAPIKey);
        this.mOperation = operation;
        this.mID = id;
        this.mItems = new ArrayList<>();
    }

    @Override
    public String getUrl() {
        String url = null;
        if(getOperation().equals(OPERATION_ROUTE_INFO_ALL) || getOperation().equals(OPERATION_STATION_BY_ROUTE_ALL)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/busRouteInfo/%s?serviceKey=%s&reqPage=%d";
            url = String.format(url, getOperation(), getApiKey(), getReqPage());
        }else if(getOperation().equals(OPERATION_ROUTE_INFO) || getOperation().equals(OPERATION_STATION_BY_ROUTE)){
            url = "http://openapitraffic.daejeon.go.kr/api/rest/busRouteInfo/%s?serviceKey=%s&busRouteId=%s";
            url = String.format(url, getOperation(), getApiKey(), getID());
        }
        return url;
    }

    @Override
    public List<T> getItems() {
        return this.mItems;
    }

    @Override
    public void startElement(String tag) {
        switch (tag){
            case ITEM_LIST:{
                if(getOperation().equals(OPERATION_STATION_BY_ROUTE) || getOperation().equals(OPERATION_STATION_BY_ROUTE_ALL)){
                    mCurrentItem = new StationByRouteItem();
                }else if(getOperation().equals(OPERATION_ROUTE_INFO) || getOperation().equals(OPERATION_ROUTE_INFO_ALL)){
                    mCurrentItem = new RouteInfoItem();
                }
                break;
            }
        }
    }

    @Override
    public void endElement(String tag, String value) {
        switch (tag){
            case ITEM_LIST:{
                mItems.add((T) mCurrentItem);
                break;
            }
            case BUSSTOP_ENG_NAME:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setBusStopEngName(value);
                }
                break;
            }
            case BUSSTOP_NAME:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setBusStopName(value);
                }
                break;
            }
            case BUSSTOP_SEQUENCE:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setBusStopSequence(value);
                }
                break;
            }
            case BUSSTOP_TYPE:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setBusStopType(value);
                }
                break;
            }
            case BUS_NODE_ID:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setBusNodeID(value);
                }
                break;
            }
            case BUS_STOP_ID:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setBusStopID(value);
                }
                break;
            }
            case GPS_LATITUDE:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setGPSLatitude(value);
                }
                break;
            }
            case GPS_LONGTITUDE:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setGPSLongtitude(value);
                }
                break;
            }
            case ROAD_NAME:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setRoadName(value);
                }
                break;
            }
            case ROAD_NAME_ADDRESS:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setRoadNameAddress(value);
                }
                break;
            }
            case ROUTE_CD:{
                mCurrentItem.setRouteCode(value);
                break;
            }
            case TOTAL_DIST:{
                if(mCurrentItem instanceof StationByRouteItem){
                    ((StationByRouteItem) mCurrentItem).setTotalDistance(value);
                }
                break;
            }


            case ALLO_INTERVAL:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setInterval(value);
                }
                break;
            }
            case ALLO_INTERVAL_SAT:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setIntervalSaturday(value);
                }
                break;
            }
            case ALLO_INTERVAL_SUN:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setIntervalSunday(value);
                }
                break;
            }
            case BUSSTOP_COUNT:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setBusStopCount(value);
                }
                break;
            }
            case END_NODE_ID:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setEndNodeID(value);
                }
                break;
            }
            case END_STOP_ID:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setEndStopID(value);
                }
                break;
            }
            case ORIGIN_END:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setOriginEnd(value);
                }
                break;
            }
            case ORIGIN_END_SAT:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setOriginEndSaturday(value);
                }
                break;
            }
            case ORIGIN_END_SUN:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setOriginEndSunday(value);
                }
                break;
            }
            case ORIGIN_START:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setOriginStart(value);
                }
                break;
            }
            case ORIGIN_START_SAT:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setOriginStartSaturday(value);
                }
                break;
            }
            case ORIGIN_START_SUN:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setOriginStartSunday(value);
                }
                break;
            }
            case ROUTE_NO:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setRouteNumber(value);
                }
                break;
            }
            case ROUTE_TP:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setRouteType(value);
                }
                break;
            }
            case RUN_DIST_HALF:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setRunDistHalf(value);
                }
                break;
            }
            case RUN_TM:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setRunTime(value);
                }
                break;
            }
            case START_NODE_ID:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setStartNodeID(value);
                }
                break;
            }
            case START_STOP_ID:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setStartStopID(value);
                }
                break;
            }
            case TURN_END:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnEnd(value);
                }
                break;
            }
            case TURN_END_SAT:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnEndSaturday(value);
                }
                break;
            }
            case TURN_END_SUN:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnEndSunday(value);
                }
                break;
            }
            case TURN_NODE_ID:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnNodeID(value);
                }
                break;
            }
            case TURN_START:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnStart(value);
                }
                break;
            }
            case TURN_START_SAT:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnStartSaturday(value);
                }
                break;
            }
            case TURN_START_SUN:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnStartSunday(value);
                }
                break;
            }
            case TURN_STOP_ID:{
                if(mCurrentItem instanceof RouteInfoItem){
                    ((RouteInfoItem) mCurrentItem).setTurnStopID(value);
                }
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

    public String getID() {
        return mID;
    }

    public static final class StationByRouteItem extends RouteItem{
        String mBusStopEngName;
        String mBusStopName;
        String mBusStopSequence;
        String mBusStopType;
        String mBusNodeID;
        String mBusStopID;
        String mGPSLatitude;
        String mGPSLongtitude;
        String mRoadName;
        String mRoadNameAddress;
        String mTotalDistance;

        public String getBusStopSequence() {
            return mBusStopSequence;
        }

        public void setBusStopSequence(String busStopSequence) {
            mBusStopSequence = busStopSequence;
        }

        public void setBusStopEngName(String busStopEngName) {
            mBusStopEngName = busStopEngName;
        }

        public void setBusStopName(String busStopName) {
            mBusStopName = busStopName;
        }

        public void setBusStopType(String busStopType) {
            mBusStopType = busStopType;
        }

        public void setBusNodeID(String busNodeID) {
            mBusNodeID = busNodeID;
        }

        public void setBusStopID(String busStopID) {
            mBusStopID = busStopID;
        }

        public void setGPSLatitude(String GPSLatitude) {
            mGPSLatitude = GPSLatitude;
        }

        public void setGPSLongtitude(String GPSLongtitude) {
            mGPSLongtitude = GPSLongtitude;
        }

        public void setRoadName(String roadName) {
            mRoadName = roadName;
        }

        public void setRoadNameAddress(String roadNameAddress) {
            mRoadNameAddress = roadNameAddress;
        }

        public void setTotalDistance(String totalDistance) {
            mTotalDistance = totalDistance;
        }

        public String getBusStopEngName() {
            return mBusStopEngName;
        }

        public String getBusStopName() {
            return mBusStopName;
        }

        public String getBusStopType() {
            return mBusStopType;
        }

        public String getBusNodeID() {
            return mBusNodeID;
        }

        public String getBusStopID() {
            return mBusStopID;
        }

        public String getGPSLatitude() {
            return mGPSLatitude;
        }

        public String getGPSLongtitude() {
            return mGPSLongtitude;
        }

        public String getRoadName() {
            return mRoadName;
        }

        public String getRoadNameAddress() {
            return mRoadNameAddress;
        }

        public String getTotalDistance() {
            return mTotalDistance;
        }
    }


    public static final class RouteInfoItem extends RouteItem{
        String mInterval;
        String mIntervalSaturday;
        String mIntervalSunday;
        String mBusStopCount;
        String mEndNodeID;
        String mEndStopID;
        String mOriginEnd;
        String mOriginEndSaturday;
        String mOriginEndSunday;
        String mOriginStart;
        String mOriginStartSaturday;
        String mOriginStartSunday;
        String mRouteNumber;
        String mRouteType;
        String mRunDistHalf;
        String mRunTime;
        String mStartNodeID;
        String mStartStopID;
        String mTurnEnd;
        String mTurnEndSaturday;
        String mTurnEndSunday;
        String mTurnNodeID;
        String mTurnStart;
        String mTurnStartSaturday;
        String mTurnStartSunday;
        String mTurnStopID;

        public String getInterval() {
            return mInterval;
        }

        public void setInterval(String interval) {
            mInterval = interval;
        }

        public String getIntervalSaturday() {
            return mIntervalSaturday;
        }

        public void setIntervalSaturday(String intervalSaturday) {
            mIntervalSaturday = intervalSaturday;
        }

        public String getIntervalSunday() {
            return mIntervalSunday;
        }

        public void setIntervalSunday(String intervalSunday) {
            mIntervalSunday = intervalSunday;
        }

        public String getBusStopCount() {
            return mBusStopCount;
        }

        public void setBusStopCount(String busStopCount) {
            mBusStopCount = busStopCount;
        }

        public String getEndNodeID() {
            return mEndNodeID;
        }

        public void setEndNodeID(String endNodeID) {
            mEndNodeID = endNodeID;
        }

        public String getEndStopID() {
            return mEndStopID;
        }

        public void setEndStopID(String endStopID) {
            mEndStopID = endStopID;
        }

        public String getOriginEnd() {
            return mOriginEnd;
        }

        public void setOriginEnd(String originEnd) {
            mOriginEnd = originEnd;
        }

        public String getOriginEndSaturday() {
            return mOriginEndSaturday;
        }

        public void setOriginEndSaturday(String originEndSaturday) {
            mOriginEndSaturday = originEndSaturday;
        }

        public String getOriginEndSunday() {
            return mOriginEndSunday;
        }

        public void setOriginEndSunday(String originEndSunday) {
            mOriginEndSunday = originEndSunday;
        }

        public String getOriginStart() {
            return mOriginStart;
        }

        public void setOriginStart(String originStart) {
            mOriginStart = originStart;
        }

        public String getOriginStartSaturday() {
            return mOriginStartSaturday;
        }

        public void setOriginStartSaturday(String originStartSaturday) {
            mOriginStartSaturday = originStartSaturday;
        }

        public String getOriginStartSunday() {
            return mOriginStartSunday;
        }

        public void setOriginStartSunday(String originStartSunday) {
            mOriginStartSunday = originStartSunday;
        }

        public String getRouteNumber() {
            return mRouteNumber;
        }

        public void setRouteNumber(String routeNumber) {
            mRouteNumber = routeNumber;
        }

        public String getRouteType() {
            return mRouteType;
        }

        public void setRouteType(String routeType) {
            mRouteType = routeType;
        }

        public String getRunDistHalf() {
            return mRunDistHalf;
        }

        public void setRunDistHalf(String runDistHalf) {
            mRunDistHalf = runDistHalf;
        }

        public String getRunTime() {
            return mRunTime;
        }

        public void setRunTime(String runTime) {
            mRunTime = runTime;
        }

        public String getStartNodeID() {
            return mStartNodeID;
        }

        public void setStartNodeID(String startNodeID) {
            mStartNodeID = startNodeID;
        }

        public String getStartStopID() {
            return mStartStopID;
        }

        public void setStartStopID(String startStopID) {
            mStartStopID = startStopID;
        }

        public String getTurnEnd() {
            return mTurnEnd;
        }

        public void setTurnEnd(String turnEnd) {
            mTurnEnd = turnEnd;
        }

        public String getTurnEndSaturday() {
            return mTurnEndSaturday;
        }

        public void setTurnEndSaturday(String turnEndSaturday) {
            mTurnEndSaturday = turnEndSaturday;
        }

        public String getTurnEndSunday() {
            return mTurnEndSunday;
        }

        public void setTurnEndSunday(String turnEndSunday) {
            mTurnEndSunday = turnEndSunday;
        }

        public String getTurnNodeID() {
            return mTurnNodeID;
        }

        public void setTurnNodeID(String turnNodeID) {
            mTurnNodeID = turnNodeID;
        }

        public String getTurnStart() {
            return mTurnStart;
        }

        public void setTurnStart(String turnStart) {
            mTurnStart = turnStart;
        }

        public String getTurnStartSaturday() {
            return mTurnStartSaturday;
        }

        public void setTurnStartSaturday(String turnStartSaturday) {
            mTurnStartSaturday = turnStartSaturday;
        }

        public String getTurnStartSunday() {
            return mTurnStartSunday;
        }

        public void setTurnStartSunday(String turnStartSunday) {
            mTurnStartSunday = turnStartSunday;
        }

        public String getTurnStopID() {
            return mTurnStopID;
        }

        public void setTurnStopID(String turnStopID) {
            mTurnStopID = turnStopID;
        }
    }
}
