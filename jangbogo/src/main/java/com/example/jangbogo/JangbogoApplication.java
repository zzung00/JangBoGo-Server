package com.example.jangbogo;

import javax.annotation.PostConstruct;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.service.MarketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JangbogoApplication {
	@Autowired
	private MarketService marketService;

	@PostConstruct
	public void initMarket() {
		marketService.enrollMarket(new Market("복마트", 35.96262, 126.98775));
		marketService.enrollMarket(new Market("자유마트", 35.96135, 126.98487));
		marketService.enrollMarket(new Market("엑스마트", 35.95808, 126.98760));
	}

	public static void main(String[] args) {
		SpringApplication.run(JangbogoApplication.class, args);
	}

}
