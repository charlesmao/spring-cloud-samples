package indi.maozy.microservice.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * 描述:
 * 角色实体类
 *
 * @author 毛中勇
 * @create 2019-06-27 16:39
 */
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}