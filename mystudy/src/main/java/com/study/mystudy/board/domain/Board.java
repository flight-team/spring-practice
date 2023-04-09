package com.study.mystudy.board.domain;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.study.mystudy.user.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String userIp;
	private int views;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private Long tag_code;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	// 필드이름이랑 컬럼이랑 일치 시켜서 사용한다.

	@Builder
	public Board(String title, String content, int views, String userIp, Long tagCode, User user) {
		this.title = title;
		this.content = content;
		this.userIp = userIp;
		this.views = views;
		this.tag_code = tagCode;
		this.user = user;
	}

	// requestDto
	public void update(String title, String content, Long tagCode) {
		Optional.ofNullable(title).ifPresent(t -> this.title = t);
		Optional.ofNullable(content).ifPresent(c -> this.content = c);
		Optional.ofNullable(tagCode).ifPresent(tc -> this.tag_code = tc);
		this.modifiedAt = LocalDateTime.now();
	}

	public Board updateViewCount(Long viewCount) { // entity 객체를 수정하는 것만으로 db에 직접적인 값이 수정이 된다
		this.views = views + 1;
		return this;
	}
}