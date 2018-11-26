package com.melgar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.melgar.entities.Car;
import com.melgar.entities.Owner;
import com.melgar.entities.User;
import com.melgar.repositories.CarRepository;
import com.melgar.repositories.OwnerRepository;
import com.melgar.repositories.UserRepository;

@SpringBootApplication
public class React2Application  extends SpringBootServletInitializer{
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application)
	{
		return application.sources(React2Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(React2Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args->{
			
			//Add owners objects and save these to db
			Owner owner1 =  new Owner("John","Johnson");
			Owner owner2 = new Owner("Mary","Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			repository.save(new Car("Ford","Mustang","Red","ADF-1121", 2017, 59000,owner1));
			repository.save(new Car("Nissan","Leaf","White", "SSJ-3002", 2014, 29000,owner2));
			repository.save(new Car("Toyota","Prius","Silver","KKO-0212", 2018, 39000, owner2));
			
			//Username: user, password: user
			urepository.save(new User("user","$2a$10$ModpuHLtCx6QaCapMoN9V.mbOgpT6xkYHIDj8fq9gppaN4SlBHjSm","USER"));
			//USername: admin, password: admin
			urepository.save(new User("admin","$2a$10$G5RZuRF83UMWKtgwoubibeMvtgS10Gx9y/d.V4.6sLCB2n7K9Kv9y","ADMIN"));
		};
	}
}
