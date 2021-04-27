package com.example.demo;

import com.example.demo.model.entity.Commentaire;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.Voiture;
import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		DemoApplication.class,
		Jsr310Converters.class
})
public class DemoApplication {

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	CommentaireRepository commentaireRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostConstruct
	void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		if (voitureRepository.count() == 0){
			List<Voiture> list = new ArrayList<>();
			list.add(new Voiture("Peugeot 206"));
			list.add(new Voiture("Audit C4"));
			list.add(new Voiture("Mazda Rx7"));
			list.add(new Voiture("Nissan Skyline"));
			list.add(new Voiture("Lamborghini Gallardo"));
			list.add(new Voiture("Bugatti Veyron"));
			voitureRepository.saveAll(list);
		}

		if (userRepository.count() == 0){
			User user = new User();
			user.setUsername("test");
			user.setPassword(passwordEncoder.encode("test"));
			userRepository.save(user);
		}

		if (commentaireRepository.count() == 0){
			List<Commentaire> list = new ArrayList<>();
			User user = userRepository.findById(1L).get();
			long i = 0;
			String comm = "Commentaire ";
			for (i = 1 ; i < 7; i++){
				Commentaire c = new Commentaire();
				Voiture v = new Voiture();
				v.setId(i);
				c.setVoiture(v);
				c.setUser(user);
				c.setMessage(comm + "" + i);
				list.add(c);
			}
			commentaireRepository.saveAll(list);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
