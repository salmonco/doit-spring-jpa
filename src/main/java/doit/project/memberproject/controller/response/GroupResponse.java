package doit.project.memberproject.controller.response;

import lombok.Getter;

@Getter
public class GroupResponse {
    private Long id;
    private String name;
    private String description;

    public GroupResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
