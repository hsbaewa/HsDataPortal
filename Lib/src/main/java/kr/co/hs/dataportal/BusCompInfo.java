package kr.co.hs.dataportal;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import kr.co.hs.net.HsRestClient;
import kr.co.hs.net.HsSaxHandler;

/**
 * 생성된 시간 2017-01-16, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal
 */

public class BusCompInfo extends HsSaxHandler implements BusCompInfoConst{
    private String mStrAPIKey = null;
    private int mNReqestPage = 0;

    public BusCompInfo(String strAPIKey, int NReqestPage) {
        mStrAPIKey = strAPIKey;
        mNReqestPage = NReqestPage;
    }

    public BusCompInfo request() throws IOException, SAXException, ParserConfigurationException {

        String url = "http://openapitraffic.daejeon.go.kr/api/rest/buscompinfo/getBusCompInfo?serviceKey=%s&reqPage=%d";
        url = String.format(url, mStrAPIKey, mNReqestPage);
        HsRestClient client = new HsRestClient();
        client.get(url, null, 10*1000, this);

        return this;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals(ITEM_LIST)){

        }
    }

    @Override
    public void doElement(String key, String value) {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }


    public static final class Item{
        private String mAddress;
        private String mCompanyCode;
        private String mCompanyName;
        private String mTel;

        public Item(String address, String companyCode, String companyName, String tel) {
            mAddress = address;
            mCompanyCode = companyCode;
            mCompanyName = companyName;
            mTel = tel;
        }

        public String getAddress() {
            return mAddress;
        }

        public String getCompanyCode() {
            return mCompanyCode;
        }

        public String getCompanyName() {
            return mCompanyName;
        }

        public String getTel() {
            return mTel;
        }
    }
}
