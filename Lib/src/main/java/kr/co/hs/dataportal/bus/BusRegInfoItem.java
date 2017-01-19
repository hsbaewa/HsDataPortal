package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.bus
 */

public class BusRegInfoItem extends Api.Item {
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
