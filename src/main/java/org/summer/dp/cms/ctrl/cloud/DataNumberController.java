/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:20
 * @desc 数据表
 */

package org.summer.dp.cms.ctrl.cloud;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.summer.dp.cms.ctrl.BaseController;
import org.summer.dp.cms.service.cloud.DataNumberService;
import org.summer.dp.cms.support.Response;
import org.summer.dp.cms.vo.ExportForm;
import org.summer.dp.cms.vo.ExportFormRequest;
import org.summer.dp.cms.vo.ExportFormResponse;


@RestController
public class DataNumberController extends BaseController {
	@Autowired
	private DataNumberService dataNumberService;
	/**
	 * 报表数据查询控制器
	 * @param response
	 * @param exportFormRequest
	 * @return
	 */
	@RequestMapping(value = "/exportForm")
	public @ResponseBody ExportFormResponse exportForm(Response response ,ExportFormRequest exportFormRequest){
		System.out.println(exportFormRequest.toString());
		
		List<ExportForm> exportFormList = this.dataNumberService.exportForm(exportFormRequest);
		ExportFormResponse exportFormResponse = new ExportFormResponse();
		exportFormResponse.toResponse(exportFormList, exportFormRequest);
		System.out.println(exportFormResponse.toString());
		response.setData(exportFormResponse.toString());
		return exportFormResponse;
	}

}
