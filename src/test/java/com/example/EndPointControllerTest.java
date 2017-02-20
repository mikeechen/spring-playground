package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class EndPointControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testHome() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring!"));
    }

    @Test
    public void testPost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Posted!"));
    }

    @Test
    public void testPatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Patched!"));
    }

    @Test
    public void testDelete() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted!"));
    }

    @Test
    public void testQueryStringByItems() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tv-shows?genre=fantasy&length=1h");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("genre is fantasy and length is 1h"));
    }

    @Test
    public void testQueryStringByMap() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/pokemon?type=fire&id=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("type is fire and id is 4"));
    }

    @Test
    public void testQueryStringByClass() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tasks?sortBy=things&done=false");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("sort by things, done is false"));
    }
}
