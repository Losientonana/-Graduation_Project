3/27일

데이터 베이스에 쿼리문을 통해 Book_entity를 생성했고, 사용자가 대여를 하면, rental state를 1에서 0으로 바꿨다.

주의할점 쿼리문으로 만든 DB의 이름과 jpa로 만든 이름의 혼돈으로 문제가 발생할 수 있음.

3/28일
유저와 맞게 책을 빌리면 rentalTable에 업데이트가 되게 만들었다.

하지만, rental_Table에 rental_state는 삭제해야 할것 같고,

Book_entity에서 Rentalstate가 0인 책은 빌릴 수 없게 제한을 다시 걸어야 할 것 같다.
