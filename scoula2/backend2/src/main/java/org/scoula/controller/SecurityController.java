package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Log4j
@RequestMapping("/api/security") ///"/security"
@RestController
public class SecurityController {

    @GetMapping("/all") //모두 접근 가능
    public ResponseEntity<String> doAll(){
        log.info("do all can access ever everybody");
        return ResponseEntity.ok("All can access everybody");
    }

//    @GetMapping("/member")//일반 유저 로그인 했으면 접근 가능
//    public void doMember(){
//        log.info("logined member");
//    }

    @GetMapping("/admin")//ADMIN권한만 접근 가능
    public ResponseEntity<MemberVO> doAdmin(@AuthenticationPrincipal CustomUser customUser) {
        MemberVO member = customUser.getMember();
        log.info("username = " + member);
        return ResponseEntity.ok(member);

    }

    @GetMapping("/login")
    public void login(){
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout(){
        log.info("logout page");
    }

    @GetMapping("/member")
    public  ResponseEntity<String> doMember(Authentication authentication){
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        log.info("username = " + userDetails.getUsername());
        log.info("authorities = " + userDetails.getAuthorities()); // 권한 출력
        return ResponseEntity.ok(userDetails.getUsername());
    }
}
