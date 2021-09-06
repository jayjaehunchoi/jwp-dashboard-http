# HTTP 서버 구현하기


## 세션, 토큰

invalidate() 는 세션 초기화 시에 사용한다.

세션 흐름

로그인시
- 세션이 없는 경우
  - 새로운 새션을 만들어서 부여한다.
  
- 세션이 있는 경우
  - 인증해준다.
  
- 세션이 유효하지 않은 경우
  - 일정 시간이 지나면 세션을 invalidate시킨다.(이론상)
  - 유효하지 않은 경우 새로운 세션을 만들어준다.

