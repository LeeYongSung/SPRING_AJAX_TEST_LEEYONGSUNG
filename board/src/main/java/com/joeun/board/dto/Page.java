package com.joeun.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Page {

    private int boardNo;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;
    private int likes;

    private int pageNo;
    private int rows;
    private int pageCount;
    private int totalCount;
    private int startPage;
    private int endPage;
    private int prev;
    private int next;
    private int firstPage;
    private int lastPage;

}
