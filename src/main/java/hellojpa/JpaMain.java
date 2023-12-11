package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // 연결 db당 하나만 생성
        EntityManagerFactory emf  = Persistence.createEntityManagerFactory("hello");
        // 커넥션 받아오기
        EntityManager em =emf.createEntityManager();

        EntityTransaction tx  =em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setId(1L);
        member.setName("helloA");

        em.persist(member);

        tx.commit();
        em.close();

        emf.close();
    }

}
