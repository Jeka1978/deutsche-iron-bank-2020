package com.deutsche.ironbank2020.controllers;

import com.deutsche.ironbank2020.services.ServiceMockConf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = ServiceMockConf.class)
public class BankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoan() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/bank/loan?name=stark&amount=10")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andReturn();


        Assert.assertTrue(result.getResponse().getContentAsString().toLowerCase().contains("reject"));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }
}
