package org.kevin;

import lombok.val;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kevin.dao.UserMapper;

import java.io.IOException;

/**
 * @author kevin lau (双鹰)
 */
public class TestApplication {

    public static void main(String[] args) throws IOException {
        val sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        val sqlSession= sqlSessionFactory.openSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getById(1L));
    }
}
