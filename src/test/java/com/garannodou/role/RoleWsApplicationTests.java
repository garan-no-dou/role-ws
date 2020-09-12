package com.garannodou.role;

import com.garannodou.role.domain.MyTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class RoleWsApplicationTests {

    ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    void contextLoads() {
    }

    @Test
    void testBeanShouldBePresent() {
        contextRunner.withPropertyValues("app.test.property=true")
                .withUserConfiguration(MyTestConfig.class)
                .run(context -> {
                    assertThat(context.containsBean("myTestBean"), is(true));
                });
    }

    @Test
    void testBeanShouldNotBePresent() {
        contextRunner.withPropertyValues("app.test.property=false")
                .withUserConfiguration(MyTestConfig.class)
                .run(context -> {
                    assertThat(context.containsBean("myTestBean"), is(false));
                });
    }

}
