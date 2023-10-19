package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	// 카트에 담기
	//Cart insertCart(Cart cart);

	// 카트에 담긴 상품수량 변경
	//int update_qty(Cart cart);

	// 카트에 담긴 상품 종류 변경
	//int update_product(Cart cart);

	// 카트에 담긴 상품 삭제
	//int deleteCart(Cart cart);

	// 카트에 담긴 상품 전체삭제
	@Query(value = "delete from cart where user_id=?1", nativeQuery = true)
	void deleteByUserId(String userId);
	
	// 카트에 중복제품이 있으면 합산되어 담기도록
	// select count(*) from product p join (select count(*) from cart c join userInfo u on c.u_id=u.u_id where u.u_id=#{u_id}) j on p.p_size=#{product.p_size} and p.p_no=#{product.p_no}
	//@Query(value = "")
	//int productWithKindByUserId(Cart cart);

	// 카트에 담긴 모든 상품 출력
	//List<Cart> findAll();
}
