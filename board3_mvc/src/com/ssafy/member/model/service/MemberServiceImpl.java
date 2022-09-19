package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService= new MemberServiceImpl();
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
	
		return memberService;
	}
	
	
	@Override
	public int idCheck() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void joinMember(MemberDto memberdto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDto loginMember(String userId, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
