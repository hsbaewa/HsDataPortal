# HsDataPortal

[![](https://jitpack.io/v/hsbaewa/HsDataPortal.svg)](https://jitpack.io/#hsbaewa/HsDataPortal)

정부 공공 데이터 포털(http://www.data.go.kr)에서 대전 버스 정보 API를 참조하여 쉽게 사용할 수 있도록 제작된 라이브러리 입니다.

자세한 사항은 아래의 링크를 참고하세요.
http://www.data.go.kr/dataset/3034842/openapi.do



모든 API의 부모는 Api 클래스로 멤버는 아래와 같음

    mCurrentPage : 현재 페이지
    mHeaderCode : 결과 코드
    mHeaderMessage : 결과 메시지
    mItemCount : 전체 아이템 갯수
    mItemPageCount : 전체 페이지




##1. 정류소정보조회 서비스
<pre><code>
StationInfo stationInfo = new StationInfo("API 키", StationInfo.OPERATION_STATION_BY_STOP_ID /* 오퍼레이션 */, "8001378" /* 정류소 ID */);
stationInfo.request();  //요청
List<StationInfo.StationInfoItem> list = stationInfo.getItems();  //아이템 리스트
</code></pre>
#####1-1. 생성자 파라미터
    1. API 키
    2. Operation
        1. StationInfo.OPERATION_STATION_BY_STOP_ID : 정류소 ID 별 정류소 정보
        2. StationInfo.OPERATION_STATION_BY_UID : ARS-ID 별 정류소 정보
    3. ID(Operation에 따라 정류소 ID 가 될수도 있고, ARS-ID가 될수도 있음.)





##2. 버스 위치정보 조회 서비스
<pre><code>
BusPosInfo busPosInfo = new BusPosInfo("API 키", "30300001"  /* 노선 ID */);
busPosInfo.request();   //요청
List<BusPosInfo.BusPosInfoItem> list = busPosInfo.getItems();  //결과 리스트
</code></pre>
#####2-1. 생성자 파라미터
    1. API 키
    2. ID(Operation에 따라 정류소 ID 가 될수도 있고, ARS-ID가 될수도 있음.)



##3. 정류소별 도착정보 조회 서비스
<pre><code>
Arrive arrive = new Arrive("API 키", Arrive.OPERATION_ARRIVE_INFO_BY_STOP_ID, "8001378");
arrive.request();      //요청
List<Arrive.ArriveItem> list = arrive.getItems(); //결과 리스트
</code></pre>
#####3-1. 생성자 파라미터
    1. API 키
    2. Operation
            1. Arrive.OPERATION_ARRIVE_INFO_BY_STOP_ID : 정류소 ID 별 정류소 정보
            2. Arrive.OPERATION_ARRIVE_INFO_BY_UID : ARS-ID 별 정류소 정보
    3. ID(Operation에 따라 정류소 ID 가 될수도 있고, ARS-ID가 될수도 있음.)

##4. 차량등록정보 조회 서비스
<pre><code>
BusRegInfo busRegInfo = new BusRegInfo("API 키", 1 /* 페이지수 */);
busRegInfo.request();
List<BusRegInfo.BusRegInfoItem> list =  busRegInfo.getItems();
</code></pre>
#####4-1. 생성자 파라미터
    1. API 키
    2. 페이지수

##5. 운수회사 정보 조회 서비스
<pre><code>
BusCompInfo info = new BusCompInfo("API 키", 1 /* 페이지수 */);
info.request();
List<BusCompInfo.Item> items = info.getItems();
</code></pre>
#####5-1. 생성자 파라미터
    1. API 키
    2. 페이지수

##6. 노선정보조회 서비스
<pre><code>
BusRouteInfo<BusRouteInfo.RouteInfoItem> routeInfo = new BusRouteInfo("API 키",  BusRouteInfo.OPERATION_ROUTE_INFO_ALL, 2);
routeInfo.request();
List<BusRouteInfo.RouteInfoItem> list = routeInfo.getItems();
</code></pre>
#####6-1. 생성자 파라미터
    1. API 키
    2. Operation
        OPERATION_STATION_BY_ROUTE_ALL : 전체 노선별 경유 정류소 정보 조회
        OPERATION_STATION_BY_ROUTE : 노선별 경유 정류소 정보 조회
        OPERATION_ROUTE_INFO : 노선별 기본정보 조회
        OPERATION_ROUTE_INFO_ALL : 전체 노선 기본정보 조회
    3. 페이지수(integer) 이거나 노선ID(String)
