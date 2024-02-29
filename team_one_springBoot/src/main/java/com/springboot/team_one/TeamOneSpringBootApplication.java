package com.springboot.team_one;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan("com.springboot.team_one.dao")
public class TeamOneSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamOneSpringBootApplication.class, args);
	}
	
	@Bean  // 자바소스로 bean을 등록, DataSource : javax.sql.DataSource
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);  // 데이터 소스 설정

		// import org.springframework.core.io.Resource;
		// 마이바티스 xml mapper를 사용할 경우 아래 2줄 추가
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*.xml");
		bean.setMapperLocations(res);
		
		return bean.getObject();
	}


}
