package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class BoardMapperTest {
    @Autowired
    BoardMapper mapper;

    @Test
    void getPage() {
        for(int i=1; i<=110; i++){
            BoardVO board = BoardVO.builder()
                    .title("페이징 테스트" + 1)
                    .writer("user0")
                    .content("페이징 테스트" +1)
                    .build();
            mapper.create(board);
        }
    }
}