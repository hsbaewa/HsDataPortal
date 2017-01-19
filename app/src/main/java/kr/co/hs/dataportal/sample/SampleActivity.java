package kr.co.hs.dataportal.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import org.xml.sax.SAXException;

import java.util.List;


import kr.co.hs.app.HsActivity;
import kr.co.hs.dataportal.Api;
import kr.co.hs.dataportal.bus.StationInfo;
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

        mStationInfo = new StationInfo("QA1FldXgZSQN6c39GVaQMSbNFt1%2FKmzBbNCASfVTQpm1nILn8d4ws%2BnjKxQoyaYl8rW%2BKBw0hvPGRtRCJhA6Dg%3D%3D" , StationInfo.OPERATION_STATION_BY_STOP_ID, "8001378");
        mStationInfo.request(this);
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
