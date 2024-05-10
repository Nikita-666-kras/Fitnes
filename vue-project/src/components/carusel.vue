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
            src="https://img.freepik.com/free-photo/modern-gym-composition-with-sport-elements_23-2147913703.jpg?t=st=1715338563~exp=1715342163~hmac=f694cefd8d338e85bffaa6f4203a20e90eefdd828889011f3d19b1fd2feae5ca&w=1380 "
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
            src="https://img.freepik.com/free-photo/stretching-beautiful-young-female-athlete-practicing-monochrome-purple-portrait-sportive-caucasian-fit-model-training-body-building-healthy-lifestyle-beauty-action-concept_155003-39077.jpg?t=st=1715338687~exp=1715342287~hmac=400fee291a56cb1a3e97ff53033004905b56e8f3888e675daa8cee5eb60dc4c6&w=1380"
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
            src="https://img.freepik.com/free-photo/strong-beautiful-young-female-athlete-practicing-monochrome-purple-portrait-sportive-caucasian-fit-model-with-elastics-body-building-healthy-lifestyle-beauty-action-concept_155003-36755.jpg?t=st=1715338647~exp=1715342247~hmac=8586b23737769b198702f06072c76ac560d149eeff7f4075f7fc52aca4cc6705&w=1380"
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
