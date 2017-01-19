package kr.co.hs.dataportal.bus;

import kr.co.hs.dataportal.Api;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.bus
 */

public class BusCompInfoItem extends Api.Item {
    private String mAddress;
    private String mCompanyCode;
    private String mCompanyName;
    private String mTel;

    public BusCompInfoItem() {
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
