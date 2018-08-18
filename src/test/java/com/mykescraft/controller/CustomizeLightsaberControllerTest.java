package com.mykescraft.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CustomizeLightsaberControllerTest {
    
    @Mock
    private AccessoryServiceImpl accessoryService;
    
    @Mock
    private ShoppingCartServiceImpl cartService;
 
    @InjectMocks
    private CustomizeLightsaberController lightsaberController;
 
    private MockMvc mockMvc;
 
    @Before
    public void init() {
 
        MockitoAnnotations.initMocks(this);
 
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(lightsaberController)
                                 .setViewResolvers(viewResolver)
                                 .build();
 
    }
    
    @Test
    public void testHilt() throws Exception{
           this.mockMvc.perform(get("/hilt"))
                .andExpect(status().isOk())
                .andExpect(view().name("hilt"))
                .andDo(print());
    }
    
    @Test
    public void testLed() throws Exception{
           this.mockMvc.perform(get("/led"))
                .andExpect(status().isOk())
                .andExpect(view().name("led"))
                .andDo(print());
    }
    
    @Test
    public void testCartConfirmation() throws Exception{
           this.mockMvc.perform(get("/cartconfirmation"))
                .andExpect(status().isOk())
                .andExpect(view().name("cartconfirmation"))
                .andDo(print());
    }
    
    @Test
    public void testCustomerForm() throws Exception{
           this.mockMvc.perform(get("/customer-form"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-form"))
                .andDo(print());
    }
    
    @Test
    public void testThankYou() throws Exception{
           this.mockMvc.perform(get("/thankyou"))
                .andExpect(status().isOk())
                .andExpect(view().name("thankyou"))
                .andDo(print());
    }
}
