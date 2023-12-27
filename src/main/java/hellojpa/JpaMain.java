package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 연결 db당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 커넥션 받아오기
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//////////////////////////////////////////

        Team team = new Team();
        team.setName("TeamAc");
        em.persist(team);

        Member member = new Member();
        member.setName("member11");
        member.setTeam(team);
        em.persist(member);

        // 디비 반영
        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());

        System.out.println("findMember = " + findMember);
        List<Member> memberList = findMember.getTeam().getMembers();

        for (Member a :memberList){
            System.out.println("a = " + a);
        }


///////////////////////////////////////

        tx.commit();
        em.close();
        emf.close();
    }

}
