3/27일
데이터 베이스에 쿼리문을 통해 Book_entity를 생성했고, 사용자가 대여를 하면, rental state를 1에서 0으로 바꿨다.
주의할점 쿼리문으로 만든 DB의 이름과 jpa로 만든 이름의 혼돈으로 문제가 발생할 수 있음.

3/28일
유저와 맞게 책을 빌리면 rentalTable에 업데이트가 되게 만들었다.
하지만, rental_Table에 rental_state는 삭제해야 할것 같고,
Book_entity에서 Rentalstate가 0인 책은 빌릴 수 없게 제한을 다시 걸어야 할 것 같다.

3/29일
회원별 책 대여 제한 x, 이미 빌린책은 대여 x, 책 반납로직 o, 로봇의 상태를 확인하는 통신 미구현,

3/31일
Controller에서 Entity를 직접 받는 방식이 부적합하다고 판단하여, MappingMapper을 이용하여 DTO객체로 변환하는 방식으로 수정
반납로직을 이용시, DB에 Return 시간을 남기는 방식 추가
사용자별 빌린 책, 빌린 시간 확인 기능 추가

4월2일
login성공시 response Body에 userID를 반환

4월4일
1. user_entity 와 admin_entity로 분리(app,cms)
2. login_code, login_state,login_time으로 변경(used_time은 메소드를 호출하여 현재시간 - login_time)
3. book_entity(country,description,publishedDate 추가)
4. 경로 분리
5. 데이터 베이스 수정
5. rental 테스트 성공(예외 테스트를 좀 해봐야함)
6. return 테스트 성공
7. application 로그인 테스트 성공
8. admin 회원가입 및 로그인 테스트 성공
9. admin 권한으로 main페이지 접속 테스트 성공

4/5일
1. login시 로그인 시작시간 기록
2. 사용자들의 현재까지 사용시간 요청 api 개발
3. 대여중인 책 요청시 , 예약으로 넣고, 예약중인 책 반납하면, 대여리스트로 넘기는 로직 구현
4. 각 파트에 걸맞는 return값 구현
5. Swagger 재연동

다음:
Swagger 정리 및 각종 예외처리 테스트


4/11일

Notion에 api 명세서 업데이트
logout로직 구현




![image](https://github.com/Losientonana/-Graduation_Project/assets/118197691/d5bb6370-b5e0-4943-a747-f1e1061cac12)





4/25일 Notion에 api 명세서 업데이트

logout시에 Response Body 변경
상품리스트 만들고, 주문 로직 구현
Admin을 위한 전체테이블 정보, 현재 사용중인 테이블 이용시간 및 요금 조회 기능
Admin을 위한 상품 주문내역, 책 대여내역, 책 예약내역 구현





5월2일 
STOMP를 사용하여,
책 대여,반납 api호출시 locationInfo를 
/sub/channel/eddy 경로를 구독한 클라이언트들에게 뿌림
추후 고려해야할 사항: 
1. 책대여,책예약,책반납(그냥반납),책반납(예약된책 반납),로그아웃(예약된 책 모두 반납하고 예약가능하게 바꾸기) 중 어떤부분에 어떻게 메시지를 전달할 것인가?
2. 책대여, 책예약, 책반납시 전부 locationInfo를 지금 앱에 주고있는데, 앞으로 바뀌는 로직에 맞춰서 무엇을 주는게 맞는것일까?


5월 13일
1. testMethodForReserve 예약에 필요한 메소드 만들기(bookId)
    1. rental_state중 파라미터로 넘어온 bookId중 rental_state가 1이 있으면 Boolean리턴)
2. cancelReserve 반납에 필요한 메소드 만들기(bookId)
    1. rental_state중 파라미터로 넘어온 bookId중 rental_state가 1이 있으면 Boolean리턴
    2. reservation중 bookId에 맞는 가장 처음 빌린 컬럼 자체 리턴
3. cancelReserve 예약취소 만들기(userid)


5월 29일
1. STOMP를 통해 라즈베리 카메라로부터 들어오는 보관함 상태를 메모리 변수에 계속 업데이트
2. 아래 형식으로 api호출시 MobilePlatform에 전달
  1. 책 꽂이에서 대여
책 위치(bookLocation), 사용자 위치(userLocation), 책id(bookId) ,사용가능한 보관함 위치(assignedRegion)

2. 반납
(userLocation), 책id(bookId) ,사용가능한 보관함 위치(assignedRegion)

 3. 예약한책 누가 반납해서 갖다줘야함
반납사용자 위치(startPoint), 예약한사용자 위치(endPoint), 책id(bookId), 사용가능한 보관함 위치(assignedRegion)
