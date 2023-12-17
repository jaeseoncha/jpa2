package hellojpa;

import javax.persistence.*;

@Entity

/**
 * IDENTITY 만 em.persist 할때 insert 쿼리 날려감, 다른건 다 tx.commit할때 쿼리날림 
 */
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
