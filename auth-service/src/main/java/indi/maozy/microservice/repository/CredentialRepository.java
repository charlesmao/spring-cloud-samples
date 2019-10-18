package indi.maozy.microservice.repository;

import indi.maozy.microservice.domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 *
 * @author 毛中勇
 * @create 2019-09-18 16:52
 */
public interface CredentialRepository extends JpaRepository<Credentials, Long> {
    Credentials findByName(String name);
}
