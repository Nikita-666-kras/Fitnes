<script setup>
import Header from './Header.vue';
</script>

<template>
  <header>
    <Header />
    <div
      id="carouselExampleControlsNoTouching"
      class="First carousel slide"
      data-bs-touch="false"
    >
      <div class="carhead carousel-inner">
        <div class="carousel-item active">
          <img
            src="https://avatars.mds.yandex.net/get-altay/1063709/2a0000016605987226d6e273f1fe700f6a98/XXL "
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h3>Вставить текст</h3>
            <!-- вставить кнопку -->
          </div>
        </div>

        <div class="carousel-item">
          <img
            src="https://src.kleos.ru/file/org_image/2021/11/9/file_i75b4.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Вставить текст</h5>
            <!-- вставить кнопку -->
          </div>
        </div>
        <div class="carousel-item">
          <img
            src="https://src.kleos.ru/file/org_image/2021/7/28/file_ttdyk.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Вставить текст</h5>
            <!-- вставить кнопку -->
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleControlsNoTouching"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleControlsNoTouching"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </header>

  <main></main>
</template>

<style scoped></style>
