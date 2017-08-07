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

package com.kb.html.components;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TextBoxList<T> extends ArrayList<TextBox> {
	
	
	private static final long serialVersionUID = 1L;
	T t;
	public TextBoxList(T t){
		this.t = t;
		
	}
	public ArrayList<TextBox> getTextBoxes(){
		
		for(Field field : t.getClass().getDeclaredFields()){
			TextBox textbox = null;
			try {
				field.setAccessible(true);
				textbox = new TextBox(field.get(t).toString());
				String id = "textBox_" + "_" + Math.sqrt((double)field.getName().hashCode() + (double)t.getClass().getName().hashCode());
				textbox.attr("id", id);
				add(textbox);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this;
	}
}