-- userinfo insert

insert into userinfo (user_no,user_id,user_password,user_address,user_gender,user_phone_number,user_point,user_resident_number,user_register_date, user_name) 
VALUES (userinfo_user_no_seq.nextval,'aaa@naver.com','1017','분당','남','010-7777-1111',0,'1111',sysdate, '김창섭');

insert into userinfo (user_no,user_id,user_password,user_address,user_gender,user_phone_number,user_point,user_resident_number,user_register_date, user_name) 
VALUES (userinfo_user_no_seq.nextval,'bbb@naver.com','1011','서울','남','010-7111-1111',0,'2222',sysdate, '박태환');

insert into userinfo (user_no,user_id,user_password,user_address,user_gender,user_phone_number,user_point,user_resident_number,user_register_date, user_name) 
VALUES (userinfo_user_no_seq.nextval,'ccc@naver.com','0707','부산','여','010-1234-1111',0,'3333',sysdate, '전아현');


-- dog product insert

--insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '우프니 독 크런치 밀크 210g', 7200, '간식', 0, 'cat.jpg', 5, '강아지', 'cat.jpg');
--insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '우프니 독 크런치 고구마 210g', 7200, '간식', 0, 'cat.jpg', 3, '강아지', 'cat.jpg');
--insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '우프니 독 크런치 BBQ', 7200, '간식', 0, 'cat.jpg', 3, '강아지', 'cat.jpg');

-- cat product insert

insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '이나바 챠오츄르 파우치 참치 연어 14g x 4개', 1780, '간식', 0, 'inaba_ciao_churu_tuna_salmon.jpg', 3, '고양이', 'inaba_ciao_churu_detail.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '이나바 챠오츄르 파우치 헤어볼 참치 14g x 4개', 1780, '간식', 0, 'inaba_ciao_churu_tuna.jpg', 5, '고양이', 'inaba_ciao_churu_detail.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '이나바 챠오츄르 파우치 닭가슴살 게살 14g X 4개', 1780, '간식', 0, 'inaba_ciao_churu_chicken_crab.jpg', 4, '고양이', 'inaba_ciao_churu_detail.jpg');
insert into product(product_no, product_name, product_price, product_category, product_qty, product_image, product_star_avg, product_pet_category, product_detail_image) values(product_product_no_SEQ.nextval, '이나바 챠오츄르 파우치 가다랑어 14g X 4개', 1780, '간식', 0, 'inaba_ciao_churu_bonito.jpg', 4, '고양이', 'inaba_ciao_churu_detail.jpg');

-- cart insert

insert into cart(cart_no, cart_qty, product_no, user_no) values(cart_cart_no_SEQ.nextval, 2, 2, 1);
insert into cart(cart_no, cart_qty, product_no, user_no) values(cart_cart_no_SEQ.nextval, 3, 3, 1);

insert into cart(cart_no, cart_qty, product_no, user_no) values(cart_cart_no_SEQ.nextval, 1, 1, 2);
insert into cart(cart_no, cart_qty, product_no, user_no) values(cart_cart_no_SEQ.nextval, 2, 2, 2);

insert into cart(cart_no, cart_qty, product_no, user_no) values(cart_cart_no_SEQ.nextval, 2, 1, 3);
insert into cart(cart_no, cart_qty, product_no, user_no) values(cart_cart_no_SEQ.nextval, 3, 2, 3);


-- center insert

INSERT INTO center (center_no, center_name, center_phone_number, center_image, center_local, center_open_close_time) VALUES (Center_center_no_SEQ.nextval,'용인시 동물보호센터','031-324-3463','yongin.jpeg','용인시','09:00 ~ 18:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_image, center_local, center_open_close_time) VALUES (Center_center_no_SEQ.nextval,'시흥시 동물누리 보호센터','0507-1317-6943','sihung.jpeg','시흥시','09:00 ~ 18:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_image, center_local, center_open_close_time) VALUES (Center_center_no_SEQ.nextval,'안녕보호소','010-1111-1111','yongin.jpeg','서울시','09:00 ~ 21:00');
INSERT INTO center (center_no, center_name, center_phone_number, center_image, center_local, center_open_close_time) VALUES (Center_center_no_SEQ.nextval,'안녕보호소','010-1111-1111','yongin.jpeg','서울시','09:00 ~ 21:00');


