package tacos.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 针对HomeController的Web测试
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    // 注入MockMvc
    @Autowired
    private MockMvc mockMvc;

    /**
     * 测试页面
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/home"))
                // 期望得到http 200
                .andExpect(status().isOk())
                // 期望得到home视图
                .andExpect(view().name("home"))
                // 期望包含“Welcome to...”
                .andExpect(content().string(containsString("Welcome to...")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}
