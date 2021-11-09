package com.example.jangbogo;

import javax.annotation.PostConstruct;

import com.example.jangbogo.domain.Category;
import com.example.jangbogo.domain.Market;
import com.example.jangbogo.domain.Product;
import com.example.jangbogo.domain.Stock;
import com.example.jangbogo.service.CategoryService;
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

	@Autowired
	private CategoryService categoryService;

	@PostConstruct
	public void initMarket() {
		Category categoryDrink = new Category("음료");
		Category categoryVegi = new Category("채소");
		categoryService.enrollCategory(categoryDrink);
		categoryService.enrollCategory(categoryVegi);

		Market market1 = new Market("복마트", 35.96262, 126.98775, "7:00 ~ 22:00", "063-833-4999", "전라북도 익산시 부송동 1080");
		Market market2 = new Market("자유마트", 35.96135, 126.98487, "8:00 ~ 22:00", "063-835-4333", "전라북도 익산시 어양동 158-10");
		Market market3 = new Market("엑스마트", 35.95808, 126.98760, "9:00 ~ 23:00", "063-836-0365", "전라북도 익산시 부송동 781");
		marketService.enrollMarket(market1);
		marketService.enrollMarket(market2);
		marketService.enrollMarket(market3);

		Product product_market1 = new Product("코카콜라", categoryDrink);
		productService.enrollProduct(product_market1);
		stockService.enrollStock(new Stock(3400, 10, market1, product_market1));
		stockService.enrollStock(new Stock(3300, 25, market3, product_market1));
		product_market1 = new Product("사이다", categoryDrink);
		productService.enrollProduct(product_market1);
		stockService.enrollStock(new Stock(2800, 15, market1, product_market1));
		product_market1 = new Product("당근", categoryVegi);
		productService.enrollProduct(product_market1);
		stockService.enrollStock(new Stock(1500, 20, market1, product_market1));

		Product product_market2 = new Product("오렌지주스", categoryDrink);
		productService.enrollProduct(product_market2);
		stockService.enrollStock(new Stock(2600, 25, market2, product_market2));
		product_market2 = new Product("양배추", categoryVegi);
		productService.enrollProduct(product_market2);
		stockService.enrollStock(new Stock(1800, 15, market2, product_market2));
		product_market2 = new Product("펩시콜라", categoryDrink);
		productService.enrollProduct(product_market2);
		stockService.enrollStock(new Stock(2000, 20, market2, product_market2));

		Product product_market3 = new Product("상추", categoryVegi);
		productService.enrollProduct(product_market3);
		stockService.enrollStock(new Stock(1000, 23, market3, product_market3));
		product_market3 = new Product("브로콜리", categoryVegi);
		productService.enrollProduct(product_market3);
		stockService.enrollStock(new Stock(1200, 20, market3, product_market3));
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