-- pet insert
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','수컷',1,'강아지1.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'제주도','온순하다','서울특별시',sysdate,'강아지','수컷',1,'강아지2.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'강원도','온순하다','서울특별시',sysdate,'강아지','수컷',1,'강아지3.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'충청남도','온순하다','서울특별시',sysdate,'강아지','수컷',1,'강아지4.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'강원도','온순하다','서울특별시',sysdate,'강아지','수컷',1,'강아지5.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'충청북도','온순하다','서울특별시',sysdate,'강아지','암컷',1,'강아지6.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',1,'강아지7.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',1,'강아지8.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',1,'강아지9.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',1,'강아지10.jpeg');

insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',1,'dog101.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',2,'dog102.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'강아지','암컷',3,'dog103.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경기도','온순하다','경기도',sysdate,'강아지','암컷',4,'dog104.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경기도','온순하다','경기도',sysdate,'강아지','암컷',1,'dog105.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경기도','온순하다','경기도',sysdate,'강아지','암컷',2,'dog106.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경기도','온순하다','경기도',sysdate,'강아지','암컷',3,'dog107.jpg');

insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시',sysdate,'고양이','암컷',1,'cat100.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경기도','귀엽다','경기도',sysdate,'고양이','암컷',2,'cat101.jpg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'강원도','작다','강원도',sysdate,'고양이','암컷',3,'cat102.jpg');





insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시 강남구',sysdate,'고양이','수컷',1,'고양이1.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'제주도','온순하다','제주도 서귀포시',sysdate,'고양이','수컷',1,'고양이2.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'강원도','온순하다','강원도 양양군',sysdate,'고양이','수컷',1,'고양이3.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'충청남도','온순하다','충청남도 보령시',sysdate,'고양이','수컷',1,'고양이4.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'서울특별시','온순하다','서울특별시 ',sysdate,'고양이','암컷',1,'고양이5.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'충청남도','온순하다','충청남도 서천군',sysdate,'고양이','암컷',1,'고양이6.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'강원도','온순하다','강원도 강릉시',sysdate,'고양이','암컷',1,'고양이7.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'충청북도','온순하다','충청북도 청주시',sysdate,'고양이','암컷',1,'고양이8.jpeg');
insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경상남도','온순하다','경상남도 울산시',sysdate,'고양이','암컷',1,'고양이9.jpeg');

insert into pet(pet_no,pet_local,pet_character,pet_find_place,pet_register_date,pet_type,pet_gender,center_no,pet_image) 
VALUES (pet_pet_no_seq.nextval,'경상북도','온순하다','경상북도 구미시',sysdate,'고양이','수컷',1,'고양이10.jpeg');

-- adopt insert

INSERT INTO adopt (adopt_no, adopt_time, adopt_date, pet_no, user_no, adopt_status ) VALUES(adopt_adopt_no_seq.nextval, 1, sysdate, 1, 1, '입양완료');
INSERT INTO adopt (adopt_no, adopt_time, adopt_date, pet_no, user_no, adopt_status ) VALUES(adopt_adopt_no_seq.nextval, 2, sysdate, 2, 2, '입양중');

-- mypet insert

insert into mypet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_no) 
VALUES (mypet_mypet_no_seq.nextval,'보리','강아지',TO_DATE('2022/10/30','YYYY/MM/DD'),1);

insert into mypet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_no) 
VALUES (mypet_mypet_no_seq.nextval,'율무','강아지',TO_DATE('2022/10/30','YYYY/MM/DD'),2);

insert into mypet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_no) 
VALUES (mypet_mypet_no_seq.nextval,'나비','고양이',TO_DATE('2022/10/30','YYYY/MM/DD'),3);


insert into mypet (mypet_no,mypet_name,mypet_kind,mypet_birthday,user_no) 
VALUES (mypet_mypet_no_seq.nextval,'토토','고양이',TO_DATE('2022/10/30','YYYY/MM/DD'),1);

