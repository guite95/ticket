@echo off
echo ==============================================
echo [티켓팅 프로젝트] 개발용 DB를 실행합니다...
echo (Docker Desktop이 켜져 있어야 합니다!)
echo ==============================================

:: 파일명을 명시해서 실행
docker-compose -f docker-compose-local.yml up -d

echo.
echo ==============================================
echo DB 실행 완료! (localhost:3307)
echo 이제 IntelliJ에서 애플리케이션을 실행하세요.
echo ==============================================
pause