-- userinfo insert

insert into userinfo (user_id,user_password,user_address,user_email,user_gender,user_phone_number,user_point,user_resident_number,user_resister_date) 
VALUES ('김창섭','1111','경기도','111a','남','1111',1111,'1111',sysdate);

insert into userinfo (user_id,user_password,user_address,user_email,user_gender,user_phone_number,user_point,user_resident_number,user_resister_date) 
VALUES ('박태환','2222','서울','2222a','남','2222',2222,'2222',sysdate);

insert into userinfo (user_id,user_password,user_address,user_email,user_gender,user_phone_number,user_point,user_resident_number,user_resister_date) 
VALUES ('전아현','3333','강원도','3333a','여','3333',3333,'3333',sysdate);	

-- dog product insert

insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '우프니 독 크런치 밀크 210g', 7200, '간식', 0, 'cat.jpg', 5, '강아지', 'cat.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '우프니 독 크런치 고구마 210g', 7200, '간식', 0, 'cat.jpg', 3, '강아지', 'cat.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '우프니 독 크런치 BBQ', 7200, '간식', 0, 'cat.jpg', 3, '강아지', 'cat.jpg');

-- cat product insert

insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '뉴트리플랜 흰살참치 닭가슴살', 1500, '캔', 0, 'cat.jpg', 5, '고양이', 'cat.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '뉴트리플랜 흰살참치 게맛살', 1500, '캔', 0, 'cat.jpg', 3, '고양이', 'cat.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '뉴트리플랜 흰살참치 멸치', 1500, '캔', 0, 'cat.jpg', 3, '고양이', 'cat.jpg');


-- cart insert

insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 1, 1, '김창섭');
insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 2, 2, '김창섭');
insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 3, 3, '김창섭');

insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 1, 4, '박태환');
insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 2, 5, '박태환');

insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 2, 11, '전아현');
insert into cart(cart_no, cart_qty, product_no, user_id) values(cart_cart_no_SEQ.nextval, 3, 12, '전아현');

-- pet insert

insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,petgender,center_no) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','ㅁㅁ',sysdate,'프렌치불독','남',11);
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,petgender,center_no) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','짖는다','골목',sysdate,'퍼그','여',11);

-- center insert

INSERT INTO center (center_no, center_name, center_phone_number, center_local, center_open_close_time) VALUES ('11','안녕보호소','010-1111-1111','서울시','09:00 ~ 21:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_local, center_open_close_time) VALUES ('22','사랑보호소','010-2222-2222','경기도','09:00 ~ 22:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_local, center_open_close_time) VALUES ('33','하하보호소','010-3333-3333','강원도','09:00 ~ 23:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_local, center_open_close_time) VALUES ('44','소소보호소','010-4444-4444','충청도','09:00 ~ 24:00');

-- adopt insert

INSERT INTO adopt (adopt_no, adopt_time, adopt_date, status, user_id, pet_no) VALUES(adopt_no_seq.nextval, 11, sysdate, '입양완료', '김창섭', 1);
INSERT INTO adopt (adopt_no, adopt_time, adopt_date, status, user_id, pet_no) VALUES(adopt_no_seq.nextval, 15, sysdate, '입양중', '박태환', 2);

-- mypet insert

insert into my_pet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_id) 
VALUES (mypet_mypet_no_seq.nextval,'보리','강아지',TO_DATE('2022/04/05','YYYY/MM/DD'),'박태환');

insert into my_pet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_id) 
VALUES (mypet_mypet_no_seq.nextval,'율무','강아지',TO_DATE('2022/11/11','YYYY/MM/DD'),'전아현');

insert into my_pet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_id) 
VALUES (mypet_mypet_no_seq.nextval,'나비','고양이',TO_DATE('2022/07/05','YYYY/MM/DD'),'김창섭');

-- order insert


insert into orders(order_no,order_address,order_desc,order_date,order_price,user_id) 
VALUES (orders_order_no_seq.nextval,'서울특별시','사료외..',sysdate,'55555','박태환');

insert into orders(order_no,order_address,order_desc,order_date,order_price,user_id) 
VALUES (orders_order_no_seq.nextval,'서울특별시','사료외..',sysdate,'33333','박태환');

insert into orders(order_no,order_address,order_desc,order_date,order_price,user_id) 
VALUES (orders_order_no_seq.nextval,'서울특별시','사료외..',sysdate,'2222','전아현');

-- coupon insert

insert into coupon (coupon_id,coupon_name,coupon_discount,coupon_payday,coupon_expiration_date,user_id) 
VALUES (coupon_id_seq.nextval,'생일쿠폰',30,TO_DATE('2023/04/05','YYYY/MM/DD'),TO_DATE('2023/06/04','YYYY/MM/DD'),'전아현');

-- volunteer insert

INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(01, 11, sysdate, '봉사접수중', '김창섭', 11);
INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(02, 13, sysdate, '심사중', '박태환', 22);
INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(03, 15, sysdate, '봉사완료', '전아현', 22);
INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(04, 10, sysdate, '심사중', '전아현', 11);
INSERT INTO volunteer (volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_id, center_no) VALUES(05, 17, sysdate, '봉사접수중', '김창섭', 22);

-- report board

insert into report_board (board_no,board_content,board_date,board_depth,board_group_no,board_name,board_phone,board_read_count,board_resister_date,board_step,board_title,user_id) 
VALUES (board_no_seq.nextval,'내용',to_date('2022/03/11','YYYY/MM/DD'),0,1,'전아현','1111',0,sysdate,0,'토토어디갓어','전아현');

insert into report_board (board_no,board_content,board_date,board_depth,board_group_no,board_name,board_phone,board_read_count,board_resister_date,board_step,board_title,user_id) 
VALUES (board_no_seq.nextval,'내용',to_date('2022/03/11','YYYY/MM/DD'),0,1,'박태환','1111',0,sysdate,0,'어디갓어','박태환');

insert into report_board (board_no,board_content,board_date,board_depth,board_group_no,board_name,board_phone,board_read_count,board_resister_date,board_step,board_title,user_id) 
VALUES (board_no_seq.nextval,'내용',to_date('2022/03/11','YYYY/MM/DD'),0,1,'김창섭','1111',0,sysdate,0,'어디갓어2','김창섭');

insert into report_board (board_no,board_content,board_date,board_depth,board_group_no,board_name,board_phone,board_read_count,board_resister_date,board_step,board_title,user_id) 
VALUES (board_no_seq.nextval,'내용',to_date('2022/03/11','YYYY/MM/DD'),0,1,'김창섭','1111',0,sysdate,0,'어디갓어3','김창섭');

-- review board

INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (1, sysdate, '타이틀1', '내용1', 5, '전아현');
INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (2, sysdate, '타이틀2', '내용2', 4, '김창섭');
INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (3, sysdate, '타이틀3', '내용3', 3, '전아현');
INSERT INTO review_board (review_board.board_no, board_date, board_title, board_content, board_star, user_id) VALUES (4, sysdate, '타이틀4', '내용4', 1, '박태환');