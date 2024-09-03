<script setup>
import { computed } from 'vue';
import MenuItem from './MenuItem.vue';
import AccountMenuItem from './AccountMenuItem.vue';
import LogoutMenuItem from './LogoutMenuItem.vue';
import config from '@/config';

const { login, join } = config.accoutMenus;
import { useAuthStore } from '@/stores/auth.js';

const auth = useAuthStore();

const islogin = computed(() => auth.isLogin); // 임시: 로그인하지 않음
const username = computed(() => auth.username); // 임시: 사용자명 없음
</script>
<template>
  <ul class="navbar-nav ms-auto">
    <!-- 로그인 한 경우 -->
    <template v-if="islogin">
      <AccountMenuItem :username="username" />
      <LogoutMenuItem />
    </template>
    <!-- 로그인 안 한 경우 -->
    <template v-else>
      <MenuItem :menu="login" />
      <MenuItem :menu="join" />
    </template>
  </ul>
</template>
