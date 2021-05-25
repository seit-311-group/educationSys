package cn.sysu.circuitQA;

import cn.sysu.circuitQA.service.AddQAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchTest {
    @Autowired
    AddQAService addQAService;

    @Test
    public void searchTest(){

        System.out.println(addQAService.pagingAndShow("电路"));
    }
}
