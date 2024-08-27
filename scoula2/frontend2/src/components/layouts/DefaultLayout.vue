<script setup>
import Header from './Header.vue';
import NavBar from './NavBar.vue';
import Footer from './Footer.vue';
</script>
<template>
  <div class="container">
    <Header />
    <NavBar />
    <div class="content my-5 px-3">
      <slot>
        <!-- <RouterView/>이게 들어가 있는 거임. -->
      </slot>
    </div>
    <Footer />
    <!-- 해더,네비바,푸터가 나오는 이유가 App.vue에서<DefaultLayout><RouterView/></DefaultLayout>감쌌기 때문.  -->
  </div>
</template>
