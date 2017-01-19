package kr.co.hs.dataportal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import kr.co.hs.database.HsSqlCreate;
import kr.co.hs.dataportal.bus.BusCompInfo;
import kr.co.hs.dataportal.bus.BusCompInfoConst;
import kr.co.hs.dataportal.bus.BusCompInfoItem;
import kr.co.hs.dataportal.bus.BusRegInfo;
import kr.co.hs.dataportal.bus.BusRegInfoConst;
import kr.co.hs.dataportal.bus.BusRegInfoItem;
import kr.co.hs.dataportal.bus.BusRouteInfo;
import kr.co.hs.dataportal.bus.BusRouteInfoConst;

/**
 * 생성된 시간 2017-01-19, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsDataPortal
 * 패키지명 : kr.co.hs.dataportal.database
 */

public class DBConnector {
    private static DBConnector instance = null;
    public static DBConnector getInstance(){
        if(instance == null)
            instance = new DBConnector();
        return instance;
    }


    public int clearBusCompInfoDB(Context context){
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            int count = database.delete(BusCompInfoConst.OPERATION_BUS_COMPANY_INFO, null, null);
            return count;
        }catch (Exception e){
            return -1;
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
    }



    public int initBusCompInfoDB(Context context, String apiKey) throws Exception {
        List<BusCompInfoItem> itemList = new ArrayList<>();
        BusCompInfo busCompInfo = new BusCompInfo(apiKey, 1);
        busCompInfo.request();
        String totalPage = busCompInfo.getItemPageCount();
        int nTotalPage = Integer.parseInt(totalPage);
        itemList.addAll(busCompInfo.getItems());
        for(int i=2;i<=nTotalPage;i++){
            busCompInfo = new BusCompInfo(apiKey, i);
            busCompInfo.request();
            itemList.addAll(busCompInfo.getItems());
        }
        return initBusCompInfoDB(context, itemList);
    }



