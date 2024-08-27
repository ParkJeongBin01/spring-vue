package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;


//VO->DTO변환
public static BoardDTO of(BoardVO vo){
    return vo == null ? null : BoardDTO.builder()
            .no(vo.getNo())
            .title(vo.getTitle())
            .content(vo.getContent())
            .writer(vo.getWriter())
            .attaches(vo.getAttaches())
            .regDate(vo.getRegDate())
            .updateDate(vo.getUpdateDate())
            .build();
}

//DTO -> VO 변환
public BoardVO toVO(){
    return BoardVO.builder()
            .no(no)
            .title(title)
            .content(content)
            .writer(writer)
            .attaches(attaches)
            .regDate(regDate)
            .updateDate(updateDate)
            .build();
}

//VO->DTO, DTO -> VO 변환하는 과정인데 너무 노가다이다.
    //그래서 이걸 변환해주는 라이브러리를 사용한다.
    //지금은 처음이라 쳐본거임.

    //첨부 파일
    private List<BoardAttachmentVO> attaches;

    List<MultipartFile> files = new ArrayList<>(); //실제 업로드된 파일(Multipart) 목록

}