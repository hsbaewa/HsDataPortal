package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.ApiConst;

/**
 * Created by Bae on 2017-01-18.
 */

public interface BusRegInfoConst extends ApiConst{

    String OPERATION_BUS_REGISTINFO_BY_ROUTEID = "getBusRegInfoByRouteId";
    String OPERATION_BUS_REGISTINFO_ALL = "getBusRegInfoAll";

    String BUS_TYPE = "BUS_TYPE";               //버스 종류(0:정보없음, 1:일반, 2:저상)
    String CAR_REG_NO = "CAR_REG_NO";           //버스 번호판
    String CHARACTER = "CHARACTER";             //캐릭터 버스 여부(0:정보없음, 1:일반, 2:캐릭터)
    String COMP_CD = "COMP_CD";                 //운수회사코드
    String ROUTE_CD = "ROUTE_CD";               //노선 아이디

}
