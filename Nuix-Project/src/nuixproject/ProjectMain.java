package nuixproject;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import nuix.Utilities;
import nuix.engine.CredentialsCallbackInfo;
import nuix.engine.LicenceSourceInformation;
import testingPackage.TestWindow;

public class ProjectMain {
		
	public static void main(String[] args) {
		
		Utilities utilities;
		/*/===================================== Code for getting a Nuix license =====================================
		final String server = "127.0.0.1";
		final String user = "hoffman@digitalda.org";
		final String pass = "cyeJrkCW9rG3";
		final String port = "27443";
		final String data = "C:\\Program Files\\Nuix\\Nuix 7.4\\user-data";
		System.setProperty("nuix.registry.servers", server);
		System.setProperty("nuix.registry.servers.port", port);
		Map<String,String> cfg = new HashMap<String,String>();
		cfg.put("user", user);
		cfg.put("userDataDirs", data);
		nuix.engine.GlobalContainer container = null;
		nuix.engine.Engine engine = null;
		nuix.Utilities utilities = null;
		try {
			container = nuix.engine.GlobalContainerFactory.newContainer();
			engine = container.newEngine(cfg);
			engine.whenAskedForCredentials(new nuix.engine.CredentialsCallback() {
				@Override
				public void execute(CredentialsCallbackInfo cci) {
					cci.setUsername(user);
					cci.setPassword(pass);
				}
			});
			nuix.engine.Licensor licensor = engine.getLicensor();
			cfg.put("sources", "server");
			Iterable<nuix.engine.AvailableLicence> available = licensor.findAvailableLicences(cfg);
			SimpleDateFormat sdf = new SimpleDateFormat();
			for(nuix.engine.AvailableLicence license : available) {
			    LicenceSourceInformation info = license.getSource();
			    String location = info.getLocation();
			    String type = info.getType();
			    System.out.println("Available License [" + license.getSource().getType() + "]");
			    System.out.println(" - Source Location: " + license.getSource().getLocation());
			    System.out.println(" - Audit Threshold: " + license.getAuditThreshold());
			    System.out.println(" - Count: " + license.getCount());
			    System.out.println(" - Short Name: " + license.getShortName());
			    System.out.println(" - Description: " + license.getDescription());
			    System.out.println(" - Expiry: " + sdf.format(license.getExpiry().toDate()));
			    System.out.println(" - Workers: " + license.getWorkers());
			    System.out.println(" - Location: " + location);
			    System.out.println(" - Type: " + type);
			    
			    license.acquire();
			    break;
			}
			utilities = engine.getUtilities();
			System.out.println("A " + utilities.getLicence().getDescription() + " (short-name=" + utilities.getLicence().getShortName() + ") license has been acquired.");
			} finally {
			    if(engine != null)
			        engine.close();
			    if(container != null)
			        container.close();
			}
		//===================================== End code for getting a license ===================================== */
		
		
		//so by this point we have a functioning utlities object
		//first thing is to get the GUI running
		//GuiMain masterFrame = new GuiMain(utilities); //create the GUI and pass it the utilities object we got
		//masterFrame.createWindow();
		utilities = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui(utilities);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
