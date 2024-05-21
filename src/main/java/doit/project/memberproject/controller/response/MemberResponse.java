package doit.project.memberproject.controller.response;


import lombok.Getter;

@Getter
public class MemberResponse { // View 용 객체. DTO? (Entity를 그대로 반환하면 보안상의 문제, 순환 참조 에러 문제가 발생함. 따라서 이를 방지)
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
