package pl.my.quickcash.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CommunicationDAO {

    private static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();

    public static void insert(String statement, Object object) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert(statement, object);
        }finally {
            session.commit();
            session.close();
        }
    }

    public static void update(String statement, Object object) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update(statement, object);
        }finally {
            session.commit();
            session.close();
        }
    }

    public static void delete(String statement, Object object) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete(statement, object);
        }finally {
            session.commit();
            session.close();
        }
    }

    public static <T> List<T> selectList(String statement) {
        List<T> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList(statement);
        }finally {
            session.close();
        }
        return list;
    }

    public static Object selectById(String statement, int id) {
        Object object = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            object = session.selectOne(statement, id);
        }finally {
            session.close();
        }
        return object;
    }

    public static Object selectByString(String statement, String login) {
        Object object = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            object = session.selectOne(statement, login);
        }finally {
            session.close();
        }
        return object;
    }

    public static Object selectByObject(String statement, Object object) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            object = session.selectOne(statement, object);
        }finally {
            session.close();
        }
        return object;
    }
}
