package xyz.stackoverflow.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.stackoverflow.blog.dao.UserDao;
import xyz.stackoverflow.blog.pojo.entity.User;
import xyz.stackoverflow.blog.util.IdGenerator;
import xyz.stackoverflow.blog.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Cacheable(value = "defaultCache",key = "'user_'+#email",unless="#result == null")
    public User getUserByEmail(String email) {
        return dao.getUserByEmail(email);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "defaultCache",key = "'user_'+#user.id")
    public int addUser(User user) {
        user.setHeadurl("/static/custom/image/head.png");
        user.setId(IdGenerator.getId());
        user.setSalt(PasswordUtil.getSalt());
        user.setPassword(PasswordUtil.encryptPassword(user.getSalt(),user.getPassword()));
        return dao.addUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "defaultCache",key = "'user_'+#user.id")
    public int updateHeadurl(User user) {
        return dao.updateHeadurl(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "defaultCache",key = "'user_'+#user.id")
    public int updatePassword(User user) {
        user.setSalt(PasswordUtil.getSalt());
        user.setPassword(PasswordUtil.encryptPassword(user.getSalt(),user.getPassword()));
        return dao.updatePassword(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "defaultCache",key = "'user_'+#user.id")
    public int udpateNickname(User user) {
        return dao.updateNickname(user);
    }
}