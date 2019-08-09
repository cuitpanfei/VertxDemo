package cn.com.pfinfo.vertx.verticle;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HttpVerticle extends AbstractVerticle {

	private final Log log = LogFactory.get(getClass());
	
	@Override
	public void start() throws Exception {
		Router router = Router.router(vertx);
		addRoutes(router);
		vertx.createHttpServer().requestHandler(router::handle).listen(8080);
	}

	/**
	 * 初始化路由转发
	 * 
	 * @param router 路由中心
	 */
	private void addRoutes(Router router) {
		router.get("/test").handler(event->{
			event.getBodyAsString();
			event.pathParams();
			event.data();
			event.queryParams();
			event.session();
			event.request();
			event.response().end(JSONUtil.createObj().put("msg", "success").toString());
			event.parsedHeaders();
			StaticLog.info(log, "请求了{}",event.request().path());
			event.next();
		});
	}


}
