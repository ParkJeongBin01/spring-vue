package org.scoula.security.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //지금 당장은 필요없지만 지금 넣어줌.
public class MemberVO {
    private String username;
    private String password;
    private String email;
    private String age;
    private Date regDate;
    private Date updateDate;

    private List<AuthVO> authList; //권한 목록, join 처리 필요
}
