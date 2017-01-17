package kr.co.hs.dataportal;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Created by Bae on 2017-01-17.
 */

public abstract class Api<I extends Api.Item> extends DefaultHandler implements ApiConst {
    private String mApiKey = null;

    private String mCurrentPage;
    private String mHeaderCode;
    private String mHeaderMessage;
    private String mItemCount;
    private String mItemPageCount;

    private String mCurrentTag;
    private final StringBuffer mStringBuffer;

    public Api(String strAPIKey) {
        mApiKey = strAPIKey;
        mStringBuffer = new StringBuffer();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        mCurrentTag = qName;
        mStringBuffer.setLength(0);
        switch (qName){
            case CURRENT_PAGE:{
                break;
            }
            case HEADER_CODE:{
                break;
            }
            case HEADER_MESSAGE:{
                break;
            }
            case ITEM_COUNT:{
                break;
            }
            case ITEM_PAGE_COUNT:{
                break;
            }
            default:{
                startElement(getCurrentTag());
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        switch (qName){
            case CURRENT_PAGE:{
                mCurrentPage = getStringBuffer().toString();
                break;
            }
            case HEADER_CODE:{
                mHeaderCode = getStringBuffer().toString();
                break;
            }
            case HEADER_MESSAGE:{
                mHeaderMessage = getStringBuffer().toString();
                break;
            }
            case ITEM_COUNT:{
                mItemCount = getStringBuffer().toString();
                break;
            }
            case ITEM_PAGE_COUNT:{
                mItemPageCount = getStringBuffer().toString();
                break;
            }
            default:{
                endElement(qName, getStringBuffer().toString());
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        getStringBuffer().append(ch, start, length);
    }

    public StringBuffer getStringBuffer() {
        return mStringBuffer;
    }

    public String getCurrentTag() {
        return mCurrentTag;
    }

    public Api request() throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.parse(getUrl() , this);
        return this;
    }

    public String getCurrentPage() {
        return mCurrentPage;
    }

    public String getHeaderCode() {
        return mHeaderCode;
    }

    public String getHeaderMessage() {
        return mHeaderMessage;
    }

    public String getItemCount() {
        return mItemCount;
    }

    public String getItemPageCount() {
        return mItemPageCount;
    }

    public String getApiKey() {
        return mApiKey;
    }


    public abstract String getUrl();
    public abstract List<I> getItems();
    public abstract void startElement(String tag);
    public abstract void endElement(String tag, String value);


    public static class Item{

    }
}
