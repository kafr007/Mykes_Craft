package com.mykescraft.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringRunner.class)
public class HomeControllerTest {
	
	private MockMvc mockMvc;
    
	@Before
    public void init() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/jsp/view/");
	        viewResolver.setSuffix(".jsp");

	        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
	                                 .setViewResolvers(viewResolver)
	                                 .build();
	    }
	
    @Test
    public void testIndex() throws Exception{
           this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(print());
    }
    
    @Test
    public void testVideos() throws Exception{
           this.mockMvc.perform(get("/videos"))
                .andExpect(status().isOk())
                .andExpect(view().name("videos"))
                .andDo(print());
    }
    
    @Test
    public void testContact() throws Exception{
           this.mockMvc.perform(get("/contact"))
                .andExpect(status().isOk())
                .andExpect(view().name("contact"))
                .andDo(print());
    }

}
