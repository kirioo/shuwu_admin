package com.tz.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.service.content.IContentService;
import com.tz.util.TmStringUtils;

public class ContentListTag extends BodyTagSupport{
	//对象属性
	private String var;//变量的对象名称
	//内容迭代器
	private Iterator<Content> iterator = null;
	//索引
	private Integer index = 0;
	//分页
	private Integer pageNo;
	private Integer pageSize;
	//内容所属的栏目
	private Integer channelId;
	//表示年月日
	private Integer mark;
	//删除状态
	private Integer isDelete;
	//搜索的关键词
	private String keyword;
	
	public int doStartTag() throws JspException {
		//获取应用上下文
		ServletContext context = this.pageContext.getServletContext();
		//获取sprignweb容器的应用上下文，因为在web容器启动的时候，容器会将spring的applicationContext注入到一个叫application的上下文中
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		//从webapplicationContext获取对应的对象
		//applicationContext//ClassPathXmlApplicationcontext/FileSystemApplication/WebApplicationContext
		IContentService contentService = (IContentService) ctx.getBean("contentServiceImpl");
		if (TmStringUtils.isEmpty(var))var = "content";
		//设置参数
		TzParams params  = new TzParams();
		params.setIsDelete(isDelete==null?0:isDelete);
		params.setPageNo(pageNo==null?0:pageNo);
		params.setPageSize(pageSize==null?10:pageSize);
		params.setChannelId(channelId);
		params.setMark(mark);
		params.setKeyword(keyword);
		//调用方法
		List<Content> contents = contentService.findContents(params);
		if (contents != null && contents.size() > 0) {
			index = 0;
			//长度返回
			pageContext.setAttribute(var + "_size", contents.size());
			//索引返回
			pageContext.setAttribute(var + "_index", index);
			//开始迭代
			iterator = contents.iterator();
			//放作用于，渲染标签提中的el表达式,从这里pageContext的作用于中获取对象
			pageContext.setAttribute(var, iterator.next());
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
	
	public int doAfterBody() throws JspException {
		if (iterator.hasNext()) {
			index++;
			pageContext.setAttribute(var, iterator.next());
			pageContext.setAttribute(var + "_index", index);
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
	

	public int doEndTag() throws JspException {
		iterator = null;
		index = 0;
		return EVAL_PAGE;
	}


	public void setVar(String var) {
		this.var = var;
	}

	public void setIterator(Iterator<Content> iterator) {
		this.iterator = iterator;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
