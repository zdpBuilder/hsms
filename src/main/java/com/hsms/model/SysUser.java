package com.hsms.model;

public class SysUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.name
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_password
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String loginPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.phone
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.status
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.creater
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.create_time
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.updater
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.update_time
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_id
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    private String loginId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.name
     *
     * @return the value of sys_user.name
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.name
     *
     * @param name the value for sys_user.name
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_password
     *
     * @return the value of sys_user.login_password
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_password
     *
     * @param loginPassword the value for sys_user.login_password
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.phone
     *
     * @return the value of sys_user.phone
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.phone
     *
     * @param phone the value for sys_user.phone
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.status
     *
     * @return the value of sys_user.status
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.status
     *
     * @param status the value for sys_user.status
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.creater
     *
     * @return the value of sys_user.creater
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.creater
     *
     * @param creater the value for sys_user.creater
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.create_time
     *
     * @return the value of sys_user.create_time
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.create_time
     *
     * @param createTime the value for sys_user.create_time
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.updater
     *
     * @return the value of sys_user.updater
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.updater
     *
     * @param updater the value for sys_user.updater
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.update_time
     *
     * @return the value of sys_user.update_time
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.update_time
     *
     * @param updateTime the value for sys_user.update_time
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_id
     *
     * @return the value of sys_user.login_id
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_id
     *
     * @param loginId the value for sys_user.login_id
     *
     * @mbg.generated Wed Jun 20 08:29:13 CST 2018
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }
}