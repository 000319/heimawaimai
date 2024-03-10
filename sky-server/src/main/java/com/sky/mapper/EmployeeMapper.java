package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
/*
* 插入员工操作
* */
@Insert("insert into employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) VALUES (#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status}, #{createTime},#{updateTime},#{createUser}, #{updateUser})")
    void insert(Employee employee);


/*
* 员工分页查询
* */
    Page<Employee> pagequery(EmployeePageQueryDTO employeePageQueryDTO);


    /*
    * 员工账号禁用启用
    *
    * */
    void update(Employee employee);
}
