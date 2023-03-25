package com.adiverse.erp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.adiverse.erp.model.FileUploadProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class AdiverseErpApplication extends SpringBootServletInitializer 
{
	public static void main(String[] args)
	{
		SpringApplication.run(AdiverseErpApplication.class, args);
	}
}
