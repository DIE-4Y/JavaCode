package edu.nenu.tliaswebserver.controller;

import edu.nenu.tliaswebserver.pojo.Dept;
import edu.nenu.tliaswebserver.pojo.Result;
import edu.nenu.tliaswebserver.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/depts")   //加上这个后边的就只用添加后续路径
@RestController
public class DeptController {

    //记录日志 使用Slf4j注解 能直接使用log对象记录日志
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    //自动注入DeptService对象
    @Autowired
    private DeptService deptService;

    /**
     * 获取所有部门信息
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET) 指定请求类型
    //@GetMapping("/depts")   //自动指定请求类型为get
    @GetMapping
    public Result list() {
        log.info("获取所有部门信息");
        List<Dept> depts = deptService.deptList();
        return Result.success(depts);
    }

    /**
     * 根据单个id删除部门
     * PathVariable 绑定id参数
     */
    //@DeleteMapping("/depts/{id}")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 插入部门 请求参数用Dept自动接收
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门信息");
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查找单个部门所有信息
     */
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id) {
        log.info("根据id = {}开始寻找", id);
        return Result.success(deptService.selct(id));
    }

    /**
     * 根据id修改部门名称
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改id为{}的部门",dept.getId());
        deptService.update(dept);
        return Result.success();
    }
}