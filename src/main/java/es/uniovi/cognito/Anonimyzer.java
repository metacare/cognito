/* 
 * MIT License
 * 
 * Copyright (c) 2018 Guillermo Facundo Colunga
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package es.uniovi.cognito;

import java.util.HashSet;
import java.util.Set;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * The Class Anonimyzer.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class Anonimyzer implements RequestHandler<Request, Response> {
	
	/** The personal data. */
	private Set<String> personalData = new HashSet<String>();

	/* (non-Javadoc)
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	public Response handleRequest( Request input, Context context ) {
		setUp();
		return new Response(this.anonimyzeText(input.getToAnonimyze()));
	}
	
	/**
	 * Sets the up.
	 */
	private void setUp() {
		personalData.add( "Paco" );
		// Add more people here and personal data.
	}
	
	/**
	 * Anonimyze text.
	 *
	 * @param text the text
	 * @return the string
	 */
	public String anonimyzeText(String text) {
		String[] words = text.split(" ");
		text = "";
		for(String word : words) {
			if(personalData.contains( word )) {
				word = "xxx";
			}
			text += word + " ";
		}
		return text;
	}
}
