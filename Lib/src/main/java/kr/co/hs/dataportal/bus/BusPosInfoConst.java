package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.ApiConst;

/**
 * Created by Bae on 2017-01-18.
 */

public interface BusPosInfoConst extends ApiConst {

    String OPERATION_BUS_POS_BY_ROUTE_ID = "getBusPosByRtid";

    String ARR_TIME = "ARR_TIME";               //이벤트 발생 시각
    String BUS_NODE_ID = "BUS_NODE_ID";         //정류소 ID 7자리
    String BUS_STOP_ID = "BUS_STOP_ID";         //정류소 ID 5자리
    String DIR = "DIR";                         //방향성 (0:상행, 1:하행)
    String EVT_CD = "EVT_CD";                   //이벤트 유형(1:정주기정보(현재위치), 2:이벤트 정보(정류소,노드 검출)
    String GPS_LATI = "GPS_LATI";               //위도
    String GPS_LONG = "GPS_LONG";               //경도
    String ROUTE_CD = "ROUTE_CD";               //버스노선 일련번호
    String STRE_DT = "STRE_DT";                 //저장일자
    String TOTAL_DIST = "TOTAL_DIST";           //기점으로부터 누적 운행거리
    String ud_type = "ud_type";                 //상행/하행 (0:상행, 1:하행)
}
