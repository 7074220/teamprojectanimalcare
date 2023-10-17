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
DROP TABLE ReportBoard CASCADE CONSTRAINTS;
DROP TABLE Coupon CASCADE CONSTRAINTS;
DROP TABLE UserInfo CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: UserInfo */
/**********************************/
CREATE TABLE UserInfo(
		user_id                       		VARCHAR2(50)		 NULL ,
		user_password                 		VARCHAR2(50)		 NULL ,
		user_point                    		NUMBER(10)		 NULL ,
		user_birthday                 		VARCHAR2(100)		 NULL ,
		user_age                      		NUMBER(50)		 NULL ,
		user_gender                   		NUMBER(10)		 NULL ,
		user_address                  		VARCHAR2(50)		 NULL ,
		user_phone_number             		NUMBER(20)		 NULL ,
		user_email                    		VARCHAR2(30)		 NULL ,
		user_resident_number          		VARCHAR2(50)		 NULL ,
		user_resister_date            		VARCHAR2(100)		 NULL 
);

COMMENT ON TABLE UserInfo is 'UserInfo';
COMMENT ON COLUMN UserInfo.user_id is 'user_id';
COMMENT ON COLUMN UserInfo.user_password is 'user_password';
COMMENT ON COLUMN UserInfo.user_point is 'user_point';
COMMENT ON COLUMN UserInfo.user_birthday is 'user_birthday';
COMMENT ON COLUMN UserInfo.user_age is 'user_age';
COMMENT ON COLUMN UserInfo.user_gender is 'user_gender';
COMMENT ON COLUMN UserInfo.user_address is 'user_address';
COMMENT ON COLUMN UserInfo.user_phone_number is 'user_phone_number';
COMMENT ON COLUMN UserInfo.user_email is 'user_email';
COMMENT ON COLUMN UserInfo.user_resident_number is 'user_resident_number';
COMMENT ON COLUMN UserInfo.user_resister_date is 'user_resister_date';


