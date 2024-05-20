<script setup>
import Header from '@/components/Header.vue';
import { error } from 'cli';
import jwt_decode from 'vue-jwt-decode';
</script>

<script>
export default {
  
  data() {
    return {
      visible: false,
      User: {},
      trainings: [0],
      allTrainings : [],
      
      // src : 'https://share-assets.mfcimg.com/packs-compiled/static/avatar-grey-4d1d556a3f7c835d738d.png',
      workout: {
        name: '',
        description: '',
        workId: null,
        resp: {},
        userId: null,
        
        
      }

    };
  },
  methods:{

    
    async fetchTrainingData(trainingId) {
        try {
            const response = await api.get('/unauthorized/get/workouts/'+trainingId).then(response=>{
              console.log(response.data) ;
            });
           
        } catch (error) {
            console.error(error);
        }
    },
    async fetchAllTrainings() {
       
        try {
          try {
            const response = await api.get('/authorized/get/workoutsId/', {
      headers: {
        'Authorization': 'Bearer ' + this.$cookies.get('jwt') 
      }
      })
      .then(response=>{console.log(response.data)})
      .catch(error=>{console.log(error)});

           
            this.allTrainings.push(response.data.id);
        } catch (error) {
            console.error(error);
        }
          
             // Пример ID тренировок

            for (const trainingId of allTrainings) {
                const trainingData = await this.fetchTrainingData(trainingId);
                this.trainings.push(trainingData);
                console.log(trainingData);
            }
        } catch (error) {
            console.error(error);
        }
    },


    
    logOut(){
      this.$cookies.remove('jwt');
      window.location.href="/log"
    },


    
    async setimg() {
       this.User = {
        name :this.user.name,
        img: this.user.img,
      };
      try{
        const response = await api.post('/authorized/set/user/img',this.User,
        {
          headers: {
            'Authorization': 'Bearer ' + this.$cookies.get('jwt') 
          }
        }
        )
        .then(response =>{
          console.log(response.data)
          console.log(User)
        });
      }
      catch(error){}
      
    },

  mounted(){
    this.fetchAllTrainings();

    const token = this.$cookies.get('jwt'); 
    const decodedToken = jwt_decode.decode(token);

    if (decodedToken) {
         this.userId = decodedToken.id;
        console.log(decodedToken.id ); // Вывод id пользователя
    } else {
        console.log('Неверный токен');
    }
  }

}
    
  

}

</script>

<template>
    <Header/>

    

        

    <div class="main">
        <div class="container">
          
        <h1>Мои тренировки</h1>
        
        <div class="workout">
          <div v-for="training in trainings" :key="training.id">
            <h2 >{{training.name}}</h2>
            <p>{{training.description}}</p>
            <ul>
                <li v-for="exercise in training.exercises" :key="exercise.id">{{ exercise.name }}</li>
            </ul>
        </div>
      </div>
        <div class="workout">
            <h2>Тренировка 2</h2>
            <p>Описание тренировки 2...</p>
        </div>

        <div class="workout">
            <h2>Тренировка 3</h2>
            <p>Описание тренировки 3...</p>
        </div>
    </div>

    </div>

</template>

<style scoped>
 body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .workout {
            margin-bottom: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border-left: 6px solid #007bff;
        }

        .workout h2 {
            color: #333;
        }

        .workout p {
            color: #666;
        }
</style>







//   getWorkOut(id){

      
      
  //     api.get('/unauthorized/get/workouts/',id, {
  //     headers: {
  //       'Authorization': 'Bearer ' + this.$cookies.get('jwt') // Получаем JWT токен из cookie
  //     }
  //     })
  //     .then(response => {
  //       this.user.name = response.data.name;
  //       this.user.email = response.data.email;
  //       if (response.data.img != null){
  //         this.user.img = response.data.img
  //       }
  //       else {
  //         this.user.img = "https://share-assets.mfcimg.com/packs-compiled/static/avatar-grey-4d1d556a3f7c835d738d.png";

  //       }

        
  //       console.log(response.data)
  //     })
  //     .catch(error => {
  //       console.error('Ошибка при получении данных:', error);
  //     });
  //     console.log(document.cookie);
  // }
  //   },




 