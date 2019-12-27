스프링 프레임워크
=====
## 목차
1. [빈과 컨테이너](#빈과-컨테이너)
2. [IoC 패턴 활용](#IoC-패턴-활용)
	* [인터페이스와 스프링](#인터페이스와-스프링)
	* 스프링 XML 설정
	* 스프링 JavaConfig 설정
3. [스프링 MVC](#스프링-MVC)
	* [스프링 MVC 구조](#스프링-MVC-구조)
	* 스프링 MVC 설정
	* DispatcherServlet 설정
	* 컨트롤러와 뷰
	* 인터셉터
4. [참고](#참고)

## 빈과 컨테이너
**스프링**은 엔터프라이즈 애플리케이션을 개발하기에 적합한 객체 관리를 해주는 빈 컨테이너 프레임워크다. 스프링을 더 잘 이해하기 위해서는 프레임워크의 역사에 관해 간략히 두 단계로 살펴볼 필요가 있다. 먼저 그 시작은 EJB였다.

> Simply put, an **Enterprise Java Bean** is a Java class with one or more annotations from the EJB spec which grant the class special powers when running inside of an EJB container.

위는 EJB, 즉 Enterprise Java Bean의 정의를 발췌한 것이다. 이는 IBM이 1997년 출시한 스펙으로 기업을 위한 최초의 Java 프레임워크다. 하지만 개발에 대한 요구사항이 점점 복잡해지자 사람들은 좀 더 경량화되고 간소화된 컨테이너를 선호하게 되었다. 이때 등장한 것이 POJO다.

> POJO means **Plain Old Java Object**. It refers to a Java object(instance of definition) that isn't bogged down by framework extensions.

추측컨데 프레임워크에 의해 확장, 즉 스펙을 구현하지 않은 평범한 자바 오브젝트가 POJO다. 결과적으로 EJB와 상충되는 방법으로 개발을 진행하고 의견을 모으기 위해서 새로운 용어가 필요했고, 일반 자바 빈이라는 말 대신 POJO를 사용하기 시작했다. 이후 로드 존슨은 `<J2EE 설계와 개발>`이라는 책을 시작으로 웹 애플리케이션 컨테이너와 상관없이 독립적으로 빈의 생명주기를 관리할 수 있는 스프링 프레임워크를 만들게 되고, 큰 인기를 끌게 된다.

현재 스프링은 DataAccess/Web/Core 모듈 외에도 SNS 연동에 유용한 Spring Social, 메시징과 관련된 Spring AMQP, Hbase와 같은 빅데이터 처리를 위한 Spring XD 등 그 영역을 넓혀나가고 있다([공식 사이트](https://spring.io/projects) 통해 확인 가능). 이렇게 모듈을 지속적으로 확장해나갈 수 있는 것은 Spring Core Container를 통해 모듈 간의 의존도를 최소화했기 때문이다. 이렇게 의존도를 낮추는 방법 중 하나는 IoC 패턴을 활용하는 것이다.

##### [목차로 이동](#목차)

## IoC 패턴 활용
IoC(Inversion of Control)는 우리나라 말로 **제어의 역전**이다. 이것이 자바 웹 개발에서 특히 알려진 이유는 프로그램의 생명주기에 대한 주도권이 웹 애플리케이션 컨테이너에 있기 때문이다.

IoC와 의존성 주입 연관. p52.

##### [목차로 이동](#목차)

### 인터페이스와 스프링
스프링에서 의존성을 주입할 때는 기본적으로 타입(type)을 기반으로 한다. 그리고 자바에서 타입을 가장 잘 나타낼 수 있는 것은 인터페이스(interface)다.

##### [목차로 이동](#목차)

## 스프링 MVC
**스프링 MVC**는 [2장](ch_2.md)에서 살펴보았듯이 Front Controller 패턴에 Spring 의존성 주입(DI)을 이용해서 컴포넌트들의 생명주기를 관리할 수 있는 컨트롤러 중심의 웹 MVC 프레임워크다.

##### [목차로 이동](#목차)

## 스프링 MVC 구조
<img src="./img/ch_3_1.jpg" width="800" height="300"></br>

##### [목차로 이동](#목차)

## 참고
* EJB vs. POJO
	* [A Detailed Guide to Enterprise Java Beans w/Code Examples](https://stackify.com/enterprise-java-beans/)
	* [POJO의 이해 - Hong's Store House](http://asuraiv.blogspot.com/2017/07/spring-pojo.html)
	* [POJO vs Java Beans - GeeksforGeeks](https://www.geeksforgeeks.org/pojo-vs-java-beans/)

##### [목차로 이동](#목차)