/**********************************/
/* Table Name: Coupon */
/**********************************/
CREATE TABLE Coupon(
		coupon_id                     		VARCHAR2(30)		 NULL ,
		coupon_name                   		VARCHAR2(20)		 NULL ,
		coupon_discount               		NUMBER(10)		 NULL ,
		coupon_expiration_date        		NUMBER(20)		 NULL ,
		coupon_payday                 		VARCHAR2(50)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Coupon_coupon_id_SEQ;

CREATE SEQUENCE Coupon_coupon_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Coupon is 'Coupon';
COMMENT ON COLUMN Coupon.coupon_id is 'coupon_id';
COMMENT ON COLUMN Coupon.coupon_name is 'coupon_name';
COMMENT ON COLUMN Coupon.coupon_discount is 'coupon_discount';
COMMENT ON COLUMN Coupon.coupon_expiration_date is 'coupon_expiration_date';
COMMENT ON COLUMN Coupon.coupon_payday is 'coupon_payday';
COMMENT ON COLUMN Coupon.user_id is 'user_id';


/**********************************/
/* Table Name: ReportBoard */
/**********************************/
CREATE TABLE ReportBoard(
		board_no                      		NUMBER(50)		 NULL ,
		board_title                   		VARCHAR2(100)		 NULL ,
		board_register_date           		DATE		 NULL ,
		board_content                 		VARCHAR2(100)		 NULL ,
		board_date                    		DATE		 NULL ,
		board_readCount               		NUMBER(10)		 NULL ,
		board_groupno                 		NUMBER(10)		 NULL ,
		board_step                    		NUMBER(10)		 NULL ,
		board_depth                   		NUMBER(10)		 NULL ,
		board_name                    		VARCHAR2(50)		 NULL ,
		board_phone                   		VARCHAR2(50)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE ReportBoard_board_no_SEQ;

CREATE SEQUENCE ReportBoard_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE ReportBoard is 'ReportBoard';
COMMENT ON COLUMN ReportBoard.board_no is 'board_no';
COMMENT ON COLUMN ReportBoard.board_title is 'board_title';
COMMENT ON COLUMN ReportBoard.board_register_date is 'board_register_date';
COMMENT ON COLUMN ReportBoard.board_content is 'board_content';
COMMENT ON COLUMN ReportBoard.board_date is 'board_date';
COMMENT ON COLUMN ReportBoard.board_readCount is 'board_readCount';
COMMENT ON COLUMN ReportBoard.board_groupno is 'board_groupno';
COMMENT ON COLUMN ReportBoard.board_step is 'board_step';
COMMENT ON COLUMN ReportBoard.board_depth is 'board_depth';
COMMENT ON COLUMN ReportBoard.board_name is 'board_name';
COMMENT ON COLUMN ReportBoard.board_phone is 'board_phone';
COMMENT ON COLUMN ReportBoard.user_id is 'user_id';


/**********************************/
/* Table Name: Volunteer */
/**********************************/
CREATE TABLE Volunteer(
		volunteer_no                  		NUMBER(100)		 NULL ,
		volunteer_time                		NUMBER(100)		 NULL ,
		volunteer_date                		DATE		 NULL ,
		volunteer_center              		VARCHAR2(100)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Volunteer_volunteer_no_SEQ;

CREATE SEQUENCE Volunteer_volunteer_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Volunteer is 'Volunteer';
COMMENT ON COLUMN Volunteer.volunteer_no is 'volunteer_no';
COMMENT ON COLUMN Volunteer.volunteer_time is 'volunteer_time';
COMMENT ON COLUMN Volunteer.volunteer_date is 'volunteer_date';
COMMENT ON COLUMN Volunteer.volunteer_center is 'volunteer_center';
COMMENT ON COLUMN Volunteer.user_id is 'user_id';


/**********************************/
/* Table Name: Visit */
/**********************************/
CREATE TABLE Visit(
		visit_no                      		NUMBER(100)		 NULL ,
		visit_time                    		NUMBER(100)		 NULL ,
		visit_date                    		DATE		 NULL ,
		visit_center                  		VARCHAR2(100)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Visit_visit_no_SEQ;

CREATE SEQUENCE Visit_visit_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Visit is 'Visit';
COMMENT ON COLUMN Visit.visit_no is 'visit_no';
COMMENT ON COLUMN Visit.visit_time is 'visit_time';
COMMENT ON COLUMN Visit.visit_date is 'visit_date';
COMMENT ON COLUMN Visit.visit_center is 'visit_center';
COMMENT ON COLUMN Visit.user_id is 'user_id';


/**********************************/
/* Table Name: Pet */
/**********************************/
CREATE TABLE Pet(
		pet_local                     		VARCHAR2(50)		 NULL ,
		pet_no                        		NUMBER(30)		 NULL ,
		pet_type                      		VARCHAR2(50)		 NULL ,
		pet_gender                    		VARCHAR2(50)		 NULL ,
		pet_register_date             		DATE		 NULL ,
		pet_find_place                		NUMBER(30)		 NULL ,
		pet_character                 		VARCHAR2(50)		 NULL ,
		pet_center                    		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Pet_pet_no_SEQ;

CREATE SEQUENCE Pet_pet_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Pet is 'Pet';
COMMENT ON COLUMN Pet.pet_local is 'pet_local';
COMMENT ON COLUMN Pet.pet_no is 'pet_no';
COMMENT ON COLUMN Pet.pet_type is 'pet_type';
COMMENT ON COLUMN Pet.pet_gender is 'pet_gender';
COMMENT ON COLUMN Pet.pet_register_date is 'pet_register_date';
COMMENT ON COLUMN Pet.pet_find_place is 'pet_find_place';
COMMENT ON COLUMN Pet.pet_character is 'pet_character';
COMMENT ON COLUMN Pet.pet_center is 'pet_center';


/**********************************/
/* Table Name: Adopt */
/**********************************/
CREATE TABLE Adopt(
		adopt_no                      		NUMBER(10)		 NULL ,
		adopt_time                    		NUMBER(100)		 NULL ,
		adopt_date                    		DATE		 NULL ,
		pet_no                        		NUMBER(30)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Adopt_adopt_no_SEQ;

CREATE SEQUENCE Adopt_adopt_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Adopt is 'Adopt';
COMMENT ON COLUMN Adopt.adopt_no is 'adopt_no';
COMMENT ON COLUMN Adopt.adopt_time is 'adopt_time';
COMMENT ON COLUMN Adopt.adopt_date is 'adopt_date';
COMMENT ON COLUMN Adopt.pet_no is 'pet_no';
COMMENT ON COLUMN Adopt.user_id is 'user_id';


/**********************************/
/* Table Name: Product */
/**********************************/
CREATE TABLE Product(
		product_no                    		NUMBER(50)		 NULL ,
		product_name                  		VARCHAR2(30)		 NULL ,
		product_price                 		NUMBER(50)		 NULL ,
		product_category              		VARCHAR2(50)		 NULL ,
		product_amount                		NUMBER(50)		 NULL ,
		product_image                 		VARCHAR2(50)		 NULL ,
		order_no                      		NUMBER(30)		 NULL ,
		product_star_avg              		NUMBER(10)		 NULL 
);

DROP SEQUENCE Product_product_no_SEQ;

CREATE SEQUENCE Product_product_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Product is 'Product';
COMMENT ON COLUMN Product.product_no is 'product_no';
COMMENT ON COLUMN Product.product_name is 'product_name';
COMMENT ON COLUMN Product.product_price is 'product_price';
COMMENT ON COLUMN Product.product_category is 'product_category';
COMMENT ON COLUMN Product.product_amount is 'product_amount';
COMMENT ON COLUMN Product.product_image is 'product_image';
COMMENT ON COLUMN Product.order_no is 'order_no';
COMMENT ON COLUMN Product.product_star_avg is 'product_star_avg';


/**********************************/
/* Table Name: Orders */
/**********************************/
CREATE TABLE Orders(
		order_no                      		NUMBER(30)		 NULL ,
		order_item                    		VARCHAR2(100)		 NULL ,
		order_date                    		DATE		 NULL ,
		order_price                   		NUMBER(30)		 NULL ,
		order_address                 		VARCHAR2(100)		 NULL ,
		order_desc                    		VARCHAR2(100)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Orders_order_no_SEQ;

CREATE SEQUENCE Orders_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Orders is 'Orders';
COMMENT ON COLUMN Orders.order_no is 'order_no';
COMMENT ON COLUMN Orders.order_item is 'order_item';
COMMENT ON COLUMN Orders.order_date is 'order_date';
COMMENT ON COLUMN Orders.order_price is 'order_price';
COMMENT ON COLUMN Orders.order_address is 'order_address';
COMMENT ON COLUMN Orders.order_desc is 'order_desc';
COMMENT ON COLUMN Orders.user_id is 'user_id';


/**********************************/
/* Table Name: OrderStatus */
/**********************************/
CREATE TABLE OrderStatus(
		orderStatus_no                		NUMBER(10)		 NULL ,
		orderStatus_image             		VARCHAR2(50)		 NULL ,
		orderStatus_desc              		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE OrderStatus_orderStatus_no_SEQ;

CREATE SEQUENCE OrderStatus_orderStatus_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE OrderStatus is 'OrderStatus';
COMMENT ON COLUMN OrderStatus.orderStatus_no is 'orderStatus_no';
COMMENT ON COLUMN OrderStatus.orderStatus_image is 'orderStatus_image';
COMMENT ON COLUMN OrderStatus.orderStatus_desc is 'orderStatus_desc';


/**********************************/
/* Table Name: Order_item */
/**********************************/
CREATE TABLE Order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(30)		 NULL ,
		product_no                    		NUMBER(50)		 NULL ,
		orderStatus_no                		NUMBER(10)		 NULL 
);

COMMENT ON TABLE Order_item is 'Order_item';
COMMENT ON COLUMN Order_item.oi_no is 'oi_no';
COMMENT ON COLUMN Order_item.oi_qty is 'oi_qty';
COMMENT ON COLUMN Order_item.order_no is 'order_no';
COMMENT ON COLUMN Order_item.product_no is 'product_no';
COMMENT ON COLUMN Order_item.orderStatus_no is 'orderStatus_no';


/**********************************/
/* Table Name: Cart */
/**********************************/
CREATE TABLE Cart(
		cart_no                       		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE Cart_cart_no_SEQ;

CREATE SEQUENCE Cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE Cart is 'Cart';
COMMENT ON COLUMN Cart.cart_no is 'cart_no';
COMMENT ON COLUMN Cart.cart_qty is 'cart_qty';
COMMENT ON COLUMN Cart.user_id is 'user_id';


/**********************************/
/* Table Name: MyPet */
/**********************************/
CREATE TABLE MyPet(
		mypet_no                      		NUMBER(10)		 NULL ,
		mypet_name                    		VARCHAR2(10)		 NULL ,
		mypet_birthday                		DATE		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE MyPet_mypet_no_SEQ;

CREATE SEQUENCE MyPet_mypet_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE MyPet is 'MyPet';
COMMENT ON COLUMN MyPet.mypet_no is 'mypet_no';
COMMENT ON COLUMN MyPet.mypet_name is 'mypet_name';
COMMENT ON COLUMN MyPet.mypet_birthday is 'mypet_birthday';
COMMENT ON COLUMN MyPet.user_id is 'user_id';


/**********************************/
/* Table Name: ReviewBoard */
/**********************************/
CREATE TABLE ReviewBoard(
		board_no                      		NUMBER(50)		 NULL ,
		board_title                   		VARCHAR2(100)		 NULL ,
		board_content                 		VARCHAR2(100)		 NULL ,
		board_date                    		DATE		 NULL ,
		board_star                    		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE ReviewBoard is 'ReviewBoard';
COMMENT ON COLUMN ReviewBoard.board_no is 'board_no';
COMMENT ON COLUMN ReviewBoard.board_title is 'board_title';
COMMENT ON COLUMN ReviewBoard.board_content is 'board_content';
COMMENT ON COLUMN ReviewBoard.board_date is 'board_date';
COMMENT ON COLUMN ReviewBoard.board_star is 'board_star';
COMMENT ON COLUMN ReviewBoard.user_id is 'user_id';



ALTER TABLE UserInfo ADD CONSTRAINT IDX_UserInfo_PK PRIMARY KEY (user_id);

ALTER TABLE Coupon ADD CONSTRAINT IDX_Coupon_PK PRIMARY KEY (coupon_id);
ALTER TABLE Coupon ADD CONSTRAINT IDX_Coupon_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE ReportBoard ADD CONSTRAINT IDX_ReportBoard_PK PRIMARY KEY (board_no);
ALTER TABLE ReportBoard ADD CONSTRAINT IDX_ReportBoard_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE Volunteer ADD CONSTRAINT IDX_Volunteer_PK PRIMARY KEY (volunteer_no);
ALTER TABLE Volunteer ADD CONSTRAINT IDX_Volunteer_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE Visit ADD CONSTRAINT IDX_Visit_PK PRIMARY KEY (visit_no);
ALTER TABLE Visit ADD CONSTRAINT IDX_Visit_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE Pet ADD CONSTRAINT IDX_Pet_PK PRIMARY KEY (pet_no);

ALTER TABLE Adopt ADD CONSTRAINT IDX_Adopt_PK PRIMARY KEY (adopt_no);
ALTER TABLE Adopt ADD CONSTRAINT IDX_Adopt_FK0 FOREIGN KEY (pet_no) REFERENCES Pet (pet_no);
ALTER TABLE Adopt ADD CONSTRAINT IDX_Adopt_FK1 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE Product ADD CONSTRAINT IDX_Product_PK PRIMARY KEY (product_no);

ALTER TABLE Orders ADD CONSTRAINT IDX_Orders_PK PRIMARY KEY (order_no);
ALTER TABLE Orders ADD CONSTRAINT IDX_Orders_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE OrderStatus ADD CONSTRAINT IDX_OrderStatus_PK PRIMARY KEY (orderStatus_no);

ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_FK0 FOREIGN KEY (order_no) REFERENCES Orders (order_no);
ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_FK1 FOREIGN KEY (product_no) REFERENCES Product (product_no);
ALTER TABLE Order_item ADD CONSTRAINT IDX_Order_item_FK2 FOREIGN KEY (orderStatus_no) REFERENCES OrderStatus (orderStatus_no);

ALTER TABLE Cart ADD CONSTRAINT IDX_Cart_PK PRIMARY KEY (cart_no);
ALTER TABLE Cart ADD CONSTRAINT IDX_Cart_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE MyPet ADD CONSTRAINT IDX_MyPet_PK PRIMARY KEY (mypet_no);
ALTER TABLE MyPet ADD CONSTRAINT IDX_MyPet_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

ALTER TABLE ReviewBoard ADD CONSTRAINT IDX_ReviewBoard_PK PRIMARY KEY (board_no);
ALTER TABLE ReviewBoard ADD CONSTRAINT IDX_ReviewBoard_FK0 FOREIGN KEY (user_id) REFERENCES UserInfo (user_id);

