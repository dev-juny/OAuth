0. OAuth 2.0
	Naver 회원탈퇴 : https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=CLIENT_ID&client_secret=CLIENT_SECRET&access_token=ACCESS_TOKEN
					https://developers.naver.com/docs/login/devguide/devguide.md#5-3-%EB%84%A4%EC%9D%B4%EB%B2%84-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%97%B0%EB%8F%99-%ED%95%B4%EC%A0%9C

1. 앱버전 관리
	버전 관리 방법
		- 최소 구동 버전
			최소 구동 버전은 앱을 사용하기 위한 최소버전
			최소 구동 버전보다 낮으면 앱을 사용할 수 없기 때문에 앱 진입과 동시에 강제 업데이트 안내가 나오고, 업데이트하지 않는다면 앱을 빠져나가게 만든다.
		
			사용이유:
				앱의 최소 구동 SDK 버전을 높히는 경우: 특정 OS가 앱을 지원하지 않을 수 있기 때문
				치명적인 버그가 있는 경우: 중요도가 높은 기능이 오동작하는 경우, 서비스의 BM에 치명적이거나 홈화면 같이 매우 빈번하게 사용되는 경우에 해당된다.
				운영/정책의 변경: 앱 운영 정책이 크게 변경될 때
				브레이킹 체인지: 앱이 새단장을 한다거나, 야심작을 출시할 때
		
			※ 앱 강제 업데이트는 사용자 경험을 매우 저하시키고, 이탈률을 높히므로 가급적 사용하면 안되지만 위와 같은 이유들이라면 울며 겨자먹기로 진행하는 경우가 많음
		
		- 권장 구동 버전
			권장 구동 버전은 현재도 이용하는데 문제는 없지만 가능하면 최신 버전으로 오라고 권고하는 버전
	
	OS별 버전 업데이트 방법
	
	안드로이드
		안드로이드 스튜디오에서 build.gradle 에 versionCode, versionName으로 버전관리
		
		versionCode
		양의 정수이며, 내부 버전 번호로 사용된다. 이 번호는 한 버전이 다른 버전보다 최신인지 여부를 판단하는 데만 사용되며, 번호가 높을수록 최신 버전이다. 
		사용자에게 표시되는 버전 번호가 아니다. 사용자에게 표시되는 번호는 아래에 나와 있는 versionName 설정으로 지정된다.
		
		versionName
		사용자에게 표시되는 버전 번호로 사용되는 문자열이다. 
		이 설정은 원시 문자열이나 문자열 리소스의 참조로 지정할 수 있다. 
		값은 문자열로서, <major>.<minor>.<point> 문자열이나 다른 유형의 절대 또는 상대 버전 식별자로 앱 버전을 설명할 수 있다. versionName은 사용자에게 표시하는 것 이외에 다른 용도는 없다.
		
		만약 중요한 업데이트면 versionCode를 이전 versionCode에 비해 5이상 증가시키고 덜 중요한 업데이트면 5미만으로 증가시킨다는 규칙을 정해놓는다면, 
		앱을 실행시킬 때마다 기존 설치되어있는 앱의 버전의 versionCode와 (업데이트가 있을 시)앱 스토어의 
		새로운 버전의 versionCode를 비교해 5이상 차이가 나면, 즉시 업데이트를 실행
	
		업데이트를 위한 참고자료
			1. https://developer.android.com/guide/playcore/in-app-updates/kotlin-java?hl=ko
			2. https://cording-cossk3.tistory.com/296
			3. https://blog.kmshack.kr/AppUpdateManager/
			
	
	IOS		
		xcode에 버전 Update 후 Appstore 배포
		swift + firebase를 통해서 버전관리 - 강제업데이트, 권장업데이트 Alert 가능
		
		업데이트를 위한 참고자료
			1. https://monibu1548.github.io/2018/05/19/remote-config-forced-update/
			2. https://world-of-larooly.tistory.com/15
	
	결론
		안드로이드 도구, 애플 도구를 통해 버전에 대한 처리가 가능하며, 구글 스토어, 애플 스토어에 출시가 된 경우 
		버전에 대한 처리 백엔드에서 할 필요 없음
	

