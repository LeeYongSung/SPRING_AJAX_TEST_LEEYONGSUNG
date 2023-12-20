package com.joeun.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.board.dto.Board;
import com.joeun.board.dto.Page;
import com.joeun.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    /**
     * 게시글 목록
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Board> boardList = boardService.list();

        log.info("boardList : " + boardList);

        model.addAttribute("boardList", boardList);

        return "board/list";
    }

    /**
     * 게시글 조회
     * @param model
     * @param boardNo
     * @return
     * @throws Exception
     */
    @GetMapping("/read")
    public String read(Model model, int boardNo) throws Exception {
        Board board = boardService.select(boardNo);

        model.addAttribute("board", board);

        return "board/read";
    }
    
    /**
     * 게시글 쓰기
     * @param board
     * @return
     */
    @GetMapping(value = "/insert")
    public String insert(@ModelAttribute Board board) {
        return "board/insert";
    }

    /**
     * 게시글 쓰기 처리
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/insert")
    public String insertPro(@ModelAttribute Board board) throws Exception {
        int result = boardService.insert(board);

        if(result == 0) return "board/insert";
        
        return "redirect:/board/list";
    }
    
    /**
     * 게시글 수정
     * @param model
     * @param boardNo
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/update")
    public String update(Model model, int boardNo) throws Exception {
        Board board = boardService.select(boardNo);

        model.addAttribute("board", board);
        
        return "board/update";
    }

    /**
     * 게시글 수정 처리
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/update")
    public String updatePro(Board board) throws Exception {
        int result = boardService.update(board);
        int boardNo = board.getBoardNo();

        if(result == 0) return "redirect:/board/update?boardNo=" + boardNo;
        
        return "redirect:/board/list";
    }

    /**
     * 게시글 삭제
     * @param boardNo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/delete")
    public String deletePro(int boardNo) throws Exception {
        int result = boardService.delete(boardNo);

        if(result == 0) return "redirect:/board/update?boardNo" + boardNo;
        
        return "redirect:/board/list";
    }

    /**
     * 페이지 네이션 처리
     */
    @ResponseBody
    @GetMapping("/page")
    public List<Page> pages(Page page) throws Exception {
    // public String pages(Model model, Page page) throws Exception {

        
        int totalCount = boardService.pageCount();

        int pageNo = page.getPageNo();
        int rows = page.getRows();

        int firstPage = (pageNo - 1) * rows + 1;
        int lastPage = pageNo * rows;
        log.info("firstPage : " + firstPage);
        log.info("lastPage : " + lastPage);
        
        log.info("pageCount : " + totalCount);
        
        page.setTotalCount(totalCount);
        page.setFirstPage(firstPage);
        page.setLastPage(lastPage);
        
        log.info("page : " + page);
        List<Page> boardList = boardService.pages(page);

        // model.addAttribute("boardList", boardList);

        return boardList;
        // return "board/list";
    }

    /**
     * 페이지 네이션 번호 처리
     * @param param
     * @return
     */
    @ResponseBody
    @GetMapping("/pagination")
    public Page getMethodName(Page page) throws Exception {

        int totalCount = boardService.pageCount();

        int pageNo = page.getPageNo();
        int rows = page.getRows();

        int firstPage = (pageNo - 1) * rows + 1;
        int lastPage = pageNo * rows;
        log.info("firstPage : " + firstPage);
        log.info("lastPage : " + lastPage);
        
        log.info("totalCount : " + totalCount);
        
        page.setTotalCount(totalCount);
        page.setFirstPage(firstPage);
        page.setLastPage(lastPage);

        double pageCountCheck = (double) totalCount/rows;

        log.info("pageCountCheck : " + pageCountCheck);

        int pageCount = (int) Math.ceil(pageCountCheck);

        page.setPageCount(pageCount);
        log.info("pageCount : " + pageCount);

        page.setStartPage(1);
        page.setEndPage(pageCount);
        
        return page;
    }
    
    
}
