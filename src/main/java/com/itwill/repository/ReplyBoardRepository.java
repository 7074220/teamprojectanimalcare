package com.itwill.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.itwill.dao.UserInfoDao;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;


public interface ReplyBoardRepository extends JpaRepository<ReplyBoard, Long>{
	
	@Query(value="delete from reply_board where user_id = ?1",nativeQuery = true)
	public void deleteByUserId(String userId);
	
	@Query(value = "select * from reply_board where user_id = ?1",nativeQuery = true)
	public List<ReplyBoard> findByUserId(String userId);
	
	@Query(value = "select * from reply_board where user_id = ?1 order by reply_board.reply_board_resister_date asc",nativeQuery = true)
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();
	

}
