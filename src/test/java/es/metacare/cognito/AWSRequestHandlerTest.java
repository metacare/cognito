package es.metacare.cognito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import es.metacare.cognito.AWSRequestHandler;
import es.metacare.cognito.Request;
import es.metacare.cognito.Response;

public class AWSRequestHandlerTest {
	
	RequestHandler<Request, Response> requestHandler;
	Request request; 
	Response response;
	
	@Before
	public void setUp() {
		requestHandler = new AWSRequestHandler();
		request = new Request( "paco tenia una casa" );
		response = new Response( "xxx tenia una casa " );
	}

	@Test
	public void test() {
		// Case 1
		assertEquals( response.getTextAnonimyzed(), 
						requestHandler.handleRequest( request, null ).getTextAnonimyzed() );
		
		// Case 2
		assertFalse( requestHandler.handleRequest( request, null ).getTextAnonimyzed().contains( "paco" ) );
	}

}
