package cn.com.pfinfo.vertx;

import cn.com.pfinfo.vertx.verticle.HttpVerticle;
import io.vertx.core.Launcher;

public class VertxApplication extends Launcher {
	public static void main(String[] args) {
		new VertxApplication().dispatch(args);
	}

	@Override
	protected String getMainVerticle() {
		return HttpVerticle.class.getName();
	}
}