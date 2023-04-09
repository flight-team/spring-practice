package com.study.mystudy.boardRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.study.mystudy.board.domain.Board;
import com.study.mystudy.board.domain.BoardRequestDto;
import com.study.mystudy.board.domain.PagingDto;
import com.study.mystudy.board.repository.BoardRepository;
import com.study.mystudy.board.service.BoardService;
import com.study.mystudy.utils.MyUtils;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Transactional
@Log4j2
public class JPABoardServiceTest {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	BoardService boardService;

//		@Test
	public void 전체글조회() {
		PagingDto r = new PagingDto(1, 5, "", "");

		r.setBoardList(boardRepository.findBoardList(r));

		for (Board board : r.getBoardList()) {
			log.info(board.toString());
		}
	}

//	@Test
	@Commit
	public void 글상세카운트증가포함() {
		Board result = boardService.selectBoardDetail(2L);
		log.info(result.toString());
	}

	@Test
	@Commit
	public void 글수정엔티티객체직접수정() {
		BoardRequestDto boardRequestDto = BoardRequestDto.builder().id(2L).title("신난당").content("부산......").views(10)
				.userIp("127.0.0.1").tagCode(10L).build();
		Board board = boardService.updateBoard(boardRequestDto);
		log.info(MyUtils.toJson(board));

	}
}