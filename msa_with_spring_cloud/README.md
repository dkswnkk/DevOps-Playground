## 학습 참고
- [Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/dashboard)
 [Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/dashboard)
- [msa_with_spring_cloud](https://github.com/joneconsulting/msa_with_spring_cloud)

## 애플리케이션 구성요소
| 구성요소 | 설명 |
| --- | --- |
| Git Repository | 마이크로서비스 소스 관리 및 프로파일 관리 |
| Config Server | Git 저장소에 등록된 프로파일 정보 및 설정 정보 |
| Eureka Server | 마이크로서비스 등록 및 검색 |
| API Gateway Server | 마이크로서비스 부하 분산 및 서비스 라우팅 |
| Microservices | 회원 MS, 주문 MS, 상품(카테고리) MS |
| Queuing System | 마이크로서비스 간 메시지 발행 및 구독 |

## 애플리케이션 API 목록
| 마이크로서비스 | RESTful API | HTTP Method |
| --- | --- | --- |
| Catalog Service | /catalog-service/catalogs : 상품 목록 제공 | GET |
| User Service | /user-service/users : 사용자 정보 등록<br> /user-service/users : 전체 사용자 조회<br> /user-service/users/{user\_id} : 사용자 정보, 주문 내역 조회 | POST<br>GET<br>GET |
| Order Service | /order-service/users/{user\_id}/orders : 주문 등록<br>/order-service/users/{user\_id}/orders : 주문 확인 |POST<br>GET|

## 전체 구성
<img width="824" alt="image" src="https://user-images.githubusercontent.com/74492426/194121754-5afc4789-d3d3-4127-9b6e-4aa17a111ce6.png">
