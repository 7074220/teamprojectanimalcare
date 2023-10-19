INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(01, 11, sysdate, '봉사접수중', '김창섭', 11);
INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(02, 13, sysdate, '심사중', '박태환', 22);
INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(03, 15, sysdate, '봉사완료', '전아현', 22);



INSERT INTO center (center_no, center_name, center_phone_number, center_local, center_open_close_time)
VALUES ('11','안녕보호소','010-1111-1111','서울시','09:00 ~ 21:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_local, center_open_close_time)
VALUES ('22','사랑보호소','010-2222-2222','경기도','09:00 ~ 22:00');


select * from review_board b join userinfo u on b.user_id = u.user_id ORDER by board_star desc;

INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (1, sysdate, '타이틀1', '내용1', 5, '전아현');
INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (2, sysdate, '타이틀2', '내용2', 4, '김창섭');
INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (3, sysdate, '타이틀3', '내용3', 3, '전아현');
INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (4, sysdate, '타이틀4', '내용4', 1, '박태환');

