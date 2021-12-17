package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class _2crud {
    public static void main(String[] args) {
        //EntityManagerFactory 만들기, JPA(persistence Unit) 이름은 'hello'
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        //EntityManager는 고객의 요청이 올때마다 만들었다가 버려야됨. 재사용 금지
        EntityManager em = emf.createEntityManager();

        //transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setId(2L);
            member.setName("helloB");
            //DB에 저장 (Create)
            em.persist(member);
            //DB에서 find (Read)
            Member findmember = em.find(Member.class, 1L);
            //DB에서 update (Update) 그냥 객체를 수정해 줬는데 알아서 DB에 반영이 됨. JPA의 특징인 영속성 컨텍스트 때문
            findmember.setName("HelloJPA");
            //DB에서 삭제 (Delete)
            em.remove(findmember);

            //JPQL 테이블 중심의 쿼리가 아닌 객체 중심의 쿼리
            List<Member> result = em.createQuery("select m from Member as m",Member.class).getResultList();
            for (Member mb : result){
                System.out.println("member = "+mb.getName());
            }

            //commit 사실 이때 sql이 날라감
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
