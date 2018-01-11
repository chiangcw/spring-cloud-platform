package com.chiangcw.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiangcw.demo.entity.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>
{
    SysUser findByUserName(String userName);
}
