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
	// URI					| 	URI 설명
	// http://jpub.com/post		|	포스트 리소스의 집합 표현
	// http://jpub.com/post/1		|	포스트 리소스의 집합 중 첫 번째 요소 표현
	// http://jpub.com/post/1/comments	|	포스트 리소스의 집합 중 첫 번째 요소와 연관 있는 코멘트 표현
	// http://jpub.com/post/1/comments/245	|	코멘트 집합의 245번째 요소 표현
	```
	* 리소스명은 동사가 아닌 명사 사용
	* 리소스는 Collection과 Document로 표현 가능한데, Collection은 복수 사용
* HTTP Method: 리소스에 대한 행위 표현  
	```txt
	// HTTP Method		| 설명
	// GET / students	| 학생 목록 조회(리소스 조회)
	// POST / students	| 학생 생성(리소스 생성)
	// PUT / students/1	| 1번 학생 정보 업데이트(리소스 업데이트)
	// DELETE / students/1	| 1번 학생 정보 삭제(리소스 삭제)
	```

**리소스 식별**을 위해, 다시 말해 일관성 있는 구조화된 REST API를 만들고자 할 때 URI 템플릿을 사용하곤 한다. 스프링 MVC에서도 URI 템플릿을 지원하는데 [PathVariable을 사용](#스프링에서-URI-템플릿-활용)하면 된다.

한편 **표현을 통한 리소스 처리**란 RESTful 리소스들은 추상화되어 있으므로(?) 형식에 자유로움을 말한다. 즉 XML, HTML, JSON 등 특정 형식을 가리지 않고 클라이언트에게 전달하기 전에 데이터를 직렬화해서 그 시점에 데이터의 상태에 대한 표현(?)을 해주면 된다. 다만 대부분의 웹 개발 특성상 클라이언트가 웹인 경우에는 JSON 데이터를 처리하는 것이 수월(?)하므로 최근에 대부분의 REST API에서는 JSON 포맷으로 응답하도록 REST API를 개발한다.

##### [목차로 이동](#목차)

## REST API 만들기
REST API를 클라이언트에게 제공하기 위해서는 클라이언트가 접근할 수 있는 엔트리 포인트, 진입점을 만들어야 한다. 이런 작업을 위해 스프링 MVC에 컨트롤러를 사용할 수 있다.

1. [REST 컨트롤러 활용](#REST-컨트롤러-활용)
2. [REST API에서 HTTP Method 사용](#REST-API에서-HTTP-Method-사용)
3. [스프링에서 URI 템플릿 활용](#스프링에서-URI-템플릿-활용)
4. [우리는 왜 Restful API를 만드는 걸까?](#REST-클라이언트-개발)

- - -
#### 잘못된 REST 사용
* GET/POST의 부적합한 사용
* 자체 표현적이지 않음
* HTTP 응답 코드 미사용

#### REST 컨트롤러 활용
> 클라이언트가 /basic/todo 경로로 요청을 보냈을 때 응답을 JSON으로 제공하는 API를 만들어 보자

두 가지 클래스가 필요하다.

* 모델 클래스: 데이터 담기
* 컨트롤러 클래스: 요청(URL) 받아서 응답(JSON)

상세 코드는 교재를 참고하고, 여기서는 Controller 클래스에서 두 가지를 짚고 넘어간다.

* @RestController(SINCE 스프링4.1)
	* @ResponseBody 사용 않고 REST API 생성 가능
		* @Controller + @ResponseBody(SINCE 스프링3.1)  
			```java
			// 예제 코드 임포트 부분 발췌 
			import org.springframework.web.bind.annotation.RequestMapping;
			import org.springframework.web.bind.annotation.ResponseBody;	// 자동 추가(∵ RestController)
			import org.springframework.web.bind.annotation.RestController;
			```
	* 실행 결과에 대한 처리를 위한 어노테이션
		1. 실행 결과는 View를 거치지 않고 HTTP Response Body에 직접 입력
		2. 응답에 실행 결과를 작성하게 된 상태에서 MappingJacksonHttpMessageConverter를 통해 JSON 형태로 결과 표현  
			* 스프링3.1부터는 JSON 표현에 대한 별도의 메시지 컨버팅 설정을 하지 않아도 JAXB2와 Jackson 라이브러리만 클래스패스에 추가되어 있으면 JSON이 자동으로 변환
			* 스프링 부트에서는 해당 라이브러리들을 이미 포함
* AtomicLong  
	```java
	// 예제 코드 일부 발췌
	import java.util.concurrent.atomic.AtomicLong;
	
	@RestController
	@ResquestMapping(value = "/basic")
	public class BasicController {
		private final AtomicLong counter = new AtomicLong();
		
		@RequestMapping(value = "/todo")
		public Todo basic() {
			return new Todo(counter.incrementAndGet(), "라면사오기");
		}
	}
	```
	* 동시성 문제 처리를 위해 `java.util.concurrent.atomic` 패키지 추가(SINCE 자바1.5)
		* AtomicLong을 사용하면 Long 타입 변수에 대해 thread-safe하게 처리 가능
		* 만약 단순히 Long 타입으로 선언한다면 서로 다른 스레드에서 하나의 변수에 대해 값을 쓰거나 읽기 때문에 문제 발생
	* 요청(해당 URL 호출)이 올 때마다 Todo 인스턴스 생성 후 id값을 증가시켜야 하므로 위와 같이 counter 선언
		* 즉 내가 이해하기로는, 컨테이너가 Bean(BasicController)을 유일하게 생성/관리해주므로 그 멤버인 counter는 `static`일 필요 없음
		* cf. static/Singleton([참고](https://github.com/nara1030/ThisIsJava/blob/master/docs/etc/static_vs_singleton.md))

- - -
```java
import java.util.concurrent.atomic.AtomicLong;

