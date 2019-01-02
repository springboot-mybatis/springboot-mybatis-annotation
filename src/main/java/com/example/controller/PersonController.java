package com.example.controller;

import com.example.dao.PersonMapper;
import com.example.domain.PersonDO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhuchuanshan on 17/3/25.
 */
@EnableTransactionManagement  // 需要事务的时候加上
@RestController
public class PersonController {

	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/save")
    public Integer save() {
        PersonDO personDO = new PersonDO();
        personDO.setName("张三");
        personDO.setAge(18);
        personMapper.insert(personDO);
        logger.info("------------save");
        return personDO.getId();
    }

    @RequestMapping("/update")
    public Long update() {
        PersonDO personDO = new PersonDO();
        personDO.setId(2);
        personDO.setName("旺旺");
        personDO.setAge(12);
        logger.info("------------update");
        return personMapper.update(personDO);
    }

    @RequestMapping("/delete")
    public Long delete() {
        return personMapper.delete(11L);
    }

    @RequestMapping("/selectById")
    public PersonDO selectById() {
    	logger.info("------------selectById");
        return personMapper.selectById(2L);
    }

    @RequestMapping("/selectAll")
    public List<PersonDO> selectAll() {
    	logger.info("------------selectAll");
        return personMapper.selectAll();
    }

    @RequestMapping("/transaction")
    @Transactional  // 需要事务的时候加上
    public Boolean transaction() {
        delete();

        int i = 3 / 0;

        save();

        return true;
    }

}
