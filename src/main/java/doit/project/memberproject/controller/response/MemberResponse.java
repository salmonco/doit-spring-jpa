package doit.project.memberproject.controller.response;


import lombok.Getter;

@Getter
public class MemberResponse {
    Long memberId;
    String name;
    Integer age;
    String studentNumber;
    String major;
    GroupResponse groupResponse;

    public MemberResponse(Long memberId, String name, Integer age, String studentNumber, String major, GroupResponse groupResponse) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.major = major;
        this.groupResponse = groupResponse;
    }
}
