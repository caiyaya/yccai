package com.server.feign;

import com.server.web.common.ResultMap;
import com.server.web.entity.dto.CourseBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author huanghua
 * @version 1.0
 * @date 2021/5/21 14:40
 */
@FeignClient(url = "${COURSE_BASE_URL}", name = "CourseBaseFeignService", path = "/mp/selectCourseList")
public interface CourseBaseFeignService {

    @PostMapping("selectCourseList")
    ResultMap selectCourseList(@RequestBody CourseBase request);
}
