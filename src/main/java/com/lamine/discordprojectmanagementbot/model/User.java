package com.lamine.discordprojectmanagementbot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    private String id;
    private List<String> guildsId;
}
