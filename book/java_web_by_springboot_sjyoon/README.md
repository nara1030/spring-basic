스프링 부트로 배우는 자바 웹 개발(2018)
=====
윤석진 지음, 제이펍

* 예제 코드
	* [1~11장](https://github.com/thecodinglive/JPub-JavaWebService)
	* [12장](https://github.com/thecodinglive/memberApp)
* [독자 Q&A](https://github.com/thecodinglive/JPub-JavaWebService/issues)
* 저자 이메일: darkandark90@gmail.com
- - -
## 목차
1. [구성](#구성)
2. [참고](#참고)
	* [개발툴](#개발툴)
	* [빌드툴](#빌드툴)

## 구성
이 책에서 사용하는 스프링 부트의 버전은 1.5.8이다. 스프링 부트는 현재(2018) 2.1.0 버전까지 릴리즈 되었지만 책의 목적이 스프링 부트 기술 자체보다 웹 개발에 초점이 맞춰져 있어서 최신 버전 대신 안정적인 1.5 버전 기준으로 설명한다. 다만 스프링 부트 2.0에서도 잘 작동한다.

이 책은 자바 웹 서비스 개발을 시작하는 사람들을 위한 입문서다. 서블릿부터 Spring Data JPA, REST API, Actuator를 활용한 모니터링, 클라우드 서비스를 이용한 배포까지 웹 서비스 개발에 필요한 전반적인 내용을 다룬다. 이 책의 목차는 아래와 같다.

* [1장_개발 환경의 변화와 자바](ch_1.md)
* [2장_서블릿](ch_2.md)
* [3장_스프링 프레임워크](ch_3.md)
* [4장_스프링 부트 웹 개발](ch_4.md)
* [5장_REST API 서버 만들기](ch_5.md)
* 6장_스프링 부트와 데이터
* 7장_커스텀 스프링 부트 스타터
* 8장_예외 처리 및 테스트
* 9장_배포
* 10장_모니터링
* 11장_캐시
* 12장_회원 관리
* A_인텔리제이를 이용한 예제 프로젝트 실행 방법

##### [목차로 이동](#목차)

## 참고
### 개발툴
* [인텔리제이 무료 버전으로 스프링5 MVC 개발하기(Maven) - BSIDESOFT co.](https://www.bsidesoft.com/?p=6160)
* [인텔리제이 무료 버전으로 Spring Boot 개발환경 만들기(Gradle) - BSIDESOFT co.](https://www.bsidesoft.com/?p=6926)
* [인텔리제이에서 Maven 기반 프로젝트를 Tomcat에 배포하기 - BSIDESOFT co.](https://www.bsidesoft.com/?p=7123)
* [이클립스의 workspace와 인텔리제이의 project - 기억보단 기록을](https://jojoldu.tistory.com/334)

- - -
지금까지는 이클립스를 사용해왔으나 이 책을 계기로 인텔리제이 사용법을 익히고자 한다. 이 책에서 인텔리제이에 대해 언급한 부분 일부를 발췌한다.

> 이클립스4 juno 버전부터 급격히 성능이 나빠져서 많은 기업들이 그 대안으로 인텔리제이를 사용한다. 인텔리제이는 젯브레인이라는 회사에서 만드는 상업용 도구이므로 유료이지만, 커뮤니티용 무료 버전도 제공한다. 이들의 가장 큰 차이는 로컬에서 톰캣을 별도로 연결해서 지원하는 웹 개발 지원 유무인데, 이 책에서 스프링 부트는 jar 형태로 실행하고 서블릿 장인 2장에서는 getty 플러그인으로 실행하므로 무료 버전으로도 모든 예제를 실행할 수 있다.

정확히 이해하지 못했는데 내가 이해한 느낌은 대충 아래와 같다.

| 버전 | 실행파일 |
| -- | -- |
| Ultimate Edition | WAR |
| Community Edition | JAR |

* [WAR 파일의 특성](https://github.com/nara1030/spring-basic/blob/master/book/java_web_by_springboot_sjyoon/ch_1.md#WAR-%ED%8C%8C%EC%9D%BC%EC%9D%98-%ED%8A%B9%EC%84%B1)
* [Ultimate vs. Community](https://www.jetbrains.com/ko-kr/idea/features/editions_comparison_matrix.html)

하지만 책의 다른 부분을 보면 내가 잘 이해하지 못한 것 같다.

> 스프링 부트는 클라우드 사용이 늘어나면서 별도의 서버 설치 없이 JAR로 실행할 수 있고, 설정들이 자동화되어 있는 장점들 덕분에 사용처가 늘고 있는 추세다.

* [스프링부트 JAR 파일로 배포하기 - LeafCat님](https://www.leafcats.com/178)
* [스프링부트 프로젝트 Tomcat 서버 배포시 404 에러 발생 - 김강휘님](https://okky.kr/article/639544)

##### [목차로 이동](#목차)

### 빌드툴
* [Gradle 간단 사용하기 - slowstarter](https://joochang.tistory.com/80)
* [Gradle 기반의 Java 프로젝트에서 로컬 .JAR 라이브러리 추가하기 - 지단로보트](https://jsonobject.tistory.com/222)
* [Maven 사용자를 위한 Gradle의 간단 사용법 - 와이케이의 마구잡이](https://yookeun.github.io/java/2015/02/09/java-gradle/)

##### [목차로 이동](#목차)