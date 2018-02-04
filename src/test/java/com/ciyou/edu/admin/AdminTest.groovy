package com.ciyou.edu.admin

import com.ciyou.edu.app.App
import com.ciyou.edu.entity.Admin
import com.ciyou.edu.service.AdminService
import org.apache.shiro.crypto.hash.Md5Hash
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import java.security.NoSuchAlgorithmException
import java.security.SecureRandom

/**
 * @Author C.
 * @Date 2018-02-02 18:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
class AdminTest {

    @Autowired
    private AdminService adminService

    @Test
    void addAdminTest(){
        Admin admin = new Admin()
        admin.setAdminName("3")
        admin.setIsAvalible(1)
        String passwordMd5= new Md5Hash("3","3",2).toHex()
        admin.setPassword(passwordMd5)
        println adminService.addAdmin(admin)
    }

    @Test
    void findAdminById(){
        println adminService.findAdminById(1)
    }


    /**
     * 生成盐
     * @return
     */
    public static byte[] createSalt(){
        byte[] salt = new byte[16]
        try {
            SecureRandom random = SecureRandom.getInstance("3")
            random.nextBytes(salt)
            return salt
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}