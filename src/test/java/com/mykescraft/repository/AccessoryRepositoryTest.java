package com.mykescraft.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import org.h2.mvstore.cache.CacheLongKeyLIRS.Config;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import com.mykescraft.model.Hilt;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;


@ActiveProfiles("test")
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
public class AccessoryRepositoryTest {
	
	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testFindHiltById() {
		Hilt hilt = accessoryRepo.findHiltById(1);
		assertThat(hilt.getName(), equalTo("Boros"));	
	}
	
	
	

}
