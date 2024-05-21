package doit.project.memberproject.service;

import doit.project.memberproject.controller.request.GroupRequest;
import doit.project.memberproject.controller.response.GroupResponse;
import doit.project.memberproject.controller.request.LoginRequest;
import doit.project.memberproject.controller.response.MemberResponse;
import doit.project.memberproject.controller.request.SignUpRequest;
import doit.project.memberproject.repository.Group;
import doit.project.memberproject.repository.GroupRepository;
import doit.project.memberproject.repository.Member;
import doit.project.memberproject.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;

    public List<Member> findAllMemberTest() {
        return memberRepository.findAll();
    }

    public List<MemberResponse> findAllMember() {
        return memberRepository.findAll().stream()
                .map(member ->
                        new MemberResponse(
                                member.getId(),
                                member.getName(),
                                member.getAge(),
                                member.getStudentNumber(),
                                member.getMajor(),
                                new GroupResponse(
                                        member.getGroup().getId(),
                                        member.getGroup().getName(),
                                        member.getGroup().getDescription())
                )).toList();
    }



    public void signUp(SignUpRequest signUpRequest) {

        memberRepository.findByLoginId(signUpRequest.getLoginId())
                .ifPresent(member -> {
                    throw new IllegalArgumentException("이미 존재하는 로그인 아이디입니다.");
                });

        Group group = groupRepository.findById(signUpRequest.getGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 없습니다."));

        Member member = Member.builder()
                .name(signUpRequest.getName())
                .age(signUpRequest.getAge())
                .studentNumber(signUpRequest.getStudentNumber())
                .major(signUpRequest.getMajor())
                .loginId(signUpRequest.getLoginId())
                .password(signUpRequest.getPassword())
                .group(group)
                .build();

        memberRepository.save(member);
    }

    public MemberResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findByLoginIdAndPassword(loginRequest.getLoginId(), loginRequest.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("로그인 정보가 올바르지 않습니다."));

        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getStudentNumber(),
                member.getMajor(),
                new GroupResponse(
                        member.getGroup().getId(),
                        member.getGroup().getName(),
                        member.getGroup().getDescription())
        );
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getStudentNumber(),
                member.getMajor(),
                new GroupResponse(
                        member.getGroup().getId(),
                        member.getGroup().getName(),
                        member.getGroup().getDescription())
        );
    }

    public List<Group> findAllGroup() {
        return groupRepository.findAll();
    }

    public List<GroupResponse> findAllGroupResponse() {
        return groupRepository.findAll().stream()
                .map(group -> new GroupResponse(group.getId(), group.getName(), group.getDescription()))
                .toList();
    }

    public void addGroup(GroupRequest groupRequest) {
        groupRepository.save(
                Group.builder()
                        .name(groupRequest.getName())
                        .description(groupRequest.getDescription())
                        .build()
        );
    }
}
