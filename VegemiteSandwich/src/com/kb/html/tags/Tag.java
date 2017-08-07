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

package com.kb.html.tags;

import java.util.ArrayList;
import com.kb.html.Attribute;

public class Tag {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String text;
	
	private ArrayList<Attribute> attrList = new ArrayList<Attribute>();
	private ArrayList<Tag> children = new ArrayList<Tag>();
	private StringBuilder attrBuilder = new StringBuilder();
	
	public Tag(String type){
		this.type = type;
		text = "";
	}
	public Tag(String type, String text){
		this.type = type;
		this.text = text;
	}
	public String getType(){
		return type;
	}
	public Tag attr(String type, String value){
		attrList.add(new Attribute(type,value));
		return this;
	}
	public String getAttrs(){
		for(Attribute attr : attrList){
			attrBuilder.append(attr.getAttr());
		}
		return attrBuilder.toString();
	}
	public Tag setText(String textType, String text){
    	this.text = "<" + type +  ">" + text;
    	return this;
    }
	public Tag text(String text){
    	this.text = text;
    	return this;
    }
	public String getText(){
		return text;
	}
	public String getTag(){
		return "<" + type + getAttrs() + ">" + text;
	}
	
	public String endTag(){
		return "</" + type + ">";
	}
	public Tag addChild(Tag htmlTag){
		children.add(htmlTag);
		return this;
	}
	public Tag removeChild(Tag htmlTag){
		children.remove(htmlTag);
		return this;
	}
	public ArrayList<Tag> getChildren(){
		return children;
	}
}
