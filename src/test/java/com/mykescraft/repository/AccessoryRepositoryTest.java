package com.mykescraft.repository;


import static org.springframework.data.jpa.domain.Specifications.where;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AccessoryRepositoryTest {
	
	@Autowired(required=true)
	private AccessoryRepositoryImpl accessoryRepo;
		
	@Before
	public void setup() {
		accessoryRepo.saveHilt("Valami", 25.36, "http.hkhhkjhkj", "hilt");
	}
	
	@Test
	public void shouldReturnHilt_whenFindHiltByIdIsCalled() throws Exception {
		assertThat(accessoryRepo.findAllHilts().size()==1);
	

}
	
}
