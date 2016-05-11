package com.tz.tag;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tz.bean.Content;
import com.tz.service.content.IContentService;
import com.tz.util.TmStringUtils;

public class ContentBeanTag extends BodyTagSupport {
	private String var;// 变量的对象名称
	private Integer cid;

	public int doStartTag() throws JspException {
		ServletContext context = this.pageContext.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		IContentService contentService = (IContentService) ctx.getBean("contentServiceImpl");
		Content content = contentService.getContent(cid);
		if (TmStringUtils.isEmpty(var))var = "content";
		pageContext.setAttribute(var, content);
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
}
