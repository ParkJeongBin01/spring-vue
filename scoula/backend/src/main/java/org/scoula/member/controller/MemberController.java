package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;

    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) { //회원 중복인지 아닌지 확인할 때 사용. 인증 필요x.
        return ResponseEntity.ok().body(service.checkDuplicate(username));
    }
    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member) {
        return ResponseEntity.ok(service.join(member));
    }

    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response){
        String avatarPath = "C:/upload/avatar/" + username + ".png";
        File file = new File(avatarPath);
        if(!file.exists()) {
            file = new File("c:/upload/avatar/unknown.png");
        }
        UploadFiles.downloadImage(response, file);
    }

    @PutMapping("/{username}") //axios할 떄도 axoios.put()으로 해야 한다.
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) { //회원정보 수정할 때 사용. 인증 필요,
        return ResponseEntity.ok(service.update(member));
    }

    @PutMapping("/{username}/changepassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){ //인증 필요.
        service.changePassword(changePasswordDTO);
        return ResponseEntity.ok().build();
    }
}
