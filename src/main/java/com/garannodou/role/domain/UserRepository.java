package com.garannodou.role.domain;

import java.util.Optional;

// TODO: Define implementation and DB technology to use
public interface UserRepository {
    Optional<User> findByEmail(String email);

    User save(User user);

    // save, findByEmail....

}
