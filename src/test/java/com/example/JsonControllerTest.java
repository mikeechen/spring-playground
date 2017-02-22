package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonController.class)
public class JsonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testJsonResponse() throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/json/pokemon")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("charizard")))
                .andExpect(jsonPath("$.id", is(6)))
                .andExpect(jsonPath("$.weight", is(905)))
                .andExpect(jsonPath("$.types[0].slot", is(2)))
                .andExpect(jsonPath("$.types[0].type.name", is("flying")))
                .andExpect(jsonPath("$.types[1].slot", is(1)))
                .andExpect(jsonPath("$.types[1].type.name", is("fire")));
    }
}