-- order insert


insert into orders(order_no,order_address,order_desc,order_date,order_price,user_no) 
VALUES (orders_order_no_seq.nextval,'서울특별시','사료외..',sysdate,'55555',1);

insert into orders(order_no,order_address,order_desc,order_date,order_price,user_no) 
VALUES (orders_order_no_seq.nextval,'서울특별시','사료외..',sysdate,'33333',2);

insert into orders(order_no,order_address,order_desc,order_date,order_price,user_no) 
VALUES (orders_order_no_seq.nextval,'서울특별시','사료외..',sysdate,'2222',3);

-- coupon insert

insert into coupon (coupon_id,coupon_name,coupon_discount,coupon_payday,coupon_expiration_date,user_no) 
VALUES (Coupon_coupon_id_SEQ.nextval,'생일쿠폰',30,TO_DATE('2023/11/06','YYYY/MM/DD'),TO_DATE('2023/11/25','YYYY/MM/DD'),17);

-- volunteer insert

INSERT INTO volunteer(volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_no, center_no)
values(Volunteer_volunteer_no_SEQ.nextval, 11, sysdate, '봉사신청',  1, 1);

INSERT INTO volunteer(volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_no, center_no)
values(Volunteer_volunteer_no_SEQ.nextval, 13, sysdate, '봉사중',  2, 2);

INSERT INTO volunteer(volunteer_no, volunteer_time, volunteer_date, volunteer_status, user_no, center_no)
values(Volunteer_volunteer_no_SEQ.nextval, 18, sysdate, '봉사완료',  3, 3);

-- report board

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'3일째 못찾고 있습니다 꼭 좀 연락부탁드려요 ㅠㅠ',to_date('2023/10/20','YYYY/MM/DD'),'전아현','010-7846-9215','야탑동 성당 앞',0,sysdate,'[실종]보리를 찾습니다',1,'dog001.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'사진이 비슷해요 이 강아지 보리같습니다!',to_date('2023/10/21','YYYY/MM/DD'),'장희주','010-4752-2231','구서동 라찌호텔 앞',0,sysdate,'[제보]보리를 찾은것같습니다',2,'dog001.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'귀찮으시겠지만 저희 가족이 애타게 찾고있습니다 꼭 좀 많은 관심 부탁드립니다.',to_date('2023/10/22','YYYY/MM/DD'),'박서진','010-1783-2346','온천동 농심호텔 앞',0,sysdate,'[실종]해피를 찾고싶어요',3,'dog002.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'이 강아지 루리 아닌가요? 많이 비슷한거같아요',to_date('2023/10/23','YYYY/MM/DD'),'허승범','010-1783-2346','서동 서동미로시장 안',0,sysdate,'[제보]루리를 찾았어요',4,'dog002.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'우리 구피가 문이 열려있는사이에 나가버렸어요ㅠㅠ 보시면 꼭 연락좀 부탁드립니다ㅠㅠ',to_date('2023/10/24','YYYY/MM/DD'),'이다영','010-2987-4287','신세계 백화점 지하',0,sysdate,'[실종]구피가 없어졌어요ㅠㅠ',5,'dog003.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'애매하네여 구피인것같은데....맞나여?',to_date('2023/10/25','YYYY/MM/DD'),'김숙현','010-7412-6532','정자동 탄천 앞에서 ',0,sysdate,'[제보]구피인것 같기도...',6,'dog003.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'아니 분명히 묶어놨는데 어떻게 나간건지 모르겠어요 발견하면 연락부탁드립니다....',to_date('2023/10/26','YYYY/MM/DD'),'최재용','010-5813-9414','선유도 공원 세븐일레븐 앞에서',0,sysdate,'[실종]집나간 강아지 찾습니다',7,'dog004.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'혹시나 해서 올려봅니다',to_date('2023/10/27','YYYY/MM/DD'),'윤호진','010-6341-9987','서면 롯데백화점 버스정거장 앞',0,sysdate,'[제보]유기견같은데...',8,'dog004.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'우리애가 갑자기 없어졌어요 ㅠㅠ',to_date('2023/10/28','YYYY/MM/DD'),'김창섭','010-7531-9512','부산대학교 앞',0,sysdate,'[실종]갑자기 없어졌어요',9,'dog005.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'역 앞에서 찾은것 같아요',to_date('2023/10/29','YYYY/MM/DD'),'정찬영','010-8523-4769','부산대학교 역 앞',0,sysdate,'[제보]찾은것 같습니다',10,'dog006.jpg');

