package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.interfaces.IUsuario;
import com.example.demo.modelo.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudSpringBootApplicationTests {

	@Autowired
	private IUsuario repo;

	@Autowired
	private BCryptPasswordEncoder enconder;


	@Test
	void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(8);
		us.setNombre("jose");
		us.setClave(enconder.encode("111111"));
		Usuario retorno = repo.save(us);
		assertTrue(true);

	}


}
