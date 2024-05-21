package doit.project.memberproject.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 protected로 작성해줌
@Getter // getXXX 메서드를 자동으로 생성해줌
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 생성 전략을 DB에 위임
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name", nullable = false) // nullable은 null 허용 여부를 뜻한다.
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "major", nullable = true)
    private String major;

    @Column(name = "student_number", nullable = true)
    private String studentNumber;

    @Column(name = "login_id", nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder // 빌더 패턴을 사용할 수 있게 해줌
    public Member(Long id, String name, int age, String major, String studentNumber, String loginId, String password, Group group) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.studentNumber = studentNumber;
        this.loginId = loginId;
        this.password = password;
        this.group = group;
    }

    public void changeGroup(Group group) {
        this.group = group;
    }
}
