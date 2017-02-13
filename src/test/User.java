package test;

import org.nutz.redis.dao.entity.annotation.FK;
import org.nutz.redis.dao.entity.annotation.KeyPrefix;
import org.nutz.redis.dao.entity.annotation.MK;
import org.nutz.redis.dao.entity.annotation.Orderby;

import java.util.Date;

/**
 * Created by Jianghao on 2017/2/8
 *
 * @howechiang
 */
@KeyPrefix("aitaohuo:user:")
@FK({"comId", "groupId"})
public class User {

    @MK
    private Integer id;

    private Integer comId;

    private Integer groupId;

    private String userName;

    @Orderby
    private Date addTime;

    private Date loginTime;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
