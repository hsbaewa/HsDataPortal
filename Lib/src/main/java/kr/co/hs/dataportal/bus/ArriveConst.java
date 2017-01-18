package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.ApiConst;

/**
 * Created by Bae on 2017-01-18.
 */

public interface ArriveConst extends ApiConst {

    String OPERATION_ARRIVE_INFO_BY_STOP_ID = "getArrInfoByStopID";
    String OPERATION_ARRIVE_INFO_BY_UID = "getArrInfoByUid";

    String BUS_NODE_ID = "BUS_NODE_ID";                         //정류소 아이디
    String BUS_STOP_ID = "BUS_STOP_ID";                         //정류소 아이디
    String CAR_REG_NO = "CAR_REG_NO";                       //차량번호
    String DESTINATION = "DESTINATION";                     //종점
    String EXTIME_MIN = "EXTIME_MIN";                       //도착 예정시간
    String EXTIME_SEC = "EXTIME_SEC";                       //도착 예정시간
    String INFO_OFFER_TM = "INFO_OFFER_TM";                 //정보 생성 시간
    String LAST_CAT = "LAST_CAT";                           //첫차 막차(1:첫차, 2:막차, 3:일반)
    String LAST_STOP_ID = "LAST_STOP_ID";                   //최근 통과 정류소
    String MSG_TP = "MSG_TP"                        ;       //메시지유형
    String ROUTE_CD = "ROUTE_CD";                           //노선ID
    String ROUTE_NO = "ROUTE_NO";                           //노선 번호
    String ROUTE_TP = "ROUTE_TP";                           //노선타입(1:급행, 2:간선, 3:지선, 4:외곽, 5:마을, 6:첨단)
    String STATUS_POS = "STATUS_POS";                       //잔여 정류장수
    String STOP_NAME = "STOP_NAME";                         //최근 통과 정류소 명칭
}
