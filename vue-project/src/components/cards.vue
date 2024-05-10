<template>
  <div class="First container">
    <div class="row">
      <div class="col-md-4">
        <div class="c1 card">
          <img
            src="https://via.placeholder.com/150"
            class="card-img-top"
            alt="Товар 1"
          />
          <div class="card-body">
            <h5 class="card-title">Тренер</h5>
            <p class="card-text">Описание Тренера 1.</p>
            <a href="#" class="btn btn-primary">Купить</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="c1 card">
          <img
            src="https://via.placeholder.com/150"
            class="card-img-top"
            alt="Товар 2"
          />
          <div class="card-body">
            <h5 class="card-title">Тренер 2</h5>
            <p class="card-text">Описание Тренера 2.</p>
            <a href="#" class="btn btn-primary">Купить</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="c1 card">
          <img
            src="https://via.placeholder.com/150"
            class="card-img-top"
            alt="Товар 3"
          />
          <div class="card-body">
            <h5 class="card-title">Тренер 3</h5>
            <p class="card-text">Описание Тренера 3.</p>
            <a href="#" class="btn btn-primary">Купить</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.First {
  margin-top: 7%;
}
.c1 {
  background: rgb(255, 255, 255);
  background: linear-gradient(
    241deg,
    rgb(241, 169, 255) 0%,
    rgba(252, 0, 255, 1) 100%
  );
  animation: gradient 5s infinite linear;
  background-size: 400%;
}
</style>
