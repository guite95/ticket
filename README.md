## 🛠️ 사전 준비 (Prerequisites)
프로젝트 시작 전 아래 도구들이 설치되어 있어야 합니다.
* **Java 21 (JDK 21)**
* **IntelliJ IDEA**
* **Docker Desktop** (필수: DB 실행용)
    * [Docker Desktop 다운로드](https://www.docker.com/products/docker-desktop/)

---

## 🚀 시작 방법 (Getting Started)

### 1. 프로젝트 가져오기
1.  우측 상단의 **Fork** 버튼을 눌러 개인 레포지토리로 가져갑니다.
2.  개인 레포지토리에서 프로젝트를 **Clone** 합니다.

### 2. 개발용 DB 실행 (필수)
이 프로젝트는 Docker를 이용해 로컬 DB 환경(MySQL)을 구성합니다.<br>
**Docker Desktop을 먼저 실행한 뒤**, 아래 방법 중 편한 방식으로 실행하세요.

#### 🖱️ 방법 A: 직접 실행
* **Windows:** 프로젝트 루트의 `start-db.bat` 더블 클릭
* **Mac / Linux:** `start-db.command` 더블 클릭
    * (최초 1회 권한 설정 필요: 터미널에서 `chmod +x start-db.command` 실행)

#### ⌨️ 방법 B: 터미널에서 실행 (IDE 내부 터미널)
인텔리제이나 VS Code 하단 터미널에서 바로 실행할 수도 있습니다.
* **Windows(cmd):**
    ```cmd
    ./start-db.bat
    ```
* **Mac / Linux(bash):**
    ```bash
    ./start-db.command
    ```

> ✅ **참고:** DB는 로컬 포트 충돌 방지를 위해 **3307 포트**로 실행됩니다.

### 3. 애플리케이션 실행
* IntelliJ에서 `TicketApplication` 클래스를 실행합니다.
* `Started TicketApplication in ...` 로그가 뜨면 성공입니다!

---

## 👩‍💻 스터디 진행 방식 (Workflow)

1.  **브랜치 생성:** `main` 브랜치에서 작업하지 말고, 기능별 브랜치를 따서 작업합니다.
    * 예: `git checkout -b feature/week1-lock`
2.  **구현:** 과제 요구사항에 맞춰 기능을 구현합니다.
3.  **PR 작성:** 구현이 끝나면 본인 레포지토리에 Push 후, **원본 레포지토리(Upstream)** 로 Pull Request를 보냅니다.
    * 🚫 **주의:** PR만 날리고 절대 **Merge** 버튼은 누르지 않습니다! (코드 리뷰용)