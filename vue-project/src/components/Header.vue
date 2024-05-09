<script >
export default{
  data(){
    return{
      
    }
  },
  methods:{
    mainMenu(){
      return "ok";
    }
  }

}
</script>

<template>
  <header>
    
    <!-- <div class="container bg-secondary bg-gradient">
        <div class=" cad row ">
            <div class="row">
                <div class=" cad col">
                    <button type="button" class="btn btn-primary btn-lg">Главная</button>
                    <button type="button" class="btn btn-primary btn-lg">Тренеровки</button>
                    <button type="button" class="btn btn-primary btn-lg">О нас</button>
                </div>
            
            
                <div class="logodiv col ">
                    <img src="https://cdn-icons-png.flaticon.com/512/2750/2750276.png" class="logo" alt="">
                </div>
            </div>
        </div>
        
    
    

    </div> -->
    
    <div class="logo">
      <img src="https://cdn-icons-png.flaticon.com/512/2750/2750276.png" class="logo" alt="">
    </div>
    <div class="search-bar">
        <input type="text" placeholder="Поиск...">
        <button type="submit">Найти</button>
    </div>
    <div class="buttons">
        <button @click="mainMenu()">Главная</button>
        <button>Тренеровки</button>
        <button>Мой профиль</button>
    </div>

    
  </header>

  <main>
    
  </main>
</template>

<style scoped>
  /* .logo{
    width: 15%;
  }
  .logodiv{
    display: flex;
    justify-content: end;
  }
  .cad{
    
    display: flex;
    justify-content: space-around;
    align-items: center;
  } */
    
  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    background-color: #333;
    color: white;
}

.logo {
    flex: 1;
    max-width: 50px;
    margin-right: 5%;
}

.search-bar {
    flex: 2;
}

.search-bar input {
    padding: 5px;
    width: 200px;
}

.search-bar button {
    padding: 5px 10px;
    background-color: #555;
    color: white;
    border: none;
    cursor: pointer;
}

.buttons {
    flex: 1;
    
}

.buttons button {
    padding: 5px 10px;
    margin-left: 10px;
    background-color: #555;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}


@media (max-width: 768px) {
    .search-bar input {
        width: 150px;
    }
}


@media (max-width: 480px) {
    header {
        flex-direction: column;
        padding: 10px;
    }

    .search-bar input {
        width: 100%;
        margin-bottom: 10px;
    }

    .buttons {
        margin-top: 10px;
    }

    .buttons button {
        margin-left: 0;
        display: block;
        width: 100%;
        margin-top: 7px;
    }
}
</style>
