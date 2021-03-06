package org.zerock.config;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override		
	protected Class<?>[ ] getRootConfigClasses( ) {		
		return new Class[ ] { RootConfig.class };	
	}		
					
	@Override		
	protected Class<?>[ ] getServletConfigClasses( ) {		
		return new Class[ ] { ServletConfig.class };	
	}		
			
	@Override		
	protected String[ ] getServletMappings( ) {		
		return new String[ ] { "/" };	
	}		
			
	// 404 페이지 설정 -- exception에서 404 페이지 추가 진행		
	@Override		
	protected void customizeRegistration( ServletRegistration.Dynamic registration ) {		
		registration.setInitParameter( "throwExceptionIfNoHandlerFound", "true" );	
	}		
}
