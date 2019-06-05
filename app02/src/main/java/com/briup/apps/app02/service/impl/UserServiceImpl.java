package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
   @Resource
   private UserMapper userMapper;

   @Override
   public List<User> query(User user) {
      return userMapper.query(user);
   }

   @Override
    public List<User> findAll(){
       return userMapper.findAll();
   }
   @Override
   public User findById(long id){
      return userMapper.findById(id);
   }

   @Override
   public void saveOrUpdate(User user) throws Exception {
      if(user.getId() == null){
         // 初始化属性
         user.setStatus("正常");
         userMapper.insert(user);
      } else {
         userMapper.update(user);
      }
   }

   @Override
   public void deleteById(long id) throws Exception {
      User user = userMapper.findById(id);
      if(user==null){
         throw new Exception("删除的用户不存在");
      }else{
         userMapper.deleteById(id);
      }
   }
}
