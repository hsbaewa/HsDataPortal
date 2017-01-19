package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.bus
 */

public class BusPosInfoItem extends Api.Item {
    String mEventTime;
    String mBusNodeID;
    String mBusStopID;
    String mDir;
    String mEventCode;
    String mLatitude;
    String mLongtitude;
    String mRouteCode;
    String mStoreDate;
    String mTotalDistance;
    String mUDType;

    public String getEventTime() {
        return mEventTime;
    }

    public void setEventTime(String eventTime) {
        mEventTime = eventTime;
    }

    public String getBusNodeID() {
        return mBusNodeID;
    }

    public void setBusNodeID(String busNodeID) {
        mBusNodeID = busNodeID;
    }

    public String getBusStopID() {
        return mBusStopID;
    }

    public void setBusStopID(String busStopID) {
        mBusStopID = busStopID;
    }

    public String getDir() {
        return mDir;
    }

    public void setDir(String dir) {
        mDir = dir;
    }

    public String getEventCode() {
        return mEventCode;
    }

    public void setEventCode(String eventCode) {
        mEventCode = eventCode;
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

    public String getRouteCode() {
        return mRouteCode;
    }

    public void setRouteCode(String routeCode) {
        mRouteCode = routeCode;
    }

    public String getStoreDate() {
        return mStoreDate;
    }

    public void setStoreDate(String storeDate) {
        mStoreDate = storeDate;
    }

    public String getTotalDistance() {
        return mTotalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        mTotalDistance = totalDistance;
    }

    public String getUDType() {
        return mUDType;
    }

    public void setUDType(String UDType) {
        mUDType = UDType;
    }
}
