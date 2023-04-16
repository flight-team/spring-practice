package com.study.mystudy.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.mystudy.board.domain.Board;
import com.study.mystudy.board.domain.BoardRequestDto;
import com.study.mystudy.board.domain.PagingDto;
import com.study.mystudy.board.repository.BoardRepository;
import com.study.mystudy.exception.CustomException;
import com.study.mystudy.exception.ErrorCode;

@Service
public class BoardService {

	private final BoardRepository boardRepository;

	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public List<Board> selectBoardList(PagingDto pagingDto) {
		List<Board> check = Optional.ofNullable(boardRepository.findBoardList(pagingDto))
				.orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		return check;
	}
	
	@Transactional
	public Board selectBoardDetail(Long id) { // 글 상세 및 조회수 증가
		Board board = boardRepository.findBoard(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		board.updateViewCount(board.getId());	//트랜잭션 내에서 실행되는 entity 객체 수정은 실제 테이블에도 반영됨
		return board;
	}

	public Board updateBoard(BoardRequestDto boardRequestDto) {
		Board board = boardRepository.findBoard(boardRequestDto.getId()).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		board.update(boardRequestDto.getTitle(), boardRequestDto.getContent(), boardRequestDto.getTagCode());
		return board;
	}
	
}
