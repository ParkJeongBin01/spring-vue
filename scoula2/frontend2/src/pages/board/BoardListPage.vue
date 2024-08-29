<script setup>
import { ref, onMounted, reactive } from 'vue';
import axios from 'axios';

const member = ref('');

onMounted(async () => {
  const username = 'someUsername';
  const response = await axios.get('/api/member/email/{username}');
  member.value = response.data;
});

const ref1 = ref('종현이는');
const check = ref(0);

const change1 = () => {
  console.log('check');
  if (check.value === 1) {
    ref1.value = '종현이는 멍청이';
    check.value = 0;
  } else {
    ref1.value = '종현이는 바보';
    check.value = 1;
  }
};

const reactive1 = reactive({ text: '' });
const state = ref(false);
const chage2 = () => {
  state.value = !state.value;
};
const handleEnter = (event) => {
  if (event.key === 'Enter') {
    state.value = true; // 엔터 키를 누르면 state를 true로 설정하여 표시되게 함
    event.preventDefault(); // 기본 엔터 키 동작 방지 (textarea에서 줄바꿈 방지)
  }
};
</script>

<template>
  <h1>게시판이올시다~</h1>
  <div v-if="member">Email : {{ member }}</div>
  <br />
  <div>ref 상태 변수 : {{ ref1 }}</div>
  <button type="button" @click="change1">클릭!</button>
  <br />

  <div>reactive 상태 변수 :</div>
  <textarea v-model="reactive1.text" cols="30" rows="5" placeholder="가지고 싶은 선물을 적으세요~!" @keydown="handleEnter"></textarea> <br />
  <div v-if="state">{{ reactive1.text }}</div>
  <button type="submit" @click="chage2">클릭!</button>
</template>
