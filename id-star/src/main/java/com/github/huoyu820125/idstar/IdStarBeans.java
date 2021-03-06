package com.github.huoyu820125.idstar;

import com.github.huoyu820125.idstar.impl.DefaultRegionProvider;
import com.github.huoyu820125.idstar.impl.IdStarConfig;
import com.github.huoyu820125.idstar.impl.nbrestful.impl.RouteRestTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * 从IdStarBeans派生一个类，添加注解@Configuration，不用添加任何代码
 * @author sq
 * @version 1.0
 */
public class IdStarBeans {
    @Bean
    @ConditionalOnProperty(prefix = "idStar", name = "open", havingValue = "true", matchIfMissing = true)
    public IdStarConfig IdConfig() {
        return new IdStarConfig();
    }

//    @Bean(name = "defaultRegionProvider")//bean名为defaultRegionProvider
//    @Bean(value = "defaultRegionProvider")//bean名为defaultRegionProvider
//    @Bean("defaultRegionProvider")//bean名为defaultRegionProvider
    @Bean//bean名默认与方法名一致，区分大小写
    @ConditionalOnProperty(prefix = "idStar", name = "open", havingValue = "true", matchIfMissing = true)
    public DefaultRegionProvider defaultRegionProvider() {
        return new DefaultRegionProvider();
    }

    @Bean()
    @ConditionalOnProperty(prefix = "idStar", name = "open", havingValue = "true", matchIfMissing = true)
    public IdStar IdStar() {
        return new IdStar();
    }

    @Bean("idStarRestTemplate")
    @ConditionalOnProperty(prefix = "idStar", name = "open", havingValue = "true", matchIfMissing = true)
    public RouteRestTemplate idStarRestTemplate() {
        return new RouteRestTemplate();
    }

}
