package doit.project.memberproject.controller.request;

import lombok.Getter;

@Getter
public class SignUpRequest {
    private String name;
    private int age;
    private String studentNumber;
    private String major;
    private String loginId;
    private String password;
    private Long groupId;
}
