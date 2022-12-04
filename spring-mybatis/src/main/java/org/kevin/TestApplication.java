package org.kevin;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kevin.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author kevin lau (双鹰)
 */
public class TestApplication {

    private final static Logger log = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) throws IOException {
        val sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        val sqlSession= sqlSessionFactory.openSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        log.info("find user is {}",mapper.getById(1L));
        sqlSession.close();
    }
}
