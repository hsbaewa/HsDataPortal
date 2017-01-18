package kr.co.hs.dataportal.bus;

/**
 * Created by Bae on 2017-01-17.
 */

public interface BusRouteInfoConst {
    String OPERATION_STATION_BY_ROUTE_ALL = "getStaionByRouteAll";
    String OPERATION_STATION_BY_ROUTE = "getStaionByRoute";
    String OPERATION_ROUTE_INFO = "getRouteInfo";
    String OPERATION_ROUTE_INFO_ALL = "getRouteInfoAll";

    String BUSSTOP_ENG_NAME = "BUSSTOP_ENG_NM";
    String BUSSTOP_NAME = "BUSSTOP_NM";
    String BUSSTOP_SEQUENCE = "BUSSTOP_SEQ";            //경유정류소순번
    String BUSSTOP_TYPE = "BUSSTOP_TP";                 //정류소 타임
    String BUSSTOP_TYPE_BEGIN_STATION = "1";            //기점
    String BUSSTOP_TYPE_FINAM_STATION = "2";            //종점
    String BUSSTOP_TYPE_NORMAL = "3";                   //일반
    String BUS_NODE_ID = "BUS_NODE_ID";                 //정류소 아이디
    String BUS_STOP_ID = "BUS_STOP_ID";                 //정류소 ARS-ID
    String GPS_LATITUDE = "GPS_LATI";
    String GPS_LONGTITUDE = "GPS_LONG";
    String ROAD_NAME = "ROAD_NM";                       //도로명
    String ROAD_NAME_ADDRESS = "ROAD_NM_ADDR";          //도로명주소
    String ROUTE_CODE = "ROUTE_CD";                     //노선id
    String TOTAL_DIST = "TOTAL_DIST";                   //누적거리


    String ALLO_INTERVAL = "ALLO_INTERVAL";             //배차간격
    String ALLO_INTERVAL_SAT = "ALLO_INTERVAL_SAT";     //휴일배차간격
    String ALLO_INTERVAL_SUN = "ALLO_INTERVAL_SUN";     //공휴일 배차간격
    String BUSSTOP_COUNT = "BUSSTOP_CNT";               //정류장 갯수
    String END_NODE_ID = "END_NODE_ID";                 //종점 정류소 아이디
    String END_STOP_ID = "END_STOP_ID";                  //종점 정류소 아이디
    String ORIGIN_END = "ORIGIN_END";                   //평일 기점 막차시간
    String ORIGIN_END_SAT = "ORIGIN_END_SAT";           //토요일 기점 막차시간
    String ORIGIN_END_SUN = "ORIGIN_END_SUN";           //일요일 종점 막차시간
    String ORIGIN_START = "ORIGIN_START";               //평일 기점 첫차시간
    String ORIGIN_START_SAT = "ORIGIN_START_SAT";       //토요일 기점 첫차시간
    String ORIGIN_START_SUN = "ORIGIN_START_SUN";       //일요일 기점 첫차시간
    String ROUTE_CD = "ROUTE_CD";                       //노선ID
    String ROUTE_NO = "ROUTE_NO";                       //노선 명칭
    String ROUTE_TP = "ROUTE_TP";                       //노선 타입(1 : 급행 , 2 : 간선, 3 : 지선, 4 : 외곽, 5 : 마을, 6 : 첨단)
    String RUN_DIST_HALF = "RUN_DIST_HALF";             //반환지점 거리(KM)
    String RUN_TM = "RUN_TM";                           //평균 운행 시간
    String START_NODE_ID = "START_NODE_ID";             //기점 정류소 ID
    String START_STOP_ID = "START_STOP_ID";             //기점 정류소 ID
    String TURN_END = "TURN_END";                       //평일 반환지점 막차시간
    String TURN_END_SAT = "TURN_END_SAT";               //토요일 "
    String TURN_END_SUN = "TURN_END_SUN";               //일요일 "
    String TURN_NODE_ID = "TURN_NODE_ID";               //반환 정류소ID
    String TURN_START = "TURN_START";                   //평일 반환지점 첫차시간
    String TURN_START_SAT = "TURN_START_SAT";           //토요일 "
    String TURN_START_SUN = "TURN_START_SUN";           //일요일 "
    String TURN_STOP_ID = "TURN_STOP_ID";               //반환정류소 ID
}
