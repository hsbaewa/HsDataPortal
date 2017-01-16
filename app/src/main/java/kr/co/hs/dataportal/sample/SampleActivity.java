package kr.co.hs.dataportal.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import kr.co.hs.app.HsActivity;
import kr.co.hs.dataportal.BusCompInfo;
import kr.co.hs.net.HsRestClient;
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
                List<BusCompInfo.Item> list;
                try {
                    info.request();
                    list = info.getItems();
                    Logger.d("a");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                Logger.d("a");
            }
        }).start();


    }
}
