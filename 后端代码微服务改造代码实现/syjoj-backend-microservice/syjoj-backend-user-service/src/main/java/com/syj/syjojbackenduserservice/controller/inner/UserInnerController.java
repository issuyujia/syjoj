package com.syj.syjojbackenduserservice.controller.inner;

import com.syj.syjojbackendmodel.model.entity.User;
import com.syj.syjojbackendserviceclient.service.UserFeignClient;
import com.syj.syjojbackenduserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author syj
 * @date 2024/8/19 20:28
 */

/**
 * 注意：改服务仅内部调用，外部无法调用
 */
@RestController
@RequestMapping("/inner")
public class UserInnerController implements UserFeignClient {
    @Resource
    private UserService userService;
    /**
     * 根据id获取用户
     * @Param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") long userId){
        return userService.getById(userId);
    }

    /**
     * 根据id获取用户列表
     * @param idList
     * @return
     */
    @Override
    @GetMapping("/get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList){
        return userService.listByIds(idList);
    }
}
