package com.spring.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spring.web.javaConfig.controller.HomeController;
import com.spring.web.javaConfig.controller.SpitterController;
import com.spring.web.javaConfig.controller.SpittleController;
import com.spring.web.javaConfig.dao.SpittleRepository;
import com.spring.web.javaConfig.pojo.Spitter;
import com.spring.web.javaConfig.pojo.Spittle;


public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
	
	@Test
	public void shouldShowRecentSpittles() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		mockMvc.perform(get("/spittles")).
		andExpect(view().name("spittles")).
		andExpect(model().attributeExists("spittleList")).
		andExpect(model().attribute("spittleList", CoreMatchers.hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void shouldShowPagedSpittles() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(50);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 50)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).
				setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(get("/spittles?max=238900&count=50"))
		.andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", CoreMatchers.hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void testSpittle() throws Exception{
		Spittle expectedSpittle = new Spittle("Hello",new Date());
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spittles/12345"))
		.andExpect(view().name("spittle"))
		.andExpect(model().attributeExists("spittle"))
		.andExpect(model().attribute("spittle", expectedSpittle));
	}
	
	@Test
	public void shouldShowRegistration() throws Exception{
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register"))
		.andExpect(view().name("registerForm"));
	}
	
	/*@Test
	public void shouldProcessRegistration() throws Exception{
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Spitter unsaved = new Spitter("Leonardo","DiCaprio","lee","123456");
		Spitter saved = new Spitter(1L,"Leonardo","DiCaprio","lee","123456");
		Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register")
			.param("firstName", "Leonardo").param("lastName", "DiCaprio")
			.param("userName", "lee").param("password", "123456"));
			//.andExpect(redirectedUrl("/spitter/lee"));
		
		Mockito.verify(mockRepository,Mockito.atLeastOnce());
	}*/
	
	@Test
	public void shouldProcessRegistration() throws Exception{
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
	    Spitter unsaved = new Spitter("Jack", "Bauer", "jbauer", "24hours");
	    Spitter saved = new Spitter(24L, "Jack", "Bauer", "jbauer", "24hours");
	    Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

	    SpitterController controller = new SpitterController(mockRepository);
	    MockMvc mockMvc = standaloneSetup(controller).build();

	    mockMvc.perform(post("/spitter/register")
	            .param("firstName", "Jack")
	            .param("lastName", "Bauer")
	            .param("username", "jbauer")
	            .param("password", "24hours"))
	            .andExpect(redirectedUrl("/spitter/jbauer"));

	    //Verified save(unsaved) is called atleast once
	    Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i=0;i<count;i++){
			spittles.add(new Spittle("Spittle "+i,new Date()));
		}
		return spittles;
	}
}
