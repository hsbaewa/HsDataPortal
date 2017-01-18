package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.ApiConst;

/**
 * Created by Bae on 2017-01-18.
 */

public interface StationInfoConst extends ApiConst{
    String OPERATION_STATION_BY_UID = "getStationByUid";
    String OPERATION_STATION_BY_STOP_ID = "getStationByStopID";

    String ARO_BUSSTOP_ID = "ARO_BUSSTOP_ID";           //정류소 ARS ID
    String BUSSTOP_ENG_NM = "BUSSTOP_ENG_NM";           //정류소 영어이름
    String BUSSTOP_NM = "BUSSTOP_NM";                   //정류소 이름
    String BUS_NODE_ID = "BUS_NODE_ID";                 //정류소 ID
    String GPS_LATI = "GPS_LATI";                       //위도
    String GPS_LONG = "GPS_LONG";                       //경도
    String ROAD_NM = "ROAD_NM";                         //도로명
    String ROAD_NM_ADDR = "ROAD_NM_ADDR";               //도로명 주소
    String ROUTE_NO = "ROUTE_NO";                       //경유 노선 정보
}
