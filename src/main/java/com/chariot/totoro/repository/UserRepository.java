package com.chariot.totoro.repository;

import com.chariot.totoro.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Trung Vu on 2018/03/28.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
