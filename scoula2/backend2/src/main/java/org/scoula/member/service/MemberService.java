package org.scoula.member.service;

import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;

public interface MemberService {
    boolean checkDuplicate(String username); //id 중복 체크 : findByUsername()

    MemberDTO get(String username); //join 결과 리턴, 상태보기

    MemberDTO join(MemberJoinDTO member);

    MemberDTO update(MemberUpdateDTO member);

    MemberDTO get(MemberDTO email);

    void changePassword(ChangePasswordDTO changePassword);
}
