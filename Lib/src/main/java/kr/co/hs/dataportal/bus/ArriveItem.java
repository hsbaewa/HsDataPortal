package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.bus
 */

public class ArriveItem extends Api.Item {
    String mBusNodeID;
    String mBusStopID;
    String mCarRegistID;
    String mDestination;
    String mExtimeMinute;
    String mExtimeSecond;
    String mInformationOfferTime;
    String mLastCategory;
    String mLastStopID;
    String mMessageType;
    String mRouteCode;
    String mRouteNumber;
    String mRouteType;
    String mStatusPosition;
    String mStopName;


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

    public String getCarRegistID() {
        return mCarRegistID;
    }

    public void setCarRegistID(String carRegistID) {
        mCarRegistID = carRegistID;
    }

    public String getDestination() {
        return mDestination;
    }

    public void setDestination(String destination) {
        mDestination = destination;
    }

    public String getExtimeMinute() {
        return mExtimeMinute;
    }

    public void setExtimeMinute(String extimeMinute) {
        mExtimeMinute = extimeMinute;
    }

    public String getExtimeSecond() {
        return mExtimeSecond;
    }

    public void setExtimeSecond(String extimeSecond) {
        mExtimeSecond = extimeSecond;
    }

    public String getInformationOfferTime() {
        return mInformationOfferTime;
    }

    public void setInformationOfferTime(String informationOfferTime) {
        mInformationOfferTime = informationOfferTime;
    }

    public String getLastCategory() {
        return mLastCategory;
    }

    public void setLastCategory(String lastCategory) {
        mLastCategory = lastCategory;
    }

    public String getLastStopID() {
        return mLastStopID;
    }

    public void setLastStopID(String lastStopID) {
        mLastStopID = lastStopID;
    }

    public String getMessageType() {
        return mMessageType;
    }

    public void setMessageType(String messageType) {
        mMessageType = messageType;
    }

    public String getRouteCode() {
        return mRouteCode;
    }

    public void setRouteCode(String routeCode) {
        mRouteCode = routeCode;
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

    public String getStatusPosition() {
        return mStatusPosition;
    }

    public void setStatusPosition(String statusPosition) {
        mStatusPosition = statusPosition;
    }

    public String getStopName() {
        return mStopName;
    }

    public void setStopName(String stopName) {
        mStopName = stopName;
    }
}
