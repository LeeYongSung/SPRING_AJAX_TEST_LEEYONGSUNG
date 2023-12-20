package com.joeun.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.board.dto.Board;
import com.joeun.board.dto.Page;

@Mapper
public interface BoardMapper {
    // 게시글 목록
    public List<Board> list() throws Exception;

    // 게시글 조회
    public Board select(int boardNo) throws Exception;

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
}