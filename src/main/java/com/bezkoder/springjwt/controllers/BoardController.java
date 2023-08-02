package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dtos.BoardDto;
import com.bezkoder.springjwt.entity.BoardEntity;
import com.bezkoder.springjwt.model.Header;
import com.bezkoder.springjwt.model.SearchCondition;
import com.bezkoder.springjwt.services.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Header<List<BoardDto>> boardList(
            @PageableDefault(sort = {"idx"}) Pageable pageable,
            SearchCondition searchCondition
    ){
            String test = "test";
            // Pageable에서 리스트 인덱싱 0부터 시작, 우리는 1페이지에서 시작해야 한다.
            // 매번 처리하기 어려우니까 config화 => 참고 : /config/WebMvcConfig.java
        return boardService.getBoardList(pageable, searchCondition);

    }

    @GetMapping("/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("")
    public BoardEntity create(@RequestBody BoardDto boardDto) {
        return boardService.create(boardDto);
    }

    @PatchMapping("")
    public BoardEntity update(@RequestBody BoardDto boardDto) {
        return boardService.update(boardDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

}
