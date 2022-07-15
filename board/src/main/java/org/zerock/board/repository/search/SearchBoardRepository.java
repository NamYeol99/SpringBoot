package org.zerock.board.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequetDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;

public interface SearchBoardRepository {
    Board search1();
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
