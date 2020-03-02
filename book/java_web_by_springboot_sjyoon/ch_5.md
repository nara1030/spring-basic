REST API 서버 만들기
=====
예제 코드
* .
- - -
## 목차
1. [REST](#REST)
2. [리소스](#리소스)
3. [REST API 만들기](#REST-API-만들기)
4. [HATEOAS를 이용한 자기주소정보 표현](#HATEOAS를-이용한-자기주소정보-표현)
5. [REST API 문서화](#REST-API-문서화)
6. [REST 클라이언트 개발](#REST-클라이언트-개발)
7. [참고](#참고)

## REST
#### REST란
REpresentational State Transfer의 약자로 분산 네트워크(?) 프로그래밍의 아키텍처 스타일이다.

#### REST의 특성
1. 클라이언트/서버
	* 클라이언트와 서버가 서로 독립적으로(?) 구분되어야 함
	* 서버 또는 클라이언트 증설 시에 서로간의 의존성 때문에 확장에 문제 없어야 함
2. 상태 없음(Stateless)
	* 서버는 클라이언트의 상태를 기억할 필요 없음
3. 레이어드 아키텍쳐(Layered Architecture)
	* 서버와 클라이언트 사이에 다계층 형태로 레이어 추가/수정/제거 가능(확장성)
	* ex. 게이트웨이, 방화벽, 프록시
4. 캐시(Cacheable)
	* 캐시를 가지고 있을 경우, 클라이언트가 캐시를 통해 응답 재사용 가능  
	  (→ 서버의 부하를 낮추어 서버 성능 향상)
		* 서버의 응답은 캐시를 가지고 있거나 없거나 둘 중 하나
	* REST는 HTTP 표준 기반이므로 HTTP 특성인 캐싱 사용 가능
		* REST API를 활용, GET 메소드를 `Last-Modified` 값과 함께 보낼 경우, 컨텐츠의 변화가 없을 때 캐시된 값 사용
5. 코드 온 디멘드(Code on demand)
	* 요청이 오면 코드를 준다는 의미(?)
		* 특정 시점에 서버가 특정 기능을 수행하는 스크립트 또는 플러그인을 클라이언트에 전달해서 동작
	* ex. 애플릿, 자바스크립트, 플래시
6. 통합 인터페이스
	* 서버/클라이언트 상호작용은 일관된 인터페이스(REST 인터페이스) 위에서 이루어져야 함
	* [REST 인터페이스 규칙](#REST-인터페이스-규칙) 참고

#### REST 인터페이스 규칙
통합 인터페이스를 위한 네 가지 규칙을 알아보자.

1. 리소스 식별
	* 웹 안에서(?) 서로 구분할 수 있는 개념
	* URI와 같은 고유 식별자를 통해 표현
2. 표현을 통한 리소스 처리
	* 같은 데이터에 대해 표현 시 다양한 콘텐츠 유형으로 표현 가능
	* ex. JSON, XML, HTML
3. 자기 묘사 메세지
	* 일반적으로 네트워크 통신 시, 헤더(header) 부분에 현재 보내고 있는 데이터 패킷에 대한 메타 정보를 담아 해당 본문에 대한 의도 파악 가능
	* 마찬가지로 HTTP 통신의 경우, HTTP header에 메타 데이터 정보를 추가해서 데이터에 대한 설명(→ HTTP 상태코드) 가능
4. 애플리케이션 상태에 대한 하이퍼미디어(HATAOAS)
	* .

일반적으로 API란 데이터와 기능의 집합을 말하는데, 이때 API의 구조가 위에서 언급한 REST 요건들에 적합한 경우 RESTful하다고 말하며 이러한 API를 REST API라고 부른다.

분산 처리를 위한 서버를 만들기 위해 반드시 REST의 특성을 준수해야 할 의무는 없지만, 일반적으로 서버 개발의 경우 고가용성과 확장성이 요구되므로 REST의 특성을 지켜 개발한다면 **보다 더 확장성 있는 서버 애플리케이션을 개발**할 수 있다.

##### [목차로 이동](#목차)

## 리소스
REST 인터페이스 규칙 중 **리소스 식별**과 **표현을 통한 리소스 처리**에 대해 살펴보자.

#### 리소스란
REST의 핵심 개념으로 접근할 수 있고, 조작할 수 있는 모든 것이다. 예를 들면 사람, 할 일, 이미지, 비디오 등 명사화할 수 있는 대부분을 리소스라 할 수 있으며, 각각의 리소스들을 그룹화할 수 있다.

#### 리소스의 구분
이렇게 다양한 리소스를 구분하기 위해서 우리는 리소스 식별자를 사용한다. REST 인터페이스 규칙에서 언급했듯, 리소스 식별자 URI(Uniform Resource Identifier)는 리소스를 표현하고, 그 리소스에 대한 행위는 HTTP의 메소드가 표현한다.

* URI: 리소스를 표현  
	```txt
	// URI					| URI 설명
	// http://jpub.com/post		|	포스트 리소스의 집합 표현
	// http://jpub.com/post/1		|	포스트 리소스의 집합 중 첫 번째 요소 표현
	// http://jpub.com/post/1/comments	|	포스트 리소스의 집합 중 첫 번째 요소와 연관 있는 코멘트 표현
	// http://jpub.com/post/1/comments/245	|	코멘트 집합의 245번째 요소 표현
	```
	* 리소스명은 동사가 아닌 명사 사용
	* 리소스는 Collection과 Document로 표현 가능한데, Collection은 복수 사용
* HTTP Method: 리소스에 대한 행위 표현

##### [목차로 이동](#목차)

## REST API 만들기
* [@RestController vs @Controller](https://lkg3796.tistory.com/58)

##### [목차로 이동](#목차)

## HATEOAS를 이용한 자기주소정보 표현


##### [목차로 이동](#목차)

## REST API 문서화


##### [목차로 이동](#목차)

## REST 클라이언트 개발


##### [목차로 이동](#목차)

## 참고
* [REST API](https://github.com/baeharam/Must-Know-About-Frontend/blob/master/Notes/network/rest-api.md)
- - -
* [스프링 부트 + 리액트 개발 셋업 2018](https://start.goodtime.co.kr/2018/09/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EA%B0%9C%EB%B0%9C-%EC%85%8B%EC%97%85-2018/)
* [리액트, 스프링 부트 연동 CRUD 구현](https://corini.tistory.com/entry/%EB%A6%AC%EC%95%A1%ED%8A%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%97%B0%EB%8F%99%ED%95%98%EC%97%AC-CRUD-%EA%B5%AC%ED%98%84-1-%EA%B5%AC%EC%83%81-1n)
* [React와 Node.js 활용 고객 관리 시스템 개발](https://www.youtube.com/watch?v=_yEH9mczm3g&list=PLRx0vPvlEmdD1pSqKZiTihy5rplxecNpz)

##### [목차로 이동](#목차)