package org.scoula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor // 파이널이 붙은 애만 매개변수로 받는 생성자
//@AllArgsConstructor//파이널 상관없이 다 매개면수로 받는 생성자.
public class Restaurant {
    @Autowired //이 녀석 뭐하는 녀석이야?! 연결
     final private Chef chef; //의존 객체 chef.
    //Restaurant(Chef chef); 또는 void set Chef chef;으로 의존 객체를 만들었었음.
    //reflection이라는 기법을 사용하면 private을 사용하더라도 외부에서 사용가능 하다.
    //스프링 컨텍스트에 등록이 되어야 한다.
}

//@ComponentScan(basePackages = {"org.scoula"}) 하위 패키지(이 패키지아래에) 포함해서 찾아준다.
//스프링 컨텍스트 안에서 가능.
