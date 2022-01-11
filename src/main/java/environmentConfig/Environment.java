package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${envOwner}.properties" })
public interface Environment extends Config {
	@Key("app.url")
	String appUrl();
	
	@Key("app.adminUrl")
	String appAdminUrl();

	@Key("app.username")
	String appUsername();

	@Key("app.password")
	String appPassword();
}
