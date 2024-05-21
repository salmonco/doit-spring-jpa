package doit.project.memberproject.controller;

import doit.project.memberproject.controller.request.GroupRequest;
import doit.project.memberproject.controller.request.LoginRequest;
import doit.project.memberproject.controller.request.SignUpRequest;
import doit.project.memberproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 목록 조회
     *
     * @return List<MemberResponse>
     */
    @GetMapping("/member")
    public ResponseEntity getMemberList() {
        return ResponseEntity.ok(memberService.findAllMember());
    }

    /**
     * 회원 목록 조회 <br>
     * Entity를 그대로 반환하는 경우
     * @return List<Member>
     */
    @GetMapping("/memberTest")
    public ResponseEntity getMemberListTest() {
        return ResponseEntity.ok(memberService.findAllMemberTest());
    }

    /**
     * 회원 추가
     *
     * @return "{}"
     */
    @PostMapping("/signup")
    public ResponseEntity addMember(@RequestBody SignUpRequest signUpRequest) {
        memberService.signUp(signUpRequest);
        return ResponseEntity.ok("{}");
    }

    /**
     * 로그인
     *
     * @param loginRequest 아이디, 비밀번호
     * @return 로그인한 회원 정보
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(memberService.login(loginRequest));
    }

    /**
     * 회원 조회
     *
     * @param id 회원 id
     * @return 회원 정보
     */
    @GetMapping("/member/{id}")
    public ResponseEntity getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findMember(id));
    }

    /**
     * 그룹 목록 조회 <br>
     * Entity를 그대로 반환하는 경우
     * @return List<Group>
     */
    @GetMapping("/groupTest")
    public ResponseEntity getGroupListTest() {
        return ResponseEntity.ok(memberService.findAllGroup());
    }

/**
     * 그룹 목록 조회
     *
     * @return List<GroupResponse>
     */
    @GetMapping("/group")
    public ResponseEntity getGroupList() {
        return ResponseEntity.ok(memberService.findAllGroupResponse());
    }

    /**
     * 그룹 추가
     * @param groupRequest
     * @return None
     */
    @PostMapping("/group")
    public ResponseEntity addGroup(@RequestBody GroupRequest groupRequest) {
        memberService.addGroup(groupRequest);
        return ResponseEntity.ok("{}");
    }
}
