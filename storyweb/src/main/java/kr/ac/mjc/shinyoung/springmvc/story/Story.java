package kr.ac.mjc.shinyoung.springmvc.story;

import org.owasp.encoder.Encode;

import lombok.Data;
@Data
public class Story {
	
	private String seq;
   private String name;
   private String content;
   private String date;
	
	public String getContentHtml() {
		return Encode.forHtml(content).replace("\n", "<br>");
	}
	

}
