package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //JPA를 사용하는 class구나 라고 인식함
public class Member {

    @Id
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
