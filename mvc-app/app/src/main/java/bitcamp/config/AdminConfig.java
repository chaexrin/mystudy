package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
    value = "bitcamp.web",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "bitcamp.web.app.*")
)
//   <context:component-scan base-package="bitcamp.web">
//    <context:exclude-filter type="regex" expression="bitcamp.web.app.*"/>
//  </context:component-scan>
public class AdminConfig {

}
