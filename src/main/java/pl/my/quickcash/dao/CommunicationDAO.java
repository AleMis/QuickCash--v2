package pl.my.quickcash.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
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

    public static void deleteByID(String statement, BigInteger id) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete(statement, id);
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

    public static <T> List<T> selectListById(String statement, BigInteger id) {
        List<T> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList(statement, id);
        }finally {
            session.close();
        }
        return list;
    }

    public static <T> T selectById(String statement, BigInteger id) {
        SqlSession session = sqlSessionFactory.openSession();
        T result;
        try {
            result = session.selectOne(statement, id);
        }finally {
            session.close();
        }
        return result;
    }

    public static <T> T selectByString(String statement, String string) {
        SqlSession session = sqlSessionFactory.openSession();
        T result;
        try {
            result = session.selectOne(statement, string);
        }finally {
            session.close();
        }
        return result;
    }

    public static <T> T selectByObject(String statement, Object object) {
        SqlSession session = sqlSessionFactory.openSession();
        T result;
        try {
            result = session.selectOne(statement, object);
        }finally {
            session.close();
        }
        return result;
    }
}
