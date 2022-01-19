package io.github.pactstart.ifabu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.ifabu.dao.AppMapper;
import io.github.pactstart.ifabu.dto.AppQueryDto;
import io.github.pactstart.ifabu.entity.App;
import io.github.pactstart.ifabu.service.AppService;
import io.github.pactstart.ifabu.utils.AppUtils;
import io.github.pactstart.ifabu.vo.PageResultVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppMapper appMapper;

    @Override
    public void add(App app) {
        if (!StringUtils.hasText(app.getAvatar())) {
            app.setAvatar("");
        }
        app.setCreateAt(System.currentTimeMillis());
        app.setUpdateAt(System.currentTimeMillis());
        app.setAppKey(AppUtils.generateRandomStr(6));
        appMapper.insert(app);

    }

    @Override
    public List<App> getAll() {
        return appMapper.selectAll();
    }

    @Override
    public PageResultVo<App> query(AppQueryDto appQueryDto) {
        Page<App> page = PageHelper.startPage(appQueryDto.getPageNum(), appQueryDto.getPageSize())
                .doSelectPage(() -> appMapper.query(appQueryDto.getName()));

        PageResultVo pageResultVo = new PageResultVo(appQueryDto.getPageSize(), appQueryDto.getPageNum(), page.getPages(), page.getTotal(), page.getResult());
        return pageResultVo;
    }
}