insert into reportboard (board_no,board_content,board_find_date,board_find_name,board_find_phone,board_find_place,board_readcount,board_register_date,board_title,user_no,board_image) 
VALUES (ReportBoard_board_no_SEQ.nextval,'역 앞에서 찾은것 같아요',to_date('2023/10/29','YYYY/MM/DD'),'정찬영','010-8523-4769','부산대학교 역 앞',0,sysdate,'[제보]찾은것 같습니다',11,'dog007.jpg');

-- review board

INSERT INTO reviewboard (board_no, board_date, board_title, board_content, board_star, product_no, user_no)
VALUES (review_board_board_no_seq.nextval, sysdate, '이것은 타이틀1', '이것은 내용1', 5, 1, 1);

INSERT INTO reviewboard (board_no, board_date, board_title, board_content, board_star, product_no, user_no)
VALUES (review_board_board_no_seq.nextval, sysdate, '이것은 타이틀2', '이것은 내용2', 4, 2, 2);

INSERT INTO reviewboard (board_no, board_date, board_title, board_content, board_star, product_no, user_no)
VALUES (review_board_board_no_seq.nextval, sysdate, '이것은 타이틀3', '이것은 내용3', 3, 3, 3);

-- visit
INSERT INTO visit (VISIT_NO,VISIT_DATE, VISIT_TIME, VISIT_STATUS, CENTER_NO, USER_NO) VALUES (visit_visit_no_seq.nextval,  sysdate, 11,'봉사접수중', 1, 1);
INSERT INTO visit (VISIT_NO,VISIT_DATE, VISIT_TIME, VISIT_STATUS, CENTER_NO, USER_NO) VALUES (visit_visit_no_seq.nextval,  sysdate, 12,'봉사접수중', 2, 2);
INSERT INTO visit (VISIT_NO,VISIT_DATE, VISIT_TIME, VISIT_STATUS, CENTER_NO, USER_NO) VALUES (visit_visit_no_seq.nextval,  sysdate, 13,'봉사접수중', 3, 3);

-- Reply board
INSERT INTO replyboard (reply_board_no,reply_board_content,reply_board_depth,reply_board_group_no,reply_board_register_date,reply_board_step,user_no,board_no) 
VALUES (ReplyBoard_reply_board_no_SEQ.nextval,'빨리 찾길빌어요 ㅠㅠ',0,1,sysdate,0,29,1);

INSERT INTO replyboard (reply_board_no,reply_board_content,reply_board_depth,reply_board_group_no,reply_board_register_date,reply_board_step,user_no,board_no) 
VALUES (ReplyBoard_reply_board_no_SEQ.nextval,'마음 아프다...',0,1,sysdate,0,28,1);

-- orderStatus
insert into orderstatus(os_no,os_image,os_desc) 
VALUES (1,'주문확인.jpg','주문확인');

insert into orderstatus(os_no,os_image,os_desc) 
VALUES (2,'배송준비.jpg','배송준비');

insert into orderstatus(os_no,os_image,os_desc) 
VALUES (3,'배송중.jpg','배송중');

insert into orderstatus(os_no,os_image,os_desc) 
VALUES (4,'배송완료.jpg','배송완료');


-- wishlist
insert into wish(wish_no, product_no, user_no) values(wish_wish_no_seq.nextval, 1, 19);

insert into wish(wish_no, product_no, user_no) values(wish_wish_no_seq.nextval, 2, 19);

insert into wish(wish_no, product_no, user_no) values(wish_wish_no_seq.nextval, 3, 19);

commit;