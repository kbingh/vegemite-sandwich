 /** Copyright (c) 2017 Ken Bingham
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
**/

package com.kb.html;

import java.util.ArrayList;

import com.kb.html.components.Text;
import com.kb.html.tags.Tag;

public class Html extends ArrayList<Tag>{
	
	private static final long serialVersionUID = 1L;
	private StringBuilder htmlBuilder = new StringBuilder();
	private StringBuilder tabBuilder = new StringBuilder();
	int index = 0;
	
	public Html(){}
	
	public Html(Tag tag){
		
		addTag(tag);
	}
	
	public Tag addTag(Tag tag){
		
		add(tag);
		return tag;
	}
	
	public String getHtml(){
			
		getChildren(get(0));
		
		return htmlBuilder.toString();	
	}

	private Tag getChildren(Tag parent) {
		
		 boolean isHtmlText = parent instanceof Text;
		 
		 if(isHtmlText){
			 htmlBuilder.append(parent.getText());
			 return parent;
		 }
		 
		 htmlBuilder.append(tabBuilder.toString()).append(parent.getTag()).append("\n");
		 tabBuilder.append("\t");
		
		 for(Tag tag : parent.getChildren()){
			 
			
			 if(tag != null){
				
				 if(tag.getChildren().isEmpty()){
					
					 htmlBuilder.append(tabBuilder.toString()).append(tag.getTag() + tag.endTag()).append("\n");
				 }else{
					 
						 getChildren(tag);
					
				 }
			 }
		 }
		 tabBuilder.delete(0, 1);
		 htmlBuilder.append(tabBuilder.toString()).append(parent.endTag()).append("\n");
		
		 return null;
	}
	
}
