package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.bus
 */

public class StationInfoItem extends Api.Item {
    String mBusStopID;
    String mBusStopEngName;
    String mBusStopName;
    String mBusNodeID;
    String mLatitude;
    String mLongtitude;
    String mRoadName;
    String mRoadNameAddress;
    String mRouteNumber;

    public String getBusStopID() {
        return mBusStopID;
    }

    public void setBusStopID(String busStopID) {
        mBusStopID = busStopID;
    }

    public String getBusStopEngName() {
        return mBusStopEngName;
    }

    public void setBusStopEngName(String busStopEngName) {
        mBusStopEngName = busStopEngName;
    }

    public String getBusStopName() {
        return mBusStopName;
    }

    public void setBusStopName(String busStopName) {
        mBusStopName = busStopName;
    }

    public String getBusNodeID() {
        return mBusNodeID;
    }

    public void setBusNodeID(String busNodeID) {
        mBusNodeID = busNodeID;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongtitude() {
        return mLongtitude;
    }

    public void setLongtitude(String longtitude) {
        mLongtitude = longtitude;
    }

    public String getRoadName() {
        return mRoadName;
    }

    public void setRoadName(String roadName) {
        mRoadName = roadName;
    }

    public String getRoadNameAddress() {
        return mRoadNameAddress;
    }

    public void setRoadNameAddress(String roadNameAddress) {
        mRoadNameAddress = roadNameAddress;
    }

    public String getRouteNumber() {
        return mRouteNumber;
    }

    public void setRouteNumber(String routeNumber) {
        mRouteNumber = routeNumber;
    }
}
