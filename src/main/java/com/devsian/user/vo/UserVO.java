package com.devsian.user.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class UserVO {
    Integer id;
    String userId;
    String name;
    String password;
    Integer tier;

    public Integer getId() { return id; }
    public String getUserId() {return userId; }
    public String getName() {return name; }
    public Integer getTier() {return tier;}

    public String getUserPassword() {
        return password;
    }
}
