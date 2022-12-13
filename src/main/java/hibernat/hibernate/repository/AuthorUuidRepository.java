package hibernat.hibernate.repository;

import hibernat.hibernate.domain.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorUuidRepository  extends JpaRepository<AuthorUuid, UUID> {
}