package doit.project.memberproject.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group1")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String name;

    @Column(name = "group_description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "group")
    private List<Member> members;

    @Builder
    public Group(String name, String description, List<Member> members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }
}
