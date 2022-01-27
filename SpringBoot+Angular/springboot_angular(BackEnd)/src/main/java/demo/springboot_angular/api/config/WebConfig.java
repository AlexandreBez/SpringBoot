/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.springboot_angular.api.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
    
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilters(){
        
        List<String> all = Arrays.asList("*");
       
        CorsConfiguration corsConfiguration = new CorsConfiguration(); 
        corsConfiguration.setAllowedOrigins(all);
        corsConfiguration.setAllowedHeaders(all);
        corsConfiguration.setAllowedMethods(all);
        corsConfiguration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        
        CorsFilter corsFilter = new CorsFilter(source);
       
        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>();
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        
        return filter;
    }
}
