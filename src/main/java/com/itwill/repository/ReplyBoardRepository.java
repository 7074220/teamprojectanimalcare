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
	
	//@Query(value="delete from replyboard where user_no = ?1",nativeQuery = true)
	//public void deleteByUserNo(Long userNo);

	@Query(value = "select * from replyboard where user_no = ?1",nativeQuery = true)
	public List<ReplyBoard> findByUserNo(Long userNo);
	
	@Query(value = "select * from replyBoard order by reply_board_no asc ",nativeQuery = true)
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();
	

	
	  @Query(
	  value="insert into replyBoard(reply_board_no, reply_board_register_date, reply_board_content, reply_board_group_no, reply_board_step, reply_board_depth, user_no, board_no) \r\n"
	  +
	  "values(replyBoard_reply_board_no_seq.nextval, sysdate, ?1, replyBoard_reply_board_no_seq.currval, 1, 0, ?2, ?3)"
	  ,nativeQuery = true) public ReplyBoard Create(ReplyBoard replyBoard);
	 
	
	

}
