package com.bootdo.welcome.publish.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.common.service.LogService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.BatchRemoveInput;
import com.bootdo.welcome.vo.DeletedIdVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.domain.LogDO;

/**
 * 系统日志 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:45
 */
 
@RestController
@RequestMapping("/welcome/log")
@Api(value="系统日志相关服务",description="系统日志相关服务")
public class SLogController {

	static Logger log = LoggerFactory.getLogger(SLogController.class);
	
	@Autowired
	private LogService logService;
	
	@Autowired
	ValidateMessage validateMessage;
	
//	@Log("获取xxx列表")
//	@GetMapping("/list")
//	@ApiOperation(value="获取xxx列表", notes="获取xxx列表")
////  @ApiImplicitParams({
////		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
////  })
//	@ApiResponses({
//		@ApiResponse( response = LogDO.class, code = 200, message = "返回结构:LogDO的list")
//	})
//	public List<LogDO> getList( LogDO condition){
//		//查询列表数据
//       Map<String,Object> params = new HashMap<String,Object>();
////     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
//       
//		return logService.findPageListByMap(params);
//	}
//	
//	@Log("获取xxx分页列表")
//	@GetMapping("/list/page")
//	@ApiOperation(value="获取xxx分页列表", notes="获取xxx分页列表")
//    @ApiImplicitParams({
//		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
//		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
//    })
//	@ApiResponses({
//		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
//	})
//	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size,  LogDO condition){
//		//查询列表数据
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("page", page);//数据偏移量
//		params.put("size", size);//每页条数
//		params.put("sort", "id");//每页条数
//		params.put("order", "asc");//每页条数
////     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
//		
//		PQuery query = new PQuery(params);
//		int total = logService.countByMap(query);		
//		PPageUtils pageUtil = new PPageUtils(logService.findPageListByMap(query), total,page,size);
//		return pageUtil;
//	}
//	
//	
//	@Log("添加XXX")
//	@PostMapping("/save")
//	@ApiOperation(value="添加XXX", notes="添加XXX"
//			+ "入参Log，是LogDO(XXX类)")
//	@ApiResponses({
//		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
//	})
//	public PR save(@RequestBody  LogDO log) {
//		//异常判断
////		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
//		
//		if(logService.save(log)>0){
//			return PR.ok("添加XXX成功");
//		}
//		return PR.error("添加XXX失败");
//	}
//	
//	@Log("修改XXX信息")
//	@PostMapping("/update")
//	@ApiOperation(value="修改XXX", notes="修改XXX"
//		+ "入参Log，是LogDO(XXX类)")
//	@ApiResponses({
//		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
//	})
//	public PR update(@RequestBody LogDO log) {
//		
//		//异常判断
////		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
//		
//		if (logService.updateById(log) > 0) {
//			
//			return PR.ok("修改XXX成功");
//		}
//		return PR.error("修改XXX失败");
//	}
	
	@Log("删除XXX信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除XXX", notes="删除XXX,入参是XXXId")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(logService.removeById(vid.getId())>0){
			return PR.ok("删除XXX成功");
		}
		return PR.error("删除XXX失败");
		
	}
	
	@Log("批量删除XXX信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除XXX", notes="批量删除XXX")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(logService.batchRemoveByIds(bids.getIds())>0){
			return PR.ok("批量删除XXX成功");
		}
		return PR.error("批量删除XXX失败");
	}
	
}
