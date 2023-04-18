package com.zust.austin.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 上传后成功返回素材的Id
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResponseVo {
    private String id;
}
