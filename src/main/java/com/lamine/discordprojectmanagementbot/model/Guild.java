package com.lamine.discordprojectmanagementbot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Guild {
    @Id
    private String id;
}
