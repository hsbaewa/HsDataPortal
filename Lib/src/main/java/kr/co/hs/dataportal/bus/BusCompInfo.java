package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-16, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal
 */

public class BusCompInfo<I extends BusCompInfo.Item> extends Api implements BusCompInfoConst{
    private int mNReqestPage = 0;

    private Item mCurrentItem = null;
    private List<Item> mItems;

    public BusCompInfo(String strAPIKey, int NReqestPage) {
        super(strAPIKey);
        mNReqestPage = NReqestPage;
        mItems = new ArrayList<>();
    }

    @Override
    public String getUrl() {
        String url = "http://openapitraffic.daejeon.go.kr/api/rest/buscompinfo/getBusCompInfo?serviceKey=%s&reqPage=%d";
        url = String.format(url, getApiKey(), mNReqestPage);
        return url;
    }

    public List<Item> getItems() {
        return mItems;
    }

    @Override
    public void startElement(String qName) {
        switch (qName){
            case ITEM_LIST:{
                mCurrentItem = new Item();
                break;
            }
        }
    }

    @Override
    public void endElement(String qName, String value) {
        switch (qName){
            case ITEM_LIST:{
                mItems.add(mCurrentItem);
                break;
            }
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

    public static final class Item extends Api.Item{
        private String mAddress;
        private String mCompanyCode;
        private String mCompanyName;
        private String mTel;

        public Item() {
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
