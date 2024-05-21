package doit.project.memberproject.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginIdAndPassword(String loginId, String password);

    Optional<Member> findByLoginId(String loginId);
}
