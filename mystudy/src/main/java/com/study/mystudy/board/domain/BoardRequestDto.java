package com.study.mystudy.board.domain;

import java.time.LocalDateTime;

import com.study.mystudy.user.domain.User;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private String userIp;
	private int views;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private Long tagCode;
	
}
