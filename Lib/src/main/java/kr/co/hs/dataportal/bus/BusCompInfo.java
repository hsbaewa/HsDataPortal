package kr.co.hs.dataportal.bus;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-16, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal
 */

public class BusCompInfo extends Api<BusCompInfoItem, BusCompInfo> implements BusCompInfoConst{
    private int mNReqestPage = 0;

    private BusCompInfoItem mCurrentItem = null;
    private List<BusCompInfoItem> mItems;

    public BusCompInfo(String strAPIKey, int NReqestPage) {
        super(strAPIKey);
        mNReqestPage = NReqestPage;
        mItems = new ArrayList<>();
    }

    @Override
    public String getOperation() {
        return OPERATION_BUS_COMPANY_INFO;
    }

    @Override
    public String getUrl() {
        String url = "http://openapitraffic.daejeon.go.kr/api/rest/buscompinfo/%s?serviceKey=%s&reqPage=%d";
        url = String.format(url, getOperation(), getApiKey(), mNReqestPage);
        return url;
    }

    public List<BusCompInfoItem> getItems() {
        return mItems;
    }

    @Override
    public void startElement(String qName) {
        switch (qName){
            case ITEM_LIST:{
                mCurrentItem = new BusCompInfoItem();
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

}