/*
 * AtomicLong Class Example
 */
public class TestThread {
    static class Counter {
        private AtomicLong c = new AtomicLong(0);

        public void increment() {
            c.getAndIncrement();
        }

        public long value() {
            return c.get();
        }
    }

    public static void main(final String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        // 1000 threads
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.increment();
                }
            }).start();
        }
        Thread.sleep(6000);
        System.out.println("Final number (should be 1000): " + counter.value());
    }
}
```

익숙치 않은 코드라 공부할 필요가 있다.

* Effective Java 2nd Edition. Item 22: [Favor static member class over nonstatic](https://whiteship.tistory.com/2605?category=56999)
* 중첩 클래스의 네 종류와 특성

##### [목차로 이동](#목차)

#### REST API에서 HTTP Method 사용


##### [목차로 이동](#목차)

#### 스프링에서 URI 템플릿 활용
앞에서 일관성 있는 REST API를 만들기 위해 URI 템플릿(ex. PathVariable)을 사용한다고 언급했다. 그 필요성에 대해 좀 더 구체적으로 말하자면, GET/POST로도 파라미터를 전달하거나 원하는 결과를 얻을 수 있지만 해당 내용을 처리하는 URI 값 자체가 변화하지 않아서 URI 정보에 대한 가독성이 떨어지기 때문이다.

스프링에서는 PathVariable을 이용해서 URI 템플릿을 구현할 수 있으며, 이때 Request Mapping은 URI 템플릿을 사용하므로 GET 메소드를 사용하고 URI는 `/todos/{입력받을 변수값}`이 된다. 그리고 파라미터는 아래와 같이 PathVariable 어노테이션을 표기해준다.

```java
// 교재 일부 발췌
// 해당 API를 사용해본 적 없는 사람도 데이터 결과를 손쉽게 예측 가능
@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
public Todo getPath(@PathVariable int todoId) {
	// 중략
	return todoMap.get(todoId);
}
```

##### [목차로 이동](#목차)

## HATEOAS를 이용한 자기주소정보 표현


##### [목차로 이동](#목차)

## REST API 문서화


##### [목차로 이동](#목차)

## REST 클라이언트 개발
최근 MSA가 유행하며 업무별로 API를 만들어 서로 API간 통신을 통해 데이터를 주고 받는 경우가 많다. 더해 REST API와 연동 시엔 HTTP 요청을 보내는 것뿐만 아니라 응답 JSON 데이터를 파싱하고 모델 객체와 매핑하는 것이 중요하다.

* RestTemplate
* UriComponentsBuilder

- - -
#### 우리는 왜 Restful API를 만드는 것일까? 

가장 큰 이유는 Client Side를 정형화된 플랫폼이 아닌 모바일, PC 등 제약을 두지 않기 위해서다. 스마트 기기의 등장 등 Client 프로그램이 다양화되면서 그에 맞춰 Server Side를 일일이 만드는 것이 비효율적이 되었기 때문이다. 따라서 개발자들은 Client Side를 전혀 고려하지 않은 XML, JSON과 같은 데이터 통신(Client에서 바로 객체로 치환 가능)을 지향하게 되었고 Server와 Client의 역할을 분리하게 되었다.

이런 상황에서 가장 중요해진 것은 HTTP 표준 규약을 지켜 API를 만드는 것이다. 그렇지 못한 가장 흔한 예는 HTTPStatus 코드를 제대로 응답하지 않은 것인데, 이런 경우 클라이언트에서 별도의 방어 코드를 짜넣는 수고가 발생하게 된다. 즉, 200뿐 아니라 401(권한없음)이나 500대 에러들(Server Side 발생)도 반환할 수 있어야 한다.

참고: https://steemit.com/kr-dev/@igna84/spring-boot-responseentity

##### [목차로 이동](#목차)

## 참고
* [REST API](https://github.com/baeharam/Must-Know-About-Frontend/blob/master/Notes/network/rest-api.md)
* [@RestController vs @Controller](https://lkg3796.tistory.com/58)
* [@RestController와 @ResponseBody](https://wondongho.tistory.com/76)
* [AtomicLong](http://tutorials.jenkov.com/java-util-concurrent/atomiclong.html)
* [Java Concurrency - AtomicLong Class](https://www.tutorialspoint.com/java_concurrency/concurrency_atomiclong.htm)
- - -
* [스프링 부트 + 리액트 개발 셋업 2018](https://start.goodtime.co.kr/2018/09/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EA%B0%9C%EB%B0%9C-%EC%85%8B%EC%97%85-2018/)
* [리액트, 스프링 부트 연동 CRUD 구현](https://corini.tistory.com/entry/%EB%A6%AC%EC%95%A1%ED%8A%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%97%B0%EB%8F%99%ED%95%98%EC%97%AC-CRUD-%EA%B5%AC%ED%98%84-1-%EA%B5%AC%EC%83%81-1n)
* [React와 Node.js 활용 고객 관리 시스템 개발](https://www.youtube.com/watch?v=_yEH9mczm3g&list=PLRx0vPvlEmdD1pSqKZiTihy5rplxecNpz)
* [프론트엔드의 이해](https://www.youtube.com/watch?v=gp5LeSxfD8Q&list=PL03rJBlpwTaA0ioaPahgWOSYzgPI4PWKR)

##### [목차로 이동](#목차)