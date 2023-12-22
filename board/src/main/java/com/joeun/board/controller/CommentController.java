package com.joeun.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joeun.board.dto.Comment;
import com.joeun.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private BoardService boardService;
    
    @GetMapping("/list")
    public ResponseEntity<?> Comment(Comment comment) {
        try {
            List<Comment> commentList = boardService.commentList(comment);
            log.info("commentList : " + commentList);
            
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insert")
    public ResponseEntity<?> commentInsert(@RequestBody Comment comment) {
        try {
            int result = boardService.commentInsert(comment);
            String msg = "";
            if(result > 0 ) {
                msg = "SUCCESS";
            } else {
                msg = "FAIL";
            }
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> update(Comment comment) {
        try {
            String msg = "";

            int result = boardService.commentUpdate(comment);

            if(result > 0) {
                msg = "SUCCESS";
            } else {
                msg = "FAIL";
            }
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> commentDelete(int commentNo) {
        try {
            String msg = "";

            int result = boardService.commentDelete(commentNo);
            log.info("result : " + result);

            if(result > 0) {
                msg = "SUCCESS";
            }

            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
