package org.kevin.dao;


import org.kevin.entity.User;

/**
 * @author kevin lau (双鹰)
 */
public interface UserMapper {

    Long insert(User user);

    User getById(Long id);
}
