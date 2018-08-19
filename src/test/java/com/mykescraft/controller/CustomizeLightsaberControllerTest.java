package com.mykescraft.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mykescraft.model.Customer;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomizeLightsaberController.class)
public class CustomizeLightsaberControllerTest {
    
	@Autowired
    private MockMvc mockMvc;
   
    @MockBean
    private AccessoryServiceImpl accessoryService;
    
    @MockBean
    private ShoppingCartServiceImpl cartService;
   
    private ResultActions result;
	
    private final String PATH_HILT = "/hilt";
    private final String VIEW_HILT = "hilt";
    private final String PATH_LED = "/led";
    private final String VIEW_LED = "led";
    private final String PATH_CARTCONFIRMATION = "/cartconfirmation";
    private final String VIEW_CARTCONFIRMATION = "cartconfirmation";
    private final String PATH_CUSTOMERFORM = "/customer-form";
    private final String VIEW_CUSTOMERFORM = "customer-form";
    private final String PATH_THANKYOU ="/thankyou";
    private final String VIEW_THANKYOU ="thankyou";
    private final String FORM_FIELD_NAME = "name";
    private final String FORM_FIELD_ADDRESS = "customerAddress";
    private final String FORM_FIELD_EMAIL = "email";
    private final String FORM_FIELD_PHONE = "phoneNumber";
    
    private final String CONTENTTYPE_HTML_UTF8 = "text/html;charset=UTF-8";
    
	    
    @Test
    public void testHilt() throws Exception{
           this.mockMvc.perform(get(PATH_HILT))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_HILT))
                .andDo(print());
    }
    
    @Test
    public void testLed() throws Exception{
           this.mockMvc.perform(get(PATH_LED))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_LED))
                .andDo(print());
    }
    
    @Test
    public void testCartConfirmation() throws Exception{
           this.mockMvc.perform(get(PATH_CARTCONFIRMATION))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_CARTCONFIRMATION))
                .andDo(print());
    }
    
    @Test
    public void testCustomerForm() throws Exception{
           this.mockMvc.perform(get(PATH_CUSTOMERFORM))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_CUSTOMERFORM))
                .andDo(print());
    }
    
    @Test
    public void testThankYou() throws Exception{
           this.mockMvc.perform(get(PATH_THANKYOU))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_THANKYOU))
                .andDo(print());
    }
    
    private void given_theCustomerIsOnTheCustomerFormPage() throws Exception{
		result = mockMvc.perform(
				get(PATH_CUSTOMERFORM)
				.accept(MediaType.TEXT_HTML))
				
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(CONTENTTYPE_HTML_UTF8))
				.andExpect(view().name(VIEW_CUSTOMERFORM));
	}
	
	private void then_theFormContains(final Customer customer) throws Exception{
		result.andExpect(xpath("//input[@name='name']/@value").string(customer.getName()))
				.andExpect(xpath("//input[@email='email']/@value").string(customer.getEmail()))
				.andExpect(xpath("//input[@customerAddress='customerAddress']/@value").string(customer.getCustomerAddress()))
				.andExpect(xpath("//input[@phoneNumber='phoneNumber']/@value").string(customer.getPhoneNumber()));
	
	}
	
	@Test
	public void testCustomerFormIsEmptyWhenFormIsOpen() throws Exception{
		given_theCustomerIsOnTheCustomerFormPage();
		then_theFormContains(new Customer("", "", "", ""));
	}
	
    
    
}
