package com.example.jangbogo;

import javax.annotation.PostConstruct;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.domain.Product;
import com.example.jangbogo.domain.Stock;
import com.example.jangbogo.service.MarketService;
import com.example.jangbogo.service.ProductService;
import com.example.jangbogo.service.StockService;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JangbogoApplication {
	@Autowired
	private MarketService marketService;

	@Autowired
	private ProductService productService;

	@Autowired
	private StockService stockService;

	@PostConstruct
	public void initMarket() {
		Market market = new Market("복마트", 35.96262, 126.98775, "7:00 ~ 22:00", "063-833-4999", "전라북도 익산시 부송동 1080");
		marketService.enrollMarket(market);
		marketService.enrollMarket(new Market("자유마트", 35.96135, 126.98487, "8:00 ~ 22:00", "063-835-4333", "전라북도 익산시 어양동 158-10"));
		marketService.enrollMarket(new Market("엑스마트", 35.95808, 126.98760, "9:00 ~ 23:00", "063-836-0365", "전라북도 익산시 부송동 781"));
		Product product = new Product("코카콜라");
		productService.enrollProduct(product);
		productService.enrollProduct(new Product("펩시콜라"));
		stockService.enrollStock(new Stock(3400, 2, market, product));

	}

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(JangbogoApplication.class, args);
	}

	@Bean
	Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}

}
