package kr.co.hs.dataportal.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import java.util.List;


import kr.co.hs.app.HsActivity;
import kr.co.hs.dataportal.bus.Arrive;
import kr.co.hs.dataportal.bus.BusCompInfo;
import kr.co.hs.dataportal.bus.BusPosInfo;
import kr.co.hs.dataportal.bus.BusRegInfo;
import kr.co.hs.dataportal.bus.BusRouteInfo;
import kr.co.hs.dataportal.bus.StationInfo;
import kr.co.hs.util.Logger;

/**
 * 생성된 시간 2017-01-16, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.sample
 */

public class SampleActivity extends HsActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                BusCompInfo info = new BusCompInfo("API 키", 1);
                try {
                    info.request();
                    List<BusCompInfo.Item> items = info.getItems();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                BusRouteInfo<BusRouteInfo.RouteInfoItem> routeInfo = new BusRouteInfo(
                        "API 키",
                        BusRouteInfo.OPERATION_ROUTE_INFO_ALL,
                        2
                );
                try {
                    routeInfo.request();
                    List<BusRouteInfo.RouteInfoItem> list = routeInfo.getItems();
                    String count = routeInfo.getItemCount();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                BusRegInfo busRegInfo = new BusRegInfo(
                        "API 키",
                        1
                );

                try {
                    busRegInfo.request();
                    List<BusRegInfo.BusRegInfoItem> list =  busRegInfo.getItems();
                    Logger.d("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                StationInfo stationInfo = new StationInfo(
                        "API 키",
                        StationInfo.OPERATION_STATION_BY_STOP_ID,
                        "8001378"
                );


                try {
                    stationInfo.request();
                    List<StationInfo.StationInfoItem> list = stationInfo.getItems();
                    Logger.d("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }


                BusPosInfo busPosInfo = new BusPosInfo(
                        "API 키",
                        "30300001"
                );

                try {
                    busPosInfo.request();
                    List<BusPosInfo.BusPosInfoItem> list = busPosInfo.getItems();
                    Logger.d("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Arrive arrive = new Arrive(
                        "API 키",
                        Arrive.OPERATION_ARRIVE_INFO_BY_STOP_ID,
                        "8001378"
                );

                try {
                    arrive.request();
                    List<Arrive.ArriveItem> list = arrive.getItems();
                    Logger.d("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
