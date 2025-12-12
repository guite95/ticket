## 🎫 대규모 트래픽을 고려한 콘서트 티켓팅 시스템 (Ticketing Service)

이 프로젝트는 인기 아이돌 콘서트 티켓팅과 같이 **짧은 시간 내에 대규모 트래픽이 몰리는 상황**을 가정하여 설계된 백엔드 서비스입니다.
단순한 기능 구현을 넘어 **동시성 제어(Concurrency Control), 데이터 일관성, 시스템 안정성**을 학습하고 구현하는 데 초점을 맞췄습니다.

### 📚 프로젝트 목표

* **동시성 제어:** 다수의 사용자가 동시에 하나의 좌석을 예약하려 할 때 발생하는 **Race Condition** 해결.
* **데이터 정합성:** 예약과 결제, 포인트 차감 프로세스 간의 트랜잭션 범위 설정 및 데이터 무결성 보장.
* **실무 지향 아키텍처:** Layered Architecture, DTO/Entity 분리, RESTful API 설계 원칙 준수.

-----

### 🛠 Tech Stack

**Environment**

*
*
*

**Database**

*
*

**Infrastructure**

*

-----

### 🔥 Key Technical Challenges (핵심 문제 해결)

#### 1\. 좌석 예약 시 동시성 이슈 해결 (Concurrency Control)

* **상황:** 수십 명의 유저가 동시에 같은 좌석(Row)을 예약(`POST /reservations`)하려고 시도합니다.
* **문제:** 일반적인 조회 후 업데이트 로직으로는 **초과 예약(Overbooking)** 또는 **데이터 덮어쓰기(Lost Update)** 현상이 발생합니다.
* **해결 전략:** **비관적 락(Pessimistic Lock)** 적용
    * **선택 근거:** 콘서트 티켓팅은 충돌 빈도가 매우 높고, 사용자에게 "선착순 성공/실패" 여부를 빠르게 확정 지어줘야 하는 도메인입니다.
    * 낙관적 락(Optimistic Lock)은 충돌 시 롤백 및 재시도 비용이 크기 때문에, DB 레벨에서 `SELECT ... FOR UPDATE`를 사용하여 데이터 접근을 순차적으로 제어했습니다.

#### 2\. RESTful API 설계 및 계층 분리

* URL은 자원(Resource)을 명확히 표현하도록 복수형(`plural`)을 사용하고, 행위는 HTTP Method로 정의했습니다.
* **Controller:** 요청/응답 처리 및 DTO 변환 역할만 수행.
* **Service:** 비즈니스 로직 및 트래픽 제어 담당.
* **Repository:** DB 접근 담당.
* `Record` 타입을 활용하여 불변 DTO를 구현했습니다.

-----

### 🚀 API Specification (V1.0)

| Method | URI | Description |
| :--- | :--- | :--- | 
| `GET` | `/api/ticketing/concerts` | 콘서트 목록 조회 |
| `GET` | `/api/ticketing/concerts/{id}/options` | 콘서트 날짜 옵션 조회 |
| `GET` | `/api/ticketing/concerts/options/{id}/seats` | 예약 가능 좌석 조회 | 
| `POST` | `/api/ticketing/reservations` | **좌석 예약 요청 (핵심)** | 
| `POST` | `/api/ticketing/payments` | 예약 좌석 결제 | 
| `POST` | `/api/ticketing/point/charge` | 포인트 충전 | 
| `GET` | `/api/ticketing/users/{id}/reservations` | 내 예약 내역 조회 | 

-----

### 📅 Future Roadmap (고도화 계획)

* **V2.0 (성능 최적화):**
    * Redis를 도입하여 조회 성능 개선 (Caching).
    * 대기열 시스템 구현 (Redis Sorted Set 활용).
* **V3.0 (아키텍처 확장):**
    * Kafka를 이용한 결제 후처리(알림 발송) 비동기화.
    * 부하 테스트(k6, nGrinder)를 통한 TPS 측정 및 병목 구간 개선.

-----

### 📝 License

This project is licensed under the MIT License.