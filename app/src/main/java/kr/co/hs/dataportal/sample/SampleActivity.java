package kr.co.hs.dataportal.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import java.util.List;


import kr.co.hs.app.HsActivity;
import kr.co.hs.dataportal.bus.BusCompInfo;
import kr.co.hs.dataportal.bus.BusRouteInfo;
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

//        http://openapitraffic.daejeon.go.kr/api/rest/buscompinfo/getBusCompInfo?serviceKey=QA1FldXgZSQN6c39GVaQMSbNFt1%2FKmzBbNCASfVTQpm1nILn8d4ws%2BnjKxQoyaYl8rW%2BKBw0hvPGRtRCJhA6Dg%3D%3D&reqPage=1

//        HsRestClient client = new HsRestClient();
//        client.get()

        new Thread(new Runnable() {
            @Override
            public void run() {
                BusCompInfo info = new BusCompInfo("QA1FldXgZSQN6c39GVaQMSbNFt1%2FKmzBbNCASfVTQpm1nILn8d4ws%2BnjKxQoyaYl8rW%2BKBw0hvPGRtRCJhA6Dg%3D%3D", 1);
                try {
                    info.request();
                    List<BusCompInfo.Item> items = info.getItems();
                    Log.d("a","a");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                BusRouteInfo<BusRouteInfo.RouteInfoItem> routeInfo = new BusRouteInfo(
                        "QA1FldXgZSQN6c39GVaQMSbNFt1%2FKmzBbNCASfVTQpm1nILn8d4ws%2BnjKxQoyaYl8rW%2BKBw0hvPGRtRCJhA6Dg%3D%3D",
                        BusRouteInfo.OPERATION_ROUTE_INFO_ALL,
                        2
                );
                try {
                    routeInfo.request();
                    List<BusRouteInfo.RouteInfoItem> list = routeInfo.getItems();
                    String count = routeInfo.getItemCount();
                    Logger.d("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                http://openapitraffic.daejeon.go.kr/api/rest/busRouteInfo/getStaionByRouteAll?serviceKey=QA1FldXgZSQN6c39GVaQMSbNFt1%2FKmzBbNCASfVTQpm1nILn8d4ws%2BnjKxQoyaYl8rW%2BKBw0hvPGRtRCJhA6Dg%3D%3D&reqPage=1
            }
        }).start();


    }
}
