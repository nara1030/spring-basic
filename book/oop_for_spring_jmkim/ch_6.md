6장. 스프링이 사랑한 디자인 패턴
=====
* 주방기구: 객체 지향의 4대 특성
* 주방기구를 올바르게 사용하는 법: 객체 지향 설계의 5원칙
* 요리법, 즉 레시피: 디자인 패턴
- - -
## 목차
1. [개요](#개요)
	* [Adapter Pattern](#Adapter-Pattern)
	* Proxy Pattern
	* Decorator Pattern
	* Singleton Pattern
	* Template Method Pattern
	* Factory Method Pattern
	* Stragety Pattern
	* Template Callback Pattern
2. [기타](#기타)
	* 스프링이 사용한 다른 패턴들
	* 참고

## 개요
하나의 요리에 대해 표준화된 요리법이 있듯이 프로그램을 작성하다 보면 비슷한 상황에 직면하게 되는 경우가 많은데, 그러한 상황에서 이전의 많은 개발자들이 고민하고 정제한 사실상 표준 설계 패턴이 있다. 이를 디자인 패턴이라고 한다. 스프링 역시 다양한 디자인 패턴을 활용하고 있는데 먼저 스프링의 정의를 살펴보자.

> "자바 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크"

즉 한 마디로 **OOP 프레임워크**라고 할 수 있다. 앞으로 살펴볼 디자인 패턴 역시 객체 지향의 특성 중 상속(extends), 인터페이스(interface/implements), 합성(객체를 속성으로 사용)을 이용한다. 따라서 여러 디자인 패턴이 비슷하게 보일 수 있다.

##### [목차로 이동](#목차)

### Adapter Pattern
어댑터는 다시 말해 변환기(conveter)의 의미다. 변환기는 서로 다른 두 인터페이스 사이의 통신을 가능케 하는 역할을 한다. 주변에서 흔히 볼 수 있는 변환기로는 충전기가 있다. 예를 들어 휴대폰 충전기의 경우 휴대폰을 직접 전원에 연결할 수 없기 때문에 충전기가 핸드폰과 전원을 연결해주는 변환기의 역할을 수행하는 것이다.

좀 더 구체적인 예로는 ODBC/JDBC가 어댑터 패턴을 이용해 다양한 데이터베이스 시스템을 단일한 인터페이스로 조작할 수 있게 하는 것을 들 수 있다. 이는 5장 SOLID에서 개방 폐쇄 원칙(OCP)을 설명할 때도 예로 들었던 내용으로 결국 어댑터 패턴은 개방 폐쇄 원칙을 활용한 설계 패턴이라고 할 수 있다. 예제 코드를 통해 살펴보자.

* 어댑터 패턴 미적용
	* 코드  
		```java
		// 패키지명(adapterPattern) 생략
		
		public class ServiceA {
			void runServiceA() {
				System.out.println("ServiceA");
			}
		}
		
		public class ServiceB {
			void runServiceB() {
				System.out.println("ServiceB");
			}
		}
		
		public class ClientWithNoAdapter {
			public static void main(String[] args) {
				ServiceA sa1 = new ServiceA();
				ServiceB sb1 = new ServiceB();
				
				sa1.runServiceA();
				sb1.runServiceB();
			}
		}
		```
	* UML
		* .
* 어댑터 패턴 적용
	* 코드  
		```java
		// 패키지명(adapterPattern) 생략
		
		public class AdapterServiceA {
			ServiceA sa1 = new ServiceA();
			
			void runService() {
				sa1.runServiceA();
			}
		}
		
		public class AdapterServiceB {
			ServiceB sb1 = new ServiceB();
			
			void runService() {
				sb1.runServiceB();
			}
		}
		
		public class ClientWithAdapter {
			public static void main(String[] args) {
				AdapterServiceA asa1 = new AdapterServiceA();
				AdapterServiceB asb1 = new AdapterServiceB();
				
				asa1.runService();
				asb1.runService();
			}
		}
		```
	* UML
		* .

##### [목차로 이동](#목차)

## 기타


##### [목차로 이동](#목차)