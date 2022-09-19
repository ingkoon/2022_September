package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int idCheck() throws Exception; // 아이디 중복검사
	void joinMember(MemberDto memberdto) throws Exception; // 회원가입
	MemberDto loginMember(String userId, String password) throws Exception; // 로그인
	
}
