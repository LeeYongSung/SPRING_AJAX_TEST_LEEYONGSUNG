package com.joeun.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.board.dto.Board;
import com.joeun.board.dto.Comment;
import com.joeun.board.dto.Page;
import com.joeun.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;


    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = boardMapper.list();

        return boardList;
    }

    @Override
    public Board select(int boardNo) throws Exception {
        Board board = boardMapper.select(boardNo);

        return board;
    }

    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);

        return result;
    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);

        return result;
    }

    @Override
    public int delete(int boardNo) throws Exception {
        int result = boardMapper.delete(boardNo);

        return result;
    }

    @Override
    public List<Page> pages(Page page) throws Exception {
        List<Page> pageList = boardMapper.pages(page);

        return pageList;
    }

    @Override
    public int pageCount() throws Exception {
        int result = boardMapper.pageCount();

        return result;
    }

    @Override
    public List<Comment> commentList(Comment comment) throws Exception {
        List<Comment> commentList = boardMapper.commentList(comment);

        return commentList;
    }

    @Override
    public int commentInsert(Comment comment) throws Exception {
        int result = boardMapper.commentInsert(comment);

        return result;
    }

    @Override
    public int commentDelete(int commentNo) throws Exception {
        int result = boardMapper.commentDelete(commentNo);

        return result;
    }

    @Override
    public int commentUpdate(Comment comment) throws Exception {
        int result = boardMapper.commentUpdate(comment);

        return result;
    }

    @Override
    public int views(Board board) throws Exception {
        int result = boardMapper.views(board);

        return result;
    }

    @Override
    public int likes(Board board) throws Exception {
        int result = boardMapper.likes(board);

        return result;
    }
    
}
