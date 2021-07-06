package com.example.demo.services;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;


    public Member saveMember (Member news)  {
        news.setUrl("../../assets/img/" + news.getUrl());
        return memberRepository.save(news);
    }

    public List<Member> getMembers()
    {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id)
    {
        return memberRepository.findById(id).orElse(null);
    }

    public String DeleteMember(Long id)
    {
        memberRepository.deleteById(id);
        return "product removed " + id;
    }

    public Member updateMember(Member m)
    {
        Member mem = memberRepository.findById(m.getMember_id()).orElse(null);
        mem.setFirstName(m.getFirstName());
        mem.setLastName(m.getLastName());
        mem.setPost(m.getPost());
        mem.setUrl(m.getUrl());
        return memberRepository.save(mem);
    }
}
