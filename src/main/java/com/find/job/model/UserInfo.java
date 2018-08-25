

package com.find.job.model;

import javax.persistence.*;


@Table(name = "users")
public class UserInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @JoinColumn(name = "employee_id", updatable = false)
    private String employeeId;
    @Column(name = "login_mobile")
    private String loginMobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLoginMobile() {
        return loginMobile;
    }

    public void setLoginMobile(String loginMobile) {
        this.loginMobile = loginMobile;
    }
}
