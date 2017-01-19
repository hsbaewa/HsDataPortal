package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.bus
 */

public class RouteItem extends Api.Item {
    String mRouteCode;

    public String getRouteCode() {
        return mRouteCode;
    }

    public void setRouteCode(String routeCode) {
        mRouteCode = routeCode;
    }
}
