package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        RequestBuilder request = get("/");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring!"));
    }

    @Test
    public void testPost() throws Exception {
        RequestBuilder request = post("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Posted!"));
    }

    @Test
    public void testPatch() throws Exception {
        RequestBuilder request = patch("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Patched!"));
    }

    @Test
    public void testDelete() throws Exception {
        RequestBuilder request = delete("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted!"));
    }

    @Test
    public void testQueryStringByItems() throws Exception {
        RequestBuilder request = get("/tv-shows?genre=fantasy&length=1h");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("genre is fantasy and length is 1h"));
    }

    @Test
    public void testQueryStringByMap() throws Exception {
        RequestBuilder request = get("/pokemon?type=fire&id=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("type is fire and id is 4"));
    }

    @Test
    public void testQueryStringByClass() throws Exception {
        RequestBuilder request = get("/tasks?sortBy=things&done=false");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("sort by things, done is false"));
    }

    @Test
    public void testPathByString() throws Exception {
        RequestBuilder req = get("/tv-shows/genre/fantasy/length/1h");

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string("genre is fantasy and length is 1h"));
    }

    @Test
    public void testPathByMap() throws Exception {
        RequestBuilder req = get("/pokemon/type/fire/id/4");

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string("type is fire and id is 4"));
    }

    @Test
    public void testPathByClass() throws Exception {
        RequestBuilder req = get("/tasks/sortBy/things/done/false");

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string("sort by things, done is false"));
    }

    @Test
    public void testFormDataByString() throws Exception {
        MockHttpServletRequestBuilder req = post("/tv-shows")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("genre", "fantasy")
                .param("length", "1h");

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string("genre=fantasy&length=1h"));
    }

    @Test
    public void testFormDataByMap() throws Exception {
        MockHttpServletRequestBuilder req = post("/pokemon")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "fire")
                .param("id", "5");

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string("type is fire and id is 5"));
    }

    @Test
    public void testFormDataByClass() throws Exception {
        MockHttpServletRequestBuilder req = post("/tasks")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("sortBy", "things")
                .param("done", "false");

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().string("sort by things, done is false"));
    }
}