    public int initBusCompInfoDB(Context context, List<BusCompInfoItem> list){
        clearBusCompInfoDB(context);

        int nCnt = 0;

        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            for(BusCompInfoItem item : list){
                ContentValues cv = new ContentValues();
                cv.put(BusCompInfoConst.ADDRESS, item.getAddress());
                cv.put(BusCompInfoConst.COMPANY_CODE, item.getCompanyCode());
                cv.put(BusCompInfoConst.COMPANY_NAME, item.getCompanyName());
                cv.put(BusCompInfoConst.TELEPHONE_NUMBER, item.getTel());
                try{
                    database.insertOrThrow(BusCompInfoConst.OPERATION_BUS_COMPANY_INFO, null, cv);
                    nCnt++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
        return nCnt;
    }



    public int clearBusStationByRouteDB(Context context){
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            int count = database.delete(BusRouteInfoConst.OPERATION_STATION_BY_ROUTE_ALL, null, null);
            return count;
        }catch (Exception e){
            return -1;
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
    }


    public int initBusStationByRouteDB(Context context, String apiKey) throws Exception {
        List<BusRouteInfo.StationByRouteItem> itemList = new ArrayList<>();

        BusRouteInfo busRouteInfo = new BusRouteInfo(apiKey, BusRouteInfo.OPERATION_STATION_BY_ROUTE_ALL, 1);
        busRouteInfo.request();
        String totalPage = busRouteInfo.getItemPageCount();
        int nTotalPage = Integer.parseInt(totalPage);
        itemList.addAll(busRouteInfo.getItems());
        for(int i=2;i<=nTotalPage;i++){
            busRouteInfo = new BusRouteInfo(apiKey, BusRouteInfo.OPERATION_STATION_BY_ROUTE_ALL, i);
            busRouteInfo.request();
            itemList.addAll(busRouteInfo.getItems());
        }
        return initBusStationByRouteDB(context, itemList);
    }
    public int initBusStationByRouteDB(Context context, List<BusRouteInfo.StationByRouteItem> list){
        clearBusCompInfoDB(context);

        int nCnt = 0;

        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            for(BusRouteInfo.StationByRouteItem item : list){
                ContentValues cv = new ContentValues();
                cv.put(BusRouteInfoConst.BUSSTOP_ENG_NAME, item.getBusStopEngName());
                cv.put(BusRouteInfoConst.BUSSTOP_NAME, item.getBusStopName());
                cv.put(BusRouteInfoConst.BUSSTOP_TYPE, item.getBusStopType());
                cv.put(BusRouteInfoConst.BUS_NODE_ID, item.getBusNodeID());
                cv.put(BusRouteInfoConst.BUS_STOP_ID, item.getBusStopID());
                cv.put(BusRouteInfoConst.GPS_LATITUDE, item.getGPSLatitude());
                cv.put(BusRouteInfoConst.GPS_LONGTITUDE, item.getGPSLongtitude());
                cv.put(BusRouteInfoConst.ROAD_NAME, item.getRoadName());
                cv.put(BusRouteInfoConst.ROAD_NAME_ADDRESS, item.getRoadNameAddress());
                cv.put(BusRouteInfoConst.ROUTE_CD, item.getRouteCode());
                cv.put(BusRouteInfoConst.TOTAL_DIST, item.getTotalDistance());
                try{
                    database.insertOrThrow(BusRouteInfoConst.OPERATION_STATION_BY_ROUTE_ALL, null, cv);
                    nCnt++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
        return nCnt;
    }


    public int clearRouteInfoDB(Context context){
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            int count = database.delete(BusRouteInfoConst.OPERATION_ROUTE_INFO_ALL, null, null);
            return count;
        }catch (Exception e){
            return -1;
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
    }


    public int initRouteInfoDB(Context context, String apiKey) throws Exception {
        List<BusRouteInfo.RouteInfoItem> itemList = new ArrayList<>();

        BusRouteInfo busRouteInfo = new BusRouteInfo(apiKey, BusRouteInfo.OPERATION_ROUTE_INFO_ALL, 1);
        busRouteInfo.request();
        String totalPage = busRouteInfo.getItemPageCount();
        int nTotalPage = Integer.parseInt(totalPage);
        itemList.addAll(busRouteInfo.getItems());
        for(int i=2;i<=nTotalPage;i++){
            busRouteInfo = new BusRouteInfo(apiKey, BusRouteInfo.OPERATION_ROUTE_INFO_ALL, i);
            busRouteInfo.request();
            itemList.addAll(busRouteInfo.getItems());
        }
        return initRouteInfoDB(context, itemList);
    }

    public int initRouteInfoDB(Context context, List<BusRouteInfo.RouteInfoItem> list){
        clearBusCompInfoDB(context);

        int nCnt = 0;

        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            for(BusRouteInfo.RouteInfoItem item : list){
                ContentValues cv = new ContentValues();
                cv.put(BusRouteInfoConst.ALLO_INTERVAL, item.getInterval());
                cv.put(BusRouteInfoConst.ALLO_INTERVAL_SAT, item.getIntervalSaturday());
                cv.put(BusRouteInfoConst.ALLO_INTERVAL_SUN, item.getIntervalSunday());
                cv.put(BusRouteInfoConst.BUSSTOP_COUNT, item.getBusStopCount());
                cv.put(BusRouteInfoConst.END_NODE_ID, item.getEndNodeID());
                cv.put(BusRouteInfoConst.END_STOP_ID, item.getEndStopID());
                cv.put(BusRouteInfoConst.ORIGIN_END, item.getOriginEnd());
                cv.put(BusRouteInfoConst.ORIGIN_END_SAT, item.getOriginEndSaturday());
                cv.put(BusRouteInfoConst.ORIGIN_END_SUN, item.getOriginEndSunday());
                cv.put(BusRouteInfoConst.ORIGIN_START, item.getOriginStart());
                cv.put(BusRouteInfoConst.ORIGIN_START_SAT, item.getOriginStartSaturday());
                cv.put(BusRouteInfoConst.ORIGIN_START_SUN, item.getOriginStartSunday());
                cv.put(BusRouteInfoConst.ROUTE_CD, item.getRouteCode());
                cv.put(BusRouteInfoConst.ROUTE_NO, item.getRouteNumber());
                cv.put(BusRouteInfoConst.ROUTE_TP, item.getRouteType());
                cv.put(BusRouteInfoConst.RUN_DIST_HALF, item.getRunDistHalf());
                cv.put(BusRouteInfoConst.RUN_TM, item.getRunTime());
                cv.put(BusRouteInfoConst.START_NODE_ID, item.getStartNodeID());
                cv.put(BusRouteInfoConst.START_STOP_ID, item.getStartStopID());
                cv.put(BusRouteInfoConst.TURN_END, item.getTurnEnd());
                cv.put(BusRouteInfoConst.TURN_END_SAT, item.getTurnEndSaturday());
                cv.put(BusRouteInfoConst.TURN_END_SUN, item.getTurnEndSunday());
                cv.put(BusRouteInfoConst.TURN_NODE_ID, item.getTurnNodeID());
                cv.put(BusRouteInfoConst.TURN_START, item.getTurnStart());
                cv.put(BusRouteInfoConst.TURN_START_SAT, item.getTurnStartSaturday());
                cv.put(BusRouteInfoConst.TURN_START_SUN, item.getTurnStartSunday());
                cv.put(BusRouteInfoConst.TURN_STOP_ID, item.getTurnStopID());
                try{
                    database.insertOrThrow(BusRouteInfoConst.OPERATION_ROUTE_INFO_ALL, null, cv);
                    nCnt++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
        return nCnt;
    }


    public int clearBusRegInfoDB(Context context){
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            int count = database.delete(BusRegInfoConst.OPERATION_BUS_REGISTINFO_ALL, null, null);
            return count;
        }catch (Exception e){
            return -1;
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
    }



    public int initBusRegInfoDB(Context context, String apiKey) throws Exception {
        List<BusRegInfoItem> itemList = new ArrayList<>();

        BusRegInfo busRegInfo = new BusRegInfo(apiKey, 1);
        busRegInfo.request();
        String totalPage = busRegInfo.getItemPageCount();
        int nTotalPage = Integer.parseInt(totalPage);
        itemList.addAll(busRegInfo.getItems());
        for(int i=2;i<=nTotalPage;i++){
            busRegInfo = new BusRegInfo(apiKey, i);
            busRegInfo.request();
            itemList.addAll(busRegInfo.getItems());
        }
        return initBusRegInfoDB(context, itemList);
    }

    public int initBusRegInfoDB(Context context, List<BusRegInfoItem> list){
        clearBusCompInfoDB(context);

        int nCnt = 0;

        DBHelper helper = new DBHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        try{
            for(BusRegInfoItem item : list){
                ContentValues cv = new ContentValues();
                cv.put(BusRegInfoConst.BUS_TYPE, item.getBusType());
                cv.put(BusRegInfoConst.CAR_REG_NO, item.getCarRegistNumber());
                cv.put(BusRegInfoConst.CHARACTER, item.getCharacter());
                cv.put(BusRegInfoConst.COMP_CD, item.getCompanyNumber());
                try{
                    database.insertOrThrow(BusRegInfoConst.OPERATION_BUS_REGISTINFO_ALL, null, cv);
                    nCnt++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null && database.isOpen())
                database.close();

            if(helper != null)
                helper.close();
        }
        return nCnt;
    }


    class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context) {
            super(context, "BusDatabase", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            HsSqlCreate create = new HsSqlCreate(
                    BusCompInfoConst.OPERATION_BUS_COMPANY_INFO,
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusCompInfoConst.ADDRESS),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusCompInfoConst.COMPANY_CODE),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusCompInfoConst.COMPANY_NAME),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusCompInfoConst.TELEPHONE_NUMBER)
                    );
            db.execSQL(create.toString());


            create = new HsSqlCreate(
                    BusRouteInfoConst.OPERATION_STATION_BY_ROUTE_ALL,
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUSSTOP_ENG_NAME),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUSSTOP_NAME),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUSSTOP_SEQUENCE),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUSSTOP_TYPE),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUS_NODE_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUS_STOP_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.GPS_LATITUDE),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.GPS_LONGTITUDE),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ROAD_NAME),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ROAD_NAME_ADDRESS),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ROUTE_CD),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TOTAL_DIST)
            );
            db.execSQL(create.toString());


            create = new HsSqlCreate(
                    BusRouteInfoConst.OPERATION_ROUTE_INFO_ALL,
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ALLO_INTERVAL),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ALLO_INTERVAL_SAT),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ALLO_INTERVAL_SUN),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.BUSSTOP_COUNT),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.END_NODE_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.END_STOP_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ORIGIN_END),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ORIGIN_END_SAT),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ORIGIN_END_SUN),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ORIGIN_START),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ORIGIN_START_SAT),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ORIGIN_START_SUN),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ROUTE_CD),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ROUTE_NO),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.ROUTE_TP),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.RUN_DIST_HALF),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.RUN_TM),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.START_NODE_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.START_STOP_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_END),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_END_SAT),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_END_SUN),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_NODE_ID),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_START),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_START_SAT),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_START_SUN),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRouteInfoConst.TURN_STOP_ID)
            );

            db.execSQL(create.toString());

            create = new HsSqlCreate(
                    BusRegInfoConst.OPERATION_BUS_REGISTINFO_ALL,
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRegInfoConst.BUS_TYPE),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRegInfoConst.CAR_REG_NO),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRegInfoConst.CHARACTER),
                    new HsSqlCreate.Column(HsSqlCreate.Column.TYPE_TEXT, BusRegInfoConst.COMP_CD)
            );

            db.execSQL(create.toString());
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

