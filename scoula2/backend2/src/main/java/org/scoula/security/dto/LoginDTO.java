package org.scoula.security.dto;
//아이디와 패스워드를 담음.
//필터 부분이라 우리가 직접 다 해줘야 함.....

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {
    private String username;
    private String password;

    public static LoginDTO of(HttpServletRequest request) throws AuthenticationException {
        ObjectMapper om = new ObjectMapper();
        try{
            return om.readValue(request.getInputStream(),LoginDTO.class); //역직렬화 Json->객체
        }catch(Exception e){
            e.printStackTrace();
            throw new BadCredentialsException("username 또는 passoword가 없습니다.");
        }
    }
}
