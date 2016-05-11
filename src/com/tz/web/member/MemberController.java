/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Member;
import com.tz.bean.TzParams;
import com.tz.service.member.IMemberService;

/**
 * 用户会员管理web
 * MemberController
 * 创建人:Kirio
 * 时间：2016年05月06日 10:12:59
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/member")
public class MemberController {
	
	@Autowired
	private IMemberService memberService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "member/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Member> members = memberService.findMembers(params);
		int count = memberService.count(params);
		modelAndView.setViewName("member/template");
		modelAndView.addObject("datas",members);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	/*更改状态*/
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Member member){
		memberService.update(member);
		return "success";
	}
	
	/*删除*/
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		memberService.delete(params);
		return "success";
	}
}
