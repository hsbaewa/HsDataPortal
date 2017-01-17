package kr.co.hs.dataportal.bus;

/**
 * Created by Bae on 2017-01-17.
 */

public interface BusRouteInfoConst {
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

//    <END_NODE_ID>8002737</END_NODE_ID>
//    <END_STOP_ID>42750</END_STOP_ID>
//    <ORIGIN_END>2230</ORIGIN_END>
//    <ORIGIN_END_SAT>2230</ORIGIN_END_SAT>
//    <ORIGIN_END_SUN>2230</ORIGIN_END_SUN>
//    <ORIGIN_START>0630</ORIGIN_START>
//    <ORIGIN_START_SAT>0630</ORIGIN_START_SAT>
//    <ORIGIN_START_SUN>0630</ORIGIN_START_SUN>
//    <ROUTE_CD>30300001</ROUTE_CD>
//    <ROUTE_NO>1</ROUTE_NO>
//    <ROUTE_TP>5</ROUTE_TP>
//    <RUN_DIST_HALF>23.9555</RUN_DIST_HALF>
//    <RUN_TM>70</RUN_TM>
//    <START_NODE_ID>8002736</START_NODE_ID>
//    <START_STOP_ID>42740</START_STOP_ID>
//    <TURN_END>2205</TURN_END>
//    <TURN_END_SAT>2205</TURN_END_SAT>
//    <TURN_END_SUN>2230</TURN_END_SUN>
//    <TURN_NODE_ID>8007228</TURN_NODE_ID>
//    <TURN_START>0630</TURN_START>
//    <TURN_START_SAT>0630</TURN_START_SAT>
//    <TURN_START_SUN>0630</TURN_START_SUN>
//    <TURN_STOP_ID>82370</TURN_STOP_ID>

}
