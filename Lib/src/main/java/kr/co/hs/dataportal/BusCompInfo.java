package kr.co.hs.dataportal;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import kr.co.hs.net.HsRestClient;
import kr.co.hs.net.HsSaxHandler;
import kr.co.hs.util.Logger;

/**
 * 생성된 시간 2017-01-16, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal
 */

public class BusCompInfo extends HsSaxHandler implements BusCompInfoConst{
    private String mStrAPIKey = null;
    private int mNReqestPage = 0;

    private Item mCurrentItem = null;
    private List<Item> mItems;

    public BusCompInfo(String strAPIKey, int NReqestPage) {
        mStrAPIKey = strAPIKey;
        mNReqestPage = NReqestPage;
        mItems = new ArrayList<>();
    }

    public BusCompInfo request() throws IOException, SAXException, ParserConfigurationException {
        String url = "http://openapitraffic.daejeon.go.kr/api/rest/buscompinfo/getBusCompInfo?serviceKey=%s&reqPage=%d";
        url = String.format(url, mStrAPIKey, mNReqestPage);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.parse(url , this);

        return this;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals(ITEM_LIST)){
            mCurrentItem = new Item();
        }
    }


    @Override
    public void doElement(String key, String value) {
        switch (key){
            case ADDRESS:{
                mCurrentItem.setAddress(value);
                break;
            }
            case COMPANY_CODE:{
                mCurrentItem.setCompanyCode(value);
                break;
            }
            case COMPANY_NAME:{
                mCurrentItem.setCompanyName(value);
                break;
            }
            case TELEPHONE_NUMBER:{
                mCurrentItem.setTel(value);
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals(ITEM_LIST)){
            mItems.add(mCurrentItem);
            mCurrentItem = null;
        }
    }

    public List<Item> getItems() {
        return mItems;
    }

    public static final class Item{
        private String mAddress;
        private String mCompanyCode;
        private String mCompanyName;
        private String mTel;

        public Item() {
        }

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

        public void setAddress(String address) {
            mAddress = address;
        }

        public void setCompanyCode(String companyCode) {
            mCompanyCode = companyCode;
        }

        public void setCompanyName(String companyName) {
            mCompanyName = companyName;
        }

        public void setTel(String tel) {
            mTel = tel;
        }
    }
}
