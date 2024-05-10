<script></script>

<template>
  <router-view />
</template>

<style>
body {
  background: rgb(255, 255, 255);
  background: linear-gradient(
    241deg,
    rgb(125, 85, 169) 0%,
    rgb(255, 255, 255) 100%
  );
  animation: gradient 6s infinite linear;
  background-size: 400%;
}

@keyframes gradient {
  0% {
    background-position: 80% 0%;
  }
  50% {
    background-position: 20% 100%;
  }
  100% {
    background-position: 80% 0%;
  }
}
</style>
