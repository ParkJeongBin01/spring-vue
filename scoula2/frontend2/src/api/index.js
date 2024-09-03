import axios from 'axios';

import { useAuthStore } from '@/stores/auth';
import router from '@/router';

//axios객체 -> 커스팅마이징 할거임.
const instance = axios.create({
  timeout: 1000, //1초 동안응답없으면 끊긴 거로 봄
});

//요청 인터셉터
instance.interceptors.request.use(
  (config) => {
    //JWT 추출
    const { getToken } = useAuthStore();
    const token = getToken();
    if (token) {
      //토큰 있는 경우
      config.headers['Authorization'] = `Bearer ${token}`;
      console.log(config.headers.Authorization);
    }
    //config.headers : 요청헤더
    return config;
  },
  (error) => {
    //요청 중 에러가 난 경우
    return Promise.reject(error);
  }
);
//둘 다 함 수. 위에는 정상 처리하는 파트, 에러 처리하는 파트

//응답 인터셉터
instance.interceptors.response.use(
  (response) => {
    //정상 응답인 경우(200,404)
    if (response.status === 200) {
      return response;
    }
    if (response.status === 404) {
      return Promise.reject('404: 페이지 없음' + response.request);
    }
    return response;
  },
  async (error) => {
    //에러 응답인 경우(401,403,305,500 등)
    if (error.response?.status === 401) {
      //위에 ?는 null이 아니면 검사해라
      const { logout } = useAuthStore();
      logout();
      router.push('/auth/login?error=login_required');
      return Promise.reject({ error: '로그인이 필요한 서비스입니다.' });
    }
    return Promise.reject(error);
  }
);
export default instance; // 인터셉터가 적용된 axios 인스턴스
