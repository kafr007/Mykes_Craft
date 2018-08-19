package com.mykescraft.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
   
    private final String PATH_INDEX = "/";
    private final String VIEW_INDEX = "index";
    
    private final String PATH_VIDEOS = "/videos";
    private final String VIEW_VIDEOS = "videos";
    
    private final String PATH_CONTACT = "/contact";
    private final String VIEW_CONTACT = "contact";
	
	
	
    @Test
    public void testIndex() throws Exception{
           this.mockMvc.perform(get(PATH_INDEX))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_INDEX))
                .andDo(print());
    }
    
    @Test
    public void testVideos() throws Exception{
           this.mockMvc.perform(get(PATH_VIDEOS))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_VIDEOS))
                .andDo(print());
    }
    
    @Test
    public void testContact() throws Exception{
           this.mockMvc.perform(get(PATH_CONTACT))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_CONTACT))
                .andDo(print());
    }

}
