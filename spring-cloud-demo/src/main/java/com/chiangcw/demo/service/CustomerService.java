package com.chiangcw.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chiangcw.demo.entity.SysUser;
import com.chiangcw.demo.repository.SysUserRepository;

public class CustomerService implements UserDetailsService
{
@Autowired
private SysUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
      SysUser sysUser=repository.findByUserName(userName);
      if(sysUser==null) throw new UsernameNotFoundException("user is not exists!");
        return sysUser;
    }

}
