package kr.co.hs.dataportal.bus;

import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * Created by Bae on 2017-01-17.
 */

public class BusRouteInfo extends Api {

//    <BUSSTOP_ENG_NM>
//    Chungnam National University, College of Agricultural College Terminal
//            </BUSSTOP_ENG_NM>
//    <BUSSTOP_NM>충대농대종점</BUSSTOP_NM>
//    <BUSSTOP_SEQ>1</BUSSTOP_SEQ>
//    <BUSSTOP_TP>1</BUSSTOP_TP>
//    <BUS_NODE_ID>8002736</BUS_NODE_ID>
//    <BUS_STOP_ID>42740</BUS_STOP_ID>
//    <GPS_LATI>36.3661</GPS_LATI>
//    <GPS_LONG>127.351875</GPS_LONG>
//    <ROAD_NM></ROAD_NM>
//    <ROAD_NM_ADDR></ROAD_NM_ADDR>
//    <ROUTE_CD>30300001</ROUTE_CD>
//    <TOTAL_DIST>148</TOTAL_DIST>

    public BusRouteInfo(String strAPIKey) {
        super(strAPIKey);
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public List getItems() {
        return null;
    }

    @Override
    public void startElement(String tag) {

    }

    @Override
    public void endElement(String tag, String value) {

    }
}