2. 주소API 
	신청방법: https://business.juso.go.kr/addrlink/openApi/apiReqst.do
	체험: https://business.juso.go.kr/addrlink/openApi/apiExprn.do
	
	원비즈 주소: 검색 API
	개인계정 API 신청 -> API URL, Key 관리 프로퍼티 -> Java단에서 구현 
	request: 현재페이지, 페이지수, 결과물 타입, API key, 키워드
	응답값 : json
	
	자세한내용 : https://business.juso.go.kr/addrlink/openApi/searchApi.do
	
	일일최대
	juso.go.kr: 1일평균 약 1.5~2만건 호출의 경우는 문제가 없어보이나 시스템 구축 후 일정기간 모니터링하시길 권고 드립니다.
	kakao : 일별 API 사용 최대 한도 - 최대값: 500,000,000 글자 수(기본값) 
	        월별 한도	월별 API 사용 최대 한도 - 최대값: 15,000,000,000 글자 수(기본값)  
 
 
3. 경찰서 우체통 API
	경찰서API : https://www.data.go.kr/data/15054711/fileData.do
	신청방법: 휴대폰 인증 후 key 발급
	return : json
	    {
		  "X좌표": "128.9067625",
		  "Y좌표": "37.7687",
		  "서": "강릉경찰서",
		  "주소": "강릉시 포남동 1113",
		  "지구대파출소": "강릉경찰서",
		  "청": "강원청"
		},
		
	우체통 API: http://koreapost.go.kr/extra/user/kpost/330/bbs/openApi/openApiSet/sub/ExtraUser.do
	신청방법 : 휴대폰 인증 후 key 발급
	return : xml
		<postListResponse>
	  <postMsgHeader>
	   <totalCount>3</totalCount>
	   <pageCount>10</pageCount>
	   <totalPage>1</totalPage>
	   <nowPage>1</nowPage>
	  </postMsgHeader>
	  <postItem>
	   <postId>10001</postId>
	   <postDiv>1</postDiv>
	   <postNm>서울소공동우체국</postNm>
	   <postNmEn>Seoul Sogongdong Branch Post Office</postNmEn>
	   <postTel>02-757-2660</postTel>
	   <postFax>02-776-2660</postFax>
	   <postAddr>서울 중구 남대문로1길 34, 1층 (북창동)</postAddr>
	   <postAddrEn>34, Namdaemun-ro 1-gil, Jung-gu, Seoul</postAddrEn>
	   <post365Yn>Y</post365Yn>
	   <postTime>09:00~18:00</postTime>
	   <postFinanceTime>09:00~16:30</postFinanceTime>
	   <postServiceTime>05:00~익일:04:00</postServiceTime>
	   <postLat>37.5625356</postLat>
	   <postLon>126.9775329</postLon>
	   <postSubWay>시청역</postSubWay>
	   <postOffiId>100</postOffiId>
	   <fundSaleYn>N</fundSaleYn>
	   <phoneSaleYn>N</phoneSaleYn>
	   <partTimeYn>N</partTimeYn>
	   <lunchTimeYn>N</lunchTimeYn>
	   <lunchTime>null</lunchTime>
	   <todayDepartureYn>Y</todayDepartureYn>
	   <todayDepartureMailTime>17:30</todayDepartureMailTime>
	   <postDesc/>
	   <modDt>2018-05-30</modDt>
	  </postItem>
	</postListResponse>
		
	
4. 각 지도 API별 데이터 포맷(네이버, 카카오, 구글) 
	네이버 : https://guide.ncloud-docs.com/docs/maps-overview
	네이버(web) : https://navermaps.github.io/maps.js.ncp/docs/index.html
	카카오: https://apis.map.kakao.com/
	구글: https://developers.google.com/maps
	
	
5. 주소API → 위경도API 호출
6. 주요활동지역 push 
ex) 주요활동지역:부산역 1번 출구 → push → 반경 500m → 위/경도 정보로 where 조건 가능한지

PUSH

ZUM: https://zuminternet.github.io/FCM-PUSH/
