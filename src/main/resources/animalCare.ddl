DROP TABLE Wish CASCADE CONSTRAINTS;
DROP TABLE ReplyBoard CASCADE CONSTRAINTS;
DROP TABLE ReviewBoard CASCADE CONSTRAINTS;
DROP TABLE MyPet CASCADE CONSTRAINTS;
DROP TABLE Cart CASCADE CONSTRAINTS;
DROP TABLE Order_item CASCADE CONSTRAINTS;
DROP TABLE OrderStatus CASCADE CONSTRAINTS;
DROP TABLE Orders CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE Adopt CASCADE CONSTRAINTS;
DROP TABLE Pet CASCADE CONSTRAINTS;
DROP TABLE Visit CASCADE CONSTRAINTS;
DROP TABLE Volunteer CASCADE CONSTRAINTS;
DROP TABLE Center CASCADE CONSTRAINTS;
DROP TABLE Local CASCADE CONSTRAINTS;
DROP TABLE ReportBoard CASCADE CONSTRAINTS;
DROP TABLE Coupon CASCADE CONSTRAINTS;
DROP TABLE UserInfo CASCADE CONSTRAINTS;

CREATE TABLE UserInfo(
		user_no                       		NUMBER(10)		 NULL ,
		user_password                 		VARCHAR2(50)		 NULL ,
		user_point                    		NUMBER(10)		 NULL ,
		user_gender                   		NUMBER(10)		 NULL ,
		user_address                  		VARCHAR2(50)		 NULL ,
		user_phone_number             		VARCHAR2(50)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL ,
		user_resident_number          		VARCHAR2(50)		 NULL ,
		user_register_date            		DATE		 NULL ,
		user_name                     		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE UserInfo_user_no_SEQ;

CREATE SEQUENCE UserInfo_user_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER UserInfo_user_no_TRG
BEFORE INSERT ON UserInfo
FOR EACH ROW
BEGIN
IF :NEW.user_no IS NOT NULL THEN
  SELECT UserInfo_user_no_SEQ.NEXTVAL INTO :NEW.user_no FROM DUAL;
END IF;
END;


CREATE TABLE Coupon(
		coupon_id                     		NUMBER(10)		 NULL ,
		coupon_name                   		VARCHAR2(50)		 NULL ,
		coupon_discount               		NUMBER(10)		 NULL ,
		coupon_expiration_date        		DATE		 NULL ,
		coupon_payday                 		DATE		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE Coupon_coupon_id_SEQ;

CREATE SEQUENCE Coupon_coupon_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Coupon_coupon_id_TRG
BEFORE INSERT ON Coupon
FOR EACH ROW
BEGIN
IF :NEW.coupon_id IS NOT NULL THEN
  SELECT Coupon_coupon_id_SEQ.NEXTVAL INTO :NEW.coupon_id FROM DUAL;
END IF;
END;


CREATE TABLE ReportBoard(
		board_no                      		NUMBER(10)		 NULL ,
		board_title                   		VARCHAR2(100)		 NULL ,
		board_register_date           		DATE		 NULL ,
		board_content                 		VARCHAR2(100)		 NULL ,
		board_date                    		DATE		 NULL ,
		board_read_Count              		NUMBER(10)		 NULL ,
		board_group_no                		NUMBER(10)		 NULL ,
		board_step                    		NUMBER(10)		 NULL ,
		board_depth                   		NUMBER(10)		 NULL ,
		board_name                    		VARCHAR2(50)		 NULL ,
		board_phone                   		VARCHAR2(50)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE ReportBoard_board_no_SEQ;

CREATE SEQUENCE ReportBoard_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER ReportBoard_board_no_TRG
BEFORE INSERT ON ReportBoard
FOR EACH ROW
BEGIN
IF :NEW.board_no IS NOT NULL THEN
  SELECT ReportBoard_board_no_SEQ.NEXTVAL INTO :NEW.board_no FROM DUAL;
END IF;
END;


CREATE TABLE Local(
		local_no                      		NUMBER(10)		 NULL ,
		local_city                    		VARCHAR2(50)		 NULL ,
		local_gu                      		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Local_local_no_SEQ;

CREATE SEQUENCE Local_local_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Local_local_no_TRG
BEFORE INSERT ON Local
FOR EACH ROW
BEGIN
IF :NEW.local_no IS NOT NULL THEN
  SELECT Local_local_no_SEQ.NEXTVAL INTO :NEW.local_no FROM DUAL;
END IF;
END;


CREATE TABLE Center(
		center_no                     		NUMBER(10)		 NULL ,
		center_name                   		VARCHAR2(50)		 NULL ,
		center_phone_number           		VARCHAR2(50)		 NULL ,
		center_local                  		VARCHAR2(50)		 NULL ,
		center_open_close_time        		VARCHAR2(50)		 NULL ,
		local_no                      		NUMBER(10)		 NULL 
);

DROP SEQUENCE Center_center_no_SEQ;

CREATE SEQUENCE Center_center_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Center_center_no_TRG
BEFORE INSERT ON Center
FOR EACH ROW
BEGIN
IF :NEW.center_no IS NOT NULL THEN
  SELECT Center_center_no_SEQ.NEXTVAL INTO :NEW.center_no FROM DUAL;
END IF;
END;


CREATE TABLE Volunteer(
		volunteer_no                  		NUMBER(10)		 NULL ,
		volunteer_time                		NUMBER(10)		 NULL ,
		volunteer_date                		DATE		 NULL ,
		center_no                     		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		volunteer_status              		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Volunteer_volunteer_no_SEQ;

CREATE SEQUENCE Volunteer_volunteer_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Volunteer_volunteer_no_TRG
BEFORE INSERT ON Volunteer
FOR EACH ROW
BEGIN
IF :NEW.volunteer_no IS NOT NULL THEN
  SELECT Volunteer_volunteer_no_SEQ.NEXTVAL INTO :NEW.volunteer_no FROM DUAL;
END IF;
END;


CREATE TABLE Visit(
		visit_no                      		NUMBER(10)		 NULL ,
		visit_time                    		NUMBER(10)		 NULL ,
		visit_date                    		DATE		 NULL ,
		center_no                     		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		visit_status                  		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Visit_visit_no_SEQ;

CREATE SEQUENCE Visit_visit_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Visit_visit_no_TRG
BEFORE INSERT ON Visit
FOR EACH ROW
BEGIN
IF :NEW.visit_no IS NOT NULL THEN
  SELECT Visit_visit_no_SEQ.NEXTVAL INTO :NEW.visit_no FROM DUAL;
END IF;
END;


CREATE TABLE Pet(
		pet_local                     		VARCHAR2(50)		 NULL ,
		pet_no                        		NUMBER(10)		 NULL ,
		pet_type                      		VARCHAR2(50)		 NULL ,
		pet_gender                    		VARCHAR2(50)		 NULL ,
		pet_register_date             		DATE		 NULL ,
		pet_find_place                		VARCHAR2(50)		 NULL ,
		pet_character                 		VARCHAR2(50)		 NULL ,
		center_no                     		NUMBER(10)		 NULL ,
		local_no                      		NUMBER(10)		 NULL ,
		pet_image                     		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Pet_pet_no_SEQ;

CREATE SEQUENCE Pet_pet_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Pet_pet_no_TRG
BEFORE INSERT ON Pet
FOR EACH ROW
BEGIN
IF :NEW.pet_no IS NOT NULL THEN
  SELECT Pet_pet_no_SEQ.NEXTVAL INTO :NEW.pet_no FROM DUAL;
END IF;
END;


CREATE TABLE Adopt(
		adopt_no                      		NUMBER(10)		 NULL ,
		adopt_time                    		NUMBER(10)		 NULL ,
		adopt_date                    		DATE		 NULL ,
		adopt_status                  		VARCHAR2(50)		 NULL ,
		pet_no                        		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE Adopt_adopt_no_SEQ;

CREATE SEQUENCE Adopt_adopt_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Adopt_adopt_no_TRG
BEFORE INSERT ON Adopt
FOR EACH ROW
BEGIN
IF :NEW.adopt_no IS NOT NULL THEN
  SELECT Adopt_adopt_no_SEQ.NEXTVAL INTO :NEW.adopt_no FROM DUAL;
END IF;
END;


CREATE TABLE Product(
		product_no                    		NUMBER(10)		 NULL ,
		product_name                  		VARCHAR2(50)		 NULL ,
		product_price                 		NUMBER(10)		 NULL ,
		product_category              		VARCHAR2(50)		 NULL ,
		product_pet_category          		VARCHAR2(10)		 NULL ,
		product_qty                   		NUMBER(10)		 NULL ,
		product_image                 		VARCHAR2(50)		 NULL ,
		product_detail_image          		VARCHAR2(50)		 NULL ,
		product_star_avg              		NUMBER(10)		 NULL 
);

DROP SEQUENCE Product_product_no_SEQ;

CREATE SEQUENCE Product_product_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Product_product_no_TRG
BEFORE INSERT ON Product
FOR EACH ROW
BEGIN
IF :NEW.product_no IS NOT NULL THEN
  SELECT Product_product_no_SEQ.NEXTVAL INTO :NEW.product_no FROM DUAL;
END IF;
END;


CREATE TABLE Orders(
		order_no                      		NUMBER(10)		 NULL ,
		order_date                    		DATE		 NULL ,
		order_price                   		NUMBER(10)		 NULL ,
		order_address                 		VARCHAR2(100)		 NULL ,
		order_desc                    		VARCHAR2(100)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE Orders_order_no_SEQ;

CREATE SEQUENCE Orders_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Orders_order_no_TRG
BEFORE INSERT ON Orders
FOR EACH ROW
BEGIN
IF :NEW.order_no IS NOT NULL THEN
  SELECT Orders_order_no_SEQ.NEXTVAL INTO :NEW.order_no FROM DUAL;
END IF;
END;


CREATE TABLE OrderStatus(
		os_no                         		NUMBER(10)		 NULL ,
		os_image                      		VARCHAR2(50)		 NULL ,
		os_desc                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE OrderStatus_os_no_SEQ;

CREATE SEQUENCE OrderStatus_os_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER OrderStatus_os_no_TRG
BEFORE INSERT ON OrderStatus
FOR EACH ROW
BEGIN
IF :NEW.os_no IS NOT NULL THEN
  SELECT OrderStatus_os_no_SEQ.NEXTVAL INTO :NEW.os_no FROM DUAL;
END IF;
END;


CREATE TABLE Order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		os_no                         		NUMBER(10)		 NULL 
);

DROP SEQUENCE Order_item_oi_no_SEQ;

CREATE SEQUENCE Order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Order_item_oi_no_TRG
BEFORE INSERT ON Order_item
FOR EACH ROW
BEGIN
IF :NEW.oi_no IS NOT NULL THEN
  SELECT Order_item_oi_no_SEQ.NEXTVAL INTO :NEW.oi_no FROM DUAL;
END IF;
END;


CREATE TABLE Cart(
		cart_no                       		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		cart_image                    		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Cart_cart_no_SEQ;

CREATE SEQUENCE Cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Cart_cart_no_TRG
BEFORE INSERT ON Cart
FOR EACH ROW
BEGIN
IF :NEW.cart_no IS NOT NULL THEN
  SELECT Cart_cart_no_SEQ.NEXTVAL INTO :NEW.cart_no FROM DUAL;
END IF;
END;


CREATE TABLE MyPet(
		mypet_no                      		NUMBER(10)		 NULL ,
		mypet_name                    		VARCHAR2(50)		 NULL ,
		mypet_birthday                		DATE		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		mypet_kind                    		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE MyPet_mypet_no_SEQ;

CREATE SEQUENCE MyPet_mypet_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER MyPet_mypet_no_TRG
BEFORE INSERT ON MyPet
FOR EACH ROW
BEGIN
IF :NEW.mypet_no IS NOT NULL THEN
  SELECT MyPet_mypet_no_SEQ.NEXTVAL INTO :NEW.mypet_no FROM DUAL;
END IF;
END;


CREATE TABLE ReviewBoard(
		board_no                      		NUMBER(10)		 NULL ,
		board_title                   		VARCHAR2(100)		 NULL ,
		board_content                 		VARCHAR2(100)		 NULL ,
		board_date                    		DATE		 NULL ,
		board_star                    		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE ReviewBoard_board_no_SEQ;

CREATE SEQUENCE ReviewBoard_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER ReviewBoard_board_no_TRG
BEFORE INSERT ON ReviewBoard
FOR EACH ROW
BEGIN
IF :NEW.board_no IS NOT NULL THEN
  SELECT ReviewBoard_board_no_SEQ.NEXTVAL INTO :NEW.board_no FROM DUAL;
END IF;
END;


CREATE TABLE ReplyBoard(
		reply_board_no                		NUMBER(10)		 NOT NULL,
		reply_board_register_date     		DATE		 NULL ,
		reply_board_content           		VARCHAR2(50)		 NULL ,
		reply_board_group_no          		NUMBER(10)		 NULL ,
		reply_board_step              		NUMBER(10)		 NULL ,
		reply_board_depth             		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		board_no                      		NUMBER(10)		 NULL 
);

DROP SEQUENCE ReplyBoard_reply_board_no_SEQ;

CREATE SEQUENCE ReplyBoard_reply_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER ReplyBoard_reply_board_no_TRG
BEFORE INSERT ON ReplyBoard
FOR EACH ROW
BEGIN
IF :NEW.reply_board_no IS NOT NULL THEN
  SELECT ReplyBoard_reply_board_no_SEQ.NEXTVAL INTO :NEW.reply_board_no FROM DUAL;
END IF;
END;


CREATE TABLE Wish(
		wish_no                       		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE Wish_wish_no_SEQ;

CREATE SEQUENCE Wish_wish_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Wish_wish_no_TRG
BEFORE INSERT ON Wish
FOR EACH ROW
BEGIN
IF :NEW.wish_no IS NOT NULL THEN
  SELECT Wish_wish_no_SEQ.NEXTVAL INTO :NEW.wish_no FROM DUAL;
END IF;
END;



ALTER TABLE UserInfo ADD CONSTRAINT IDX_UserInfo_PK PRIMARY KEY (user_no);

ALTER TABLE Coupon ADD CONSTRAINT IDX_Coupon_PK PRIMARY KEY (coupon_id);
ALTER TABLE Coupon ADD CONSTRAINT IDX_Coupon_FK0 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE ReportBoard ADD CONSTRAINT IDX_ReportBoard_PK PRIMARY KEY (board_no);
ALTER TABLE ReportBoard ADD CONSTRAINT IDX_ReportBoard_FK0 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE Local ADD CONSTRAINT IDX_Local_PK PRIMARY KEY (local_no);

ALTER TABLE Center ADD CONSTRAINT IDX_Center_PK PRIMARY KEY (center_no);
ALTER TABLE Center ADD CONSTRAINT IDX_Center_FK0 FOREIGN KEY (local_no) REFERENCES Local (local_no);

ALTER TABLE Volunteer ADD CONSTRAINT IDX_Volunteer_PK PRIMARY KEY (volunteer_no);
ALTER TABLE Volunteer ADD CONSTRAINT IDX_Volunteer_FK0 FOREIGN KEY (center_no) REFERENCES Center (center_no);
ALTER TABLE Volunteer ADD CONSTRAINT IDX_Volunteer_FK1 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE Visit ADD CONSTRAINT IDX_Visit_PK PRIMARY KEY (visit_no);
ALTER TABLE Visit ADD CONSTRAINT IDX_Visit_FK0 FOREIGN KEY (center_no) REFERENCES Center (center_no);
ALTER TABLE Visit ADD CONSTRAINT IDX_Visit_FK1 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE Pet ADD CONSTRAINT IDX_Pet_PK PRIMARY KEY (pet_no);
ALTER TABLE Pet ADD CONSTRAINT IDX_Pet_FK0 FOREIGN KEY (center_no) REFERENCES Center (center_no);
ALTER TABLE Pet ADD CONSTRAINT IDX_Pet_FK1 FOREIGN KEY (local_no) REFERENCES Local (local_no);

ALTER TABLE Adopt ADD CONSTRAINT IDX_Adopt_PK PRIMARY KEY (adopt_no);
ALTER TABLE Adopt ADD CONSTRAINT IDX_Adopt_FK0 FOREIGN KEY (pet_no) REFERENCES Pet (pet_no);
ALTER TABLE Adopt ADD CONSTRAINT IDX_Adopt_FK1 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE Product ADD CONSTRAINT IDX_Product_PK PRIMARY KEY (product_no);

ALTER TABLE Orders ADD CONSTRAINT IDX_Orders_PK PRIMARY KEY (order_no);
ALTER TABLE Orders ADD CONSTRAINT IDX_Orders_FK0 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE OrderStatus ADD CONSTRAINT IDX_OrderStatus_PK PRIMARY KEY (os_no);

ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_FK0 FOREIGN KEY (order_no) REFERENCES Orders (order_no);
ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_FK1 FOREIGN KEY (product_no) REFERENCES Product (product_no);
ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_FK2 FOREIGN KEY (os_no) REFERENCES OrderStatus (os_no);

ALTER TABLE Cart ADD CONSTRAINT IDX_Cart_PK PRIMARY KEY (cart_no);
ALTER TABLE Cart ADD CONSTRAINT IDX_Cart_FK0 FOREIGN KEY (product_no) REFERENCES Product (product_no);
ALTER TABLE Cart ADD CONSTRAINT IDX_Cart_FK1 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE MyPet ADD CONSTRAINT IDX_MyPet_PK PRIMARY KEY (mypet_no);
ALTER TABLE MyPet ADD CONSTRAINT IDX_MyPet_FK0 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE ReviewBoard ADD CONSTRAINT IDX_ReviewBoard_PK PRIMARY KEY (board_no);
ALTER TABLE ReviewBoard ADD CONSTRAINT IDX_ReviewBoard_FK0 FOREIGN KEY (product_no) REFERENCES Product (product_no);
ALTER TABLE ReviewBoard ADD CONSTRAINT IDX_ReviewBoard_FK1 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

ALTER TABLE ReplyBoard ADD CONSTRAINT IDX_ReplyBoard_PK PRIMARY KEY (reply_board_no);
ALTER TABLE ReplyBoard ADD CONSTRAINT IDX_ReplyBoard_FK0 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);
ALTER TABLE ReplyBoard ADD CONSTRAINT IDX_ReplyBoard_FK1 FOREIGN KEY (board_no) REFERENCES ReportBoard (board_no);

ALTER TABLE Wish ADD CONSTRAINT IDX_Wish_PK PRIMARY KEY (wish_no);
ALTER TABLE Wish ADD CONSTRAINT IDX_Wish_FK0 FOREIGN KEY (product_no) REFERENCES Product (product_no);
ALTER TABLE Wish ADD CONSTRAINT IDX_Wish_FK1 FOREIGN KEY (user_no) REFERENCES UserInfo (user_no);

