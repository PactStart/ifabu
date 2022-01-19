package io.github.pactstart.ifabu.controller;

import io.github.pactstart.ifabu.controller.form.AppCreateForm;
import io.github.pactstart.ifabu.controller.form.AppQueryForm;
import io.github.pactstart.ifabu.controller.form.AppUploadLogQueryForm;
import io.github.pactstart.ifabu.dto.AppQueryDto;
import io.github.pactstart.ifabu.entity.App;
import io.github.pactstart.ifabu.errorcode.ResponseCode;
import io.github.pactstart.ifabu.service.AppService;
import io.github.pactstart.ifabu.vo.PageResultVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @ResponseBody
    @RequestMapping("/add")
    public ResponseCode add(@Valid @RequestBody AppCreateForm appCreateForm) {
        App app = new App();
        app.setName(appCreateForm.getName());
        app.setAvatar(appCreateForm.getAvatar());
        appService.add(app);

        return ResponseCode.SUCCESS;
    }

    @ResponseBody
    @RequestMapping("/list")
    public ResponseCode list() {
        List<App> appList = appService.getAll();
        return ResponseCode.build(appList);
    }

    @ResponseBody
    @RequestMapping("/query")
    public ResponseCode query(@Valid @RequestBody AppQueryForm appQueryForm) {
        AppQueryDto appQueryDto = new AppQueryDto();
        appQueryDto.setName(appQueryForm.getName());
        appQueryDto.setPageSize(appQueryForm.getPageSize());
        appQueryDto.setPageNum(appQueryForm.getPageNum());

        PageResultVo<App> pageResultVo = appService.query(appQueryDto);

        return ResponseCode.build(pageResultVo);
    }

    @ResponseBody
    @RequestMapping("/upload")
    public ResponseCode upload(@RequestParam("file") MultipartFile file, @RequestParam("appId") Integer appId, @RequestParam(value = "fileName") String fileName) {
        return ResponseCode.SUCCESS;
    }

    @ResponseBody
    @RequestMapping("/uploadLog/query")
    public ResponseCode queryUploadLog(@Valid @RequestBody AppUploadLogQueryForm appUploadLogQueryForm) {
        return ResponseCode.SUCCESS;
    }

    @ResponseBody
    @RequestMapping("/getLatestVersion")
    public ResponseCode getLatestVersion(@RequestParam String appKey) {
        return ResponseCode.SUCCESS;
    }

}
