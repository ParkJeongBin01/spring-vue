package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
@Slf4j
public class RestController {
    private final BoardService service;

//    @GetMapping("")
//    public List<BoardDTO> getList(){
//        return service.getList();
//    }
    //Talend로 Get - http://localhost:8080/api/board확인

    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList(){
        return ResponseEntity.ok(service.getList());
    }
    //Talend로 Get - http://localhost:8080/api/board확인

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> getList(@PathVariable Long no){
        return ResponseEntity.ok(service.get(no));
    }
    //Talend로 Get - http://localhost:8080/api/board/no(db no숫자)확인

    @PostMapping("")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board){
        return ResponseEntity.ok(service.create(board));
    }
    //Talend로 Post - http://localhost:8080/api/board확인 생성(post)

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable int no, @RequestBody BoardDTO board){
        return ResponseEntity.ok(service.update(board));
    }
    //@PathVariable int id이렇게 하면 에러가 난다.
    //@PathVariable int id가 @PathVariable int no가 되어야 하거나(변수 변경),
    //@PathVariable ("no") int id(no라고 지정해줌)가 되면 된다.
    //Talend로 Get - http://localhost:8080/api/board/no(db no숫자)확인

    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no){
        // return ResponseEntity.ok(service.get(no));

        service.delete(no);
        return ResponseEntity.ok(service.get(no));
        //이러면 상태만 나타냄.
    }

}