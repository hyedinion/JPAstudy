package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _1JpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory 만들기, JPA(persistence Unit) 이름은 'hello'
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}
