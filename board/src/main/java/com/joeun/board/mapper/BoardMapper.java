package com.joeun.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.board.dto.Board;
import com.joeun.board.dto.Comment;
import com.joeun.board.dto.Page;

@Mapper
public interface BoardMapper {
    // 게시글 목록
    public List<Board> list() throws Exception;

    // 게시글 조회
    public Board select(int boardNo) throws Exception;

    // 게시글 조회수
    public int views(Board board) throws Exception;

    // 게시글 좋아요 수
    public int likes(Board board) throws Exception;

    // 게시글 등록
    public int insert(Board board) throws Exception;

    // 게시글 수정
    public int update(Board board) throws Exception;

    // 게시글 삭제
    public int delete(int boardNo) throws Exception;

    // 페이지 처리
    public List<Page> pages(Page page) throws Exception;
    
    // 총 페이지 수
    public int pageCount() throws Exception;

    // 댓글 불러오기
    public List<Comment> commentList(Comment comment) throws Exception;

    // 댓글 등록
    public int commentInsert(Comment comment) throws Exception;
    
    // 댓글 삭제
    public int commentDelete(int commentNo) throws Exception;
    
    // 댓글 수정
    public int commentUpdate(Comment comment) throws Exception;
}
