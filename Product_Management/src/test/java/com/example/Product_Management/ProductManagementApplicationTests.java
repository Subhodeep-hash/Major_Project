package com.example.Product_Management;

import com.example.Product_Management.DTO.MasterProduct;
import com.example.Product_Management.DTO.Product;
import com.example.Product_Management.Repository.MasterProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductManagementApplicationTests {
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private MasterProductRepository masterProductRepository;
	private MockMvc mockMvc;
	ObjectMapper objectMapper = new ObjectMapper();
	@Before
	private void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testAddProduct() throws Exception {
		Product product = new Product();
		product.setCount(2);
		product.setProductName("ABC");
		product.setPrice(100);
		product.setProductDetails("IKJ");
		String jsonRequest = objectMapper.writeValueAsString(product);
		Mockito.when(masterProductRepository.findAll()).thenReturn(
				Stream.of(new MasterProduct(1,100,"ABC","IKJ", 2))
						.collect(Collectors.toList()));
		this.mockMvc.perform(post("/addProduct").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
	}
}
