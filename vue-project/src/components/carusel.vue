<script setup>
import Header from './Header.vue';
</script>

<template>
  <header>
    
    <div
      id="carouselExampleControlsNoTouching"
      class="First carousel slide"
      data-bs-touch="false"
    >
      <div class="carhead carousel-inner">
        <div class="carousel-item active">
          <img
            src="https://img.freepik.com/free-photo/modern-gym-composition-with-sport-elements_23-2147913703.jpg?t=st=1715349376~exp=1715352976~hmac=bc2346d0003ced8c605b434a5f321366618a9e82f594a9679688382bb2541407&w=1380"
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
            src="https://img.freepik.com/free-photo/stretching-beautiful-young-female-athlete-practicing-monochrome-purple-portrait-sportive-caucasian-fit-model-training-body-building-healthy-lifestyle-beauty-action-concept_155003-39077.jpg?t=st=1715349200~exp=1715352800~hmac=5253a9ff81208459a36d92a10a67a07511bceb780281bbd4f40e112a9549f5e6&w=1380"
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
            src="https://img.freepik.com/free-photo/strong-beautiful-young-female-athlete-practicing-monochrome-purple-portrait-sportive-caucasian-fit-model-with-elastics-body-building-healthy-lifestyle-beauty-action-concept_155003-36755.jpg?t=st=1715349000~exp=1715352600~hmac=1d7417cc7703b7454cb99dd4f8102bfa5a3737a0a8abb59a42958e10c47c66c1&w=1380"
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

<style scoped>
.carousel-item{
  align-items: center;
}
</style>
