package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {

    //@Select("select * from tbl_board order by no desc")
    public List<BoardVO> getList();

    public BoardVO get(Long no);

    public void create(BoardVO board);

    public int update(BoardVO board);

    public int delete(Long no);

    //등록
    public void createAttachment(BoardAttachmentVO attach);
    //글번호기준으로 꺼내는 거
    public List<BoardAttachmentVO> getAttachmentList(Long no);
    //하나 꺼내는 거
    public BoardAttachmentVO getAttachment(Long no);
    //삭제하는 거
    public int deleteAttachment(Long no);

    int getTotalCount();

    List<BoardVO> getPage(PageRequest pageRequest);

}
