package com.mfouad.userService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.config.EurekaClientConfigServerAutoConfiguration;

import com.mfouad.userService.services.UsersServices;

@SpringBootTest
@EnableAutoConfiguration(exclude= {EurekaClientConfigServerAutoConfiguration.class})
class UserServiceApplicationTests {

	@Autowired
	UsersServices userServices;
	
	@Test
	void contextLoads() {
		
		assertThat(userServices).hasNoNullFieldsOrProperties();
	}

}
