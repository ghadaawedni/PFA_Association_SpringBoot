
package com.example.demo.controller;
import com.example.demo.model.Member;
import com.example.demo.model.InscriptionRequest;
import com.example.demo.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
@RequestMapping("/member")
public class MemberAPIs {
    @Autowired
    MemberService memberService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }


    @GetMapping("/getMembers")
    public List<Member> getAllInscription() {
        return memberService.getMembers();
    }


    @GetMapping("/getMemberID/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Member findMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Member updateInv(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMember(@PathVariable long id) {
        memberService.DeleteMember(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Success", "OK");
        return ResponseEntity.accepted().build();
    }
}
