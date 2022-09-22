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
public class Project {
    @Id
    private String id;
    private String guildId;
    private String name, description;
    @Builder.Default
    private Boolean isCompleted = false;
}
