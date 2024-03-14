package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

// ContextLoaderListener
@ComponentScan(
    value = "bitcamp",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "bitcamp.web.*")
)
//   <context:component-scan base-package="bitcamp">
//    <context:exclude-filter type="regex" expression="bitcamp.web.*"/>
//  </context:component-scan>
public class RootConfig {

}
