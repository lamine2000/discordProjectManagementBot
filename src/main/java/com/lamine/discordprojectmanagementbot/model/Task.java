package com.lamine.discordprojectmanagementbot.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Task {
    @Id
    private String id;
    private String userId;
    private String projectId;
    private String name, description;
    @Builder.Default
    private Boolean isCompleted = false;

    public Task(String guildId, String projectId, String taskName, String taskDescription, boolean isCompleted) {
        this.userId = guildId;
        this.projectId = projectId;
        this.name = taskName;
        this.description = taskDescription;
        this.isCompleted = isCompleted;
    }
}
