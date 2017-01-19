package kr.co.hs.dataportal;

import android.os.AsyncTask;


/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal
 */

public class ApiTask<T extends Api> extends AsyncTask<T, Void, Void> {
    private OnDoInBackgroundListener<T> mOnDoInBackgroundListener;


    public ApiTask(OnDoInBackgroundListener<T> onDoInBackgroundListener) {
        mOnDoInBackgroundListener = onDoInBackgroundListener;
    }

    @Override
    protected Void doInBackground(T... params) {
        if(mOnDoInBackgroundListener != null){
            return mOnDoInBackgroundListener.doInBackground(params);
        }
        return null;
    }



    public interface OnDoInBackgroundListener<T extends Api>{
        Void doInBackground(T... params);
    }
}
