<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const weather = ref(null); // 날씨 데이터 초기값을 null로 설정

onMounted(async () => {
  weather.value = await fetchWeatherData();
});

// 날씨 데이터를 가져오는 함수
const fetchWeatherData = async () => {
  const response = await axios.get('/api/weather');
  return response.data;
};
</script>

<template>
  <div>
    <h1>날씨</h1>
    <div v-if="weather">
      <div>온도 : {{ weather.main.temp }}°C</div>
      <div>습도: {{ weather.main.humidity }}%</div>
      <br />
      <div>체감 온도: {{ weather.main.feels_like }}°C</div>
      <div>최저 온도: {{ weather.main.temp_min }}°C</div>
      <div>최고 온도: {{ weather.main.temp_max }}°C</div>
    </div>
  </div>
</template>
