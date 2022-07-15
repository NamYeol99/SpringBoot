package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequetDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;


@SpringBootTest
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("uesr55@aaa.com") // 현재 데이터베이스에 존재하는 회원 이메일
                .build();

        Long bno = boardService.register(dto);
    }
    @Test
    public void testList(){
        PageRequetDTO pageRequetDTO = new PageRequetDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequetDTO);
        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }
    @Test
    public void testGet(){
        Long bno = 100L;
        BoardDTO  boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }
    @Test
    public void testRemove(){ // 댓글 삭제
        Long bno = 4L;
        boardService.removeWithReplies(bno);
    }
    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(5L)
                .title("제목 변경합니다")
                .content("내용 변경합니다.")
                .build();
            boardService.modify(boardDTO);
    }

}