package kr.co.hs.dataportal;

import android.os.AsyncTask;
import android.os.Build;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Created by Bae on 2017-01-17.
 */

public abstract class Api<I extends Api.Item, T extends Api> extends DefaultHandler
        implements
        ApiConst,
        ApiTask.OnDoInBackgroundListener<T>
{
    private String mApiKey = null;

    private String mCurrentPage;
    private String mHeaderCode;
    private String mHeaderMessage;
    private String mItemCount;
    private String mItemPageCount;

    private String mCurrentTag;
    private final StringBuffer mStringBuffer;

    private OnStartDocumentListener mOnStartDocumentListener;
    private OnEndDocumentListener mOnEndDocumentListener;
    private OnWarningListener mOnWarningListener;
    private OnErrorListener mOnErrorListener;

    private ApiTask<T> mTApiTask = null;

    public Api(String strAPIKey) {
        mApiKey = strAPIKey;
        mStringBuffer = new StringBuffer();
        mTApiTask = new ApiTask<>(this);
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        if(getOnStartDocumentListener() != null)
            getOnStartDocumentListener().startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        if(getOnEndDocumentListener() != null)
            getOnEndDocumentListener().endDocument();
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
        if(getOnWarningListener() != null){
            try {
                getOnWarningListener().warning(e);
            } catch (SAXException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
        if(getOnErrorListener() != null){
            try {
                getOnErrorListener().error(e);
            } catch (SAXException e1) {
                e1.printStackTrace();
            }
        }
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
                startElement(qName);
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        String value = getStringBuffer().toString();
        switch (qName){
            case CURRENT_PAGE:{
                mCurrentPage = value;
                break;
            }
            case HEADER_CODE:{
                mHeaderCode = value;
                break;
            }
            case HEADER_MESSAGE:{
                mHeaderMessage = value;
                break;
            }
            case ITEM_COUNT:{
                mItemCount = value;
                break;
            }
            case ITEM_PAGE_COUNT:{
                mItemPageCount = value;
                break;
            }
            default:{
                endElement(qName, value);
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

    public Api request() throws Exception{
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.parse(getUrl() , this);
        return this;
    }

    public Api request(OnEndDocumentListener endDocumentListener) {
        setOnEndDocumentListener(endDocumentListener);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mTApiTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (T)this);
        }else{
            mTApiTask.execute((T)this);
        }
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


    public abstract String getOperation();
    public abstract String getUrl();
    public abstract List<I> getItems();
    public abstract void startElement(String tag);
    public abstract void endElement(String tag, String value);


    public void setOnStartDocumentListener(OnStartDocumentListener onStartDocumentListener) {
        mOnStartDocumentListener = onStartDocumentListener;
    }

    public void setOnEndDocumentListener(OnEndDocumentListener onEndDocumentListener) {
        mOnEndDocumentListener = onEndDocumentListener;
    }

    public void setOnWarningListener(OnWarningListener onWarningListener) {
        mOnWarningListener = onWarningListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        mOnErrorListener = onErrorListener;
    }

    public OnStartDocumentListener getOnStartDocumentListener() {
        return mOnStartDocumentListener;
    }

    public OnEndDocumentListener getOnEndDocumentListener() {
        return mOnEndDocumentListener;
    }

    public OnWarningListener getOnWarningListener() {
        return mOnWarningListener;
    }

    public OnErrorListener getOnErrorListener() {
        return mOnErrorListener;
    }

    @Override
    public Void doInBackground(T... params) {
        try{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxParserFactory.newSAXParser();
            parser.parse(getUrl() , this);
        }catch (Exception e){
            if(getOnErrorListener() != null){
                try {
                    getOnErrorListener().error(e);
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }


    public static class Item{
    }


    public interface OnStartDocumentListener{
        void startDocument();
    }
    public interface OnEndDocumentListener{
        void endDocument();
    }
    public interface OnWarningListener{
        void warning(Exception e) throws SAXException;
    }
    public interface OnErrorListener{
        void error(Exception e) throws SAXException;
    }
}
