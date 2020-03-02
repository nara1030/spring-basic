스프링 부트에 대한 이해
=====
예제 코드
* .
- - -
## 목차
1. [스프링 부트에 대한 이해](#스프링-부트에-대한-이해)
	* [스프링 부트의 프로젝트 레이아웃](#스프링-부트의-프로젝트-레이아웃)
	* [스프링 부트 실행하기](#스프링-부트-실행하기)
2. [정적 자원 관리](#정적-자원-관리)
	* 정적 자원 기본 설정
	* 웹 리소스 폴더 설정
3. [템플릿 엔진](#템플릿-엔진)
4. [WebJars를 이용한 프론트라이브러리 관리](#WebJars를-이용한-프론트라이브러리-관리)
5. [참고](#참고)

## 스프링 부트에 대한 이해
[3장](ch_3.md)에서 스프링 사용 방법에 대해 다뤘다.

* 장점
	* 의존성 주입(DI) 덕분에 클라이언트가 구현 코드에 직접 접근하지 않고 인터페이스를 통해 접근
* 단점
	* 웹 애플리케이션에서 스프링 사용 시 `spring-context`(DI 제공) 외 다양한 모듈 설정 필요  
	  (`spring-security`, `spring-jdbc`, `spring-mvc`)

즉, 시작하는 입장에서 실제로 구현해야 하는 비즈니스 로직과는 관련 없는 스프링 설정이 많기에 스프링 부트가 등장했다(∵ 스프링은 본래 웹을 위한 프레임워크가 아니었기 때문에 스프링 MVC 사용 위해선 추가 설정 필요).

##### [목차로 이동](#목차)

### 스프링 부트의 프로젝트 레이아웃
자바 기반에서 개발을 진행할 때 결과 파일 포맷은 크게 두 가지로 구분할 수 있다.

| 포맷 | 인식 |
| -- | -- |
| JAR | 로컬(JVM) |
| WAR | 웹 애플리케이션 컨테이너(WAS) |

이때 파일 이름이 다른 것뿐 아니라 각 압축 파일들이 인식되기 위해 내부 폴더 규격이 다르다. 특히 WAR의 경우는 [1장](https://github.com/nara1030/spring-basic/blob/master/book/java_web_by_springboot_sjyoon/ch_1.md#WAR-%ED%8C%8C%EC%9D%BC%EC%9D%98-%ED%8A%B9%EC%84%B1)에서 살펴봤다.

추후 작성.

* Maven 이전  
	```
	└─ .
	  ├─ .
	  │  ├─ .
	  │  └─ .
	  └─ .
		 ├─ .
		 └─ .
	```
* Maven 이후  
	```
	└─ workspace
	  ├─ src
	  │  ├─ main
	  │     ├─ java
	  │     ├─ resources
	  │     └─ webapp
	  │        ├─ WEB-INF
	  │        └─ 
	  └─ 선언형 프로그래밍
		 ├─함수형: Haskell
		 └─논리형
	```
	* [Apache Maven Standard Directory Layout - Baeldung](https://www.baeldung.com/maven-directory-structure)
	* [Introduction to the Standard Directory Layout - Apache Maven Project](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
	* [Web Application 디렉토리 구조](https://soye0n.tistory.com/70)
	* [스프링 디렉토리 구조 재정의하기](https://linux.systemv.pe.kr/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%94%94%EB%A0%89%ED%86%A0%EB%A6%AC-%EA%B5%AC%EC%A1%B0-%EC%9E%AC%EC%A0%95%EC%9D%98%ED%95%98%EA%B8%B0/)

한편 스프링 부트는 기본적으로 Runnable JAR로 실행되므로 WAR 규격에 맞추지 않고 웹 자원들을 사용하기 위한 몇 가지 규약을 제공한다(WEB-INF 및 webapp 폴더 생성 안함).

| 웹 자원 | 경로 |
| -- | -- |
| 정적 HTML 파일 | . |

위와 같이 웹 자원들을 해당 경로에만 두면 웹을 위한 별도의 폴더를 생성할 필요가 없다.

* [Executable JAR 파일 생성](http://asuraiv.blogspot.com/2015/11/java-executableor-runnable-jar.html)
* [이클립스에서 JAR 파일 생성](https://juyayang.tistory.com/106)

- - -


##### [목차로 이동](#목차)

### 스프링 부트 실행하기
* [스프링 부트의 Config 어노테이션](https://jhleed.tistory.com/126)
* [스프링 MVC, 스프링 부트 설정](https://wedul.site/349)
* [스프링 부트 CLI](https://jobc.tistory.com/108)

##### [목차로 이동](#목차)

## 정적 자원 관리


##### [목차로 이동](#목차)

## 템플릿 엔진
* [템플릿 엔진이란](https://gmlwjd9405.github.io/2018/12/21/template-engine.html)

##### [목차로 이동](#목차)

## WebJars를 이용한 프론트라이브러리 관리


##### [목차로 이동](#목차)

## 참고


##### [목차로 이동](#목차)