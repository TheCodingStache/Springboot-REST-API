package ca.users.UserControllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;
//Easier to read on debug
@Configuration
public class MakeSpringPrettyPrintJSON extends WebMvcConfigurationSupport {
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter messageConverter : converters) {
            if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jackson2HttpMessageConverter =
                        (MappingJackson2HttpMessageConverter) messageConverter;
                jackson2HttpMessageConverter.setPrettyPrint(true);

            }
        }
    }
}
