package nuixproject;

import nuix.Utilities;

public class ProjectMain {
	
	private static Gui theGui;
	private static MyLogger logger;
		
	public static void main(String[] args) {
		
		Utilities utilities = null;
		/*/===================================== Code for getting a Nuix license =====================================
		final String server = "ec2-23-21-229-158.compute-1.amazonaws.com";
		final String user = "email";
		final String pass = "password";
		final String port = "27443";
		final String data = "/Users/main/nuix-engine-x86_64-7.2.4/user-data";
		System.setProperty("nuix.registry.servers", server);
		System.setProperty("nuix.registry.servers.port", port);
		Map<String,String> cfg = new HashMap<String,String>();
		cfg.put("user", user);
		cfg.put("userDataDirs", data);
		nuix.engine.GlobalContainer container = null;
		nuix.engine.Engine engine = null;
		utilities = null;
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
		//===================================== End code for getting a license ===================================== 
		 */
		
		
		//so by this point we have a functioning utlities object
		//first thing is to get the GUI running
		//GuiMain masterFrame = new GuiMain(utilities); //create the GUI and pass it the utilities object we got
		//masterFrame.createWindow();
		//utilities = null;
		
		
		
		logger = new MyLogger(); //boot up the logger and send it a reference to the Gui
		
		try {
			theGui = new Gui(utilities, logger);
			logger.setGui(theGui);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
		    @Override
		    public void run() {
		        logger.closeLog();
		    }
		});

	}
}
