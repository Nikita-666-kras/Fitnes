package com.example.Fitnes_Club.dal;

import com.example.Fitnes_Club.models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;
    public void createCoach(Coach coach) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(coach);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteCoach(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Coach coach = session.get(Coach.class, id);
        session.remove(coach);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateCoach(Long id, Coach newCoach){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Coach coach = session.get(Coach.class, id);
        coach.setSpecialization(newCoach.getSpecialization());

        session.merge(coach);
        session.getTransaction().commit();
    }
    public Coach getCoach(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Coach coach = session.get(Coach.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return coach;
    }
    public List<Coach> getCoach(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Coach> query = builder.createQuery(Coach.class);
        Root<Coach> root = query.from(Coach.class);
        query.select(root);
        List<Coach> resultList = session.createQuery(query).getResultList();
        return resultList;
    }

    public void createWorkouts(Workouts newWorkouts) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newWorkouts);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteWorkouts(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Workouts workouts = session.get(Workouts.class, id);
        session.remove(workouts);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateWorkouts(Long id, Workouts updatedWorkouts){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Workouts workouts = session.get(Workouts.class, id);
        workouts.setName(updatedWorkouts.getName());
        session.merge(workouts);
        session.getTransaction().commit();
    }
    public Workouts getWorkouts(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Workouts workouts = session.get(Workouts.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return workouts;
    }
    public List<Workouts> getWorkouts(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Workouts> query = builder.createQuery(Workouts.class);
        Root<Workouts> root = query.from(Workouts.class);
        query.select(root);
        List<Workouts> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public List<Exercises> getExercise(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Exercises> query = builder.createQuery(Exercises.class);
        Root<Exercises> root = query.from(Exercises.class);
        query.select(root);
        List<Exercises> resultList = session.createQuery(query).getResultList();
        return resultList;
    }




//    public List<Workouts> getWorkoutsID(){
//        session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Workouts> query = builder.createQuery(Workouts.class);
//        Root<Workouts> root = query.from(Workouts.class);
//        query.select(builder.construct(Workouts.class, root.get("id")));
//        System.out.println(query);
//        List<Workouts> resultList = session.createQuery(query).getResultList();
//        return resultList;
//    }
public List<Long> getWorkoutsID(){
    session = sessionFactory.openSession();
    session.getTransaction().begin();
    CriteriaBuilder builder = session.getCriteriaBuilder();

    CriteriaQuery<Long> query = builder.createQuery(Long.class);
    Root<Workouts> root = query.from(Workouts.class);

    query.select(root.get("id"));
    System.out.println(query);

    List<Long> resultList = session.createQuery(query).getResultList();
    return resultList;
}

    public void createClients(Clients newClients) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newClients);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteClients(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Clients clients = session.get(Clients.class, id);
        session.remove(clients);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateClients(Long id, Clients updatedClients){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Clients clients = session.get(Clients.class, id);

        session.merge(clients);
        session.getTransaction().commit();
    }
    public Clients getClients(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Clients clients = session.get(Clients.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return clients;
    }
    public List<Clients> getClients(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Clients> query = builder.createQuery(Clients.class);
        Root<Clients> root = query.from(Clients.class);
        query.select(root);
        List<Clients> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createUser(User newUser) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newUser);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateUser(Long id, User updatedUser){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        session.merge(user);
        session.getTransaction().commit();
    }
    public User getUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return user;
    }
    public List<User> getUsers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        return resultList;
    }


    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getName();

        Query query = session
                .createQuery("FROM User where Name = :name")
                .setParameter("name", name);
        User userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другое имя";
        }
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Pabeda)";
    }
    public String newImgToDatbase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        String name = user.getName();




        Query query = session
                .createQuery("FROM User where Name = :name")
                .setParameter("name", name);
        User userA = (User) query.uniqueResult();


        if (userA != null) {
            userA.setImg(user.getImg());
//            session.merge(userA);
            session.getTransaction().commit();
            session.close();
            return "OMG IMG";
        }

        else {
            System.out.println("Пользователь с именем " + userA + " не найден.");
        }


        return "картинка есть";
    }

















    public User getUserFromDatabaseByUsername(String name) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where Name = :name")
                .setParameter("name", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
}
