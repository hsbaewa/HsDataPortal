package kr.co.hs.dataportal.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import org.xml.sax.SAXException;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;


import kr.co.hs.app.HsActivity;
import kr.co.hs.dataportal.Api;
import kr.co.hs.dataportal.bus.BusCompInfo;
import kr.co.hs.dataportal.bus.BusCompInfoItem;
import kr.co.hs.dataportal.bus.StationInfo;
import kr.co.hs.dataportal.database.DBConnector;
import kr.co.hs.util.Logger;

/**
 * 생성된 시간 2017-01-16, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.sample
 */

public class SampleActivity extends HsActivity implements Api.OnStartDocumentListener, Api.OnEndDocumentListener, Api.OnWarningListener, Api.OnErrorListener{

    StationInfo mStationInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {


//                    InputStream inputStream = getApplicationContext().getAssets().open("BusCompInfo.json");
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    public void endDocument() {
        List<StationInfo> item = mStationInfo.getItems();
        Logger.d("a");
    }

    @Override
    public void startDocument() {
        Logger.d("a");
    }

    @Override
    public void error(Exception e) throws SAXException {
        Logger.d("a");
    }

    @Override
    public void warning(Exception e) throws SAXException {
        Logger.d("a");
    }
}
