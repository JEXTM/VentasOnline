/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.webstotales.ventasOnline.util.AjaxService;
import com.webstotales.ventasOnline.util.impl.AjaxServiceImpl;

/**
 * @author JEXTM
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.webstotales.ventasOnline")
public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;	
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");			
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource result
			= new ResourceBundleMessageSource();
		result.setBasename("message");
		return result;	
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor result = new LocaleChangeInterceptor();
		result.setParamName("lang");
		return result;
	}
	@Bean
	public LocaleResolver localeResolver() {	
		SessionLocaleResolver result = new SessionLocaleResolver();
		result.setDefaultLocale(Locale.getDefault());
		return result;	
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}	
	@Bean
	public AjaxService ajaxService(){
		return new AjaxServiceImpl();
	}
}
