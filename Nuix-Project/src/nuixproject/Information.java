package nuixproject;

public class Information {
	//private static String username;
	
	//task_priority
		//ocr
			//3
		//search_tag
			//4
		//email_tag
			//4
		//export
			//5
	
	//section_legal
		//DEFAULT
		//environment
		//tasks
		//ocr
		//export
		//search_tag
		//email_tag
	//environment_legal
		//target_case
			//$PATH$, [nothing]
	//tasks_legal
		//search_tag
			//yes
			//no
		//email_tag
			//yes
			//no
		//ocr
			//yes
			//no
		//export
			//yes
			//no
	//ocr_legal
		//filetype
			//.pdf
			//.tiff
		//quality
			//high_quality
			//mid_range
			//fast
		//only_unsearchable
			//yes
			//no
	//export_legal
		//summary
			//yes
			//no
		//kws_export
			//yes
			//no
	//search_tag_legal
		//file
			//$file$
	//email_tag_legal
		//file
			//$file$
	
	
	
	/*
	   """Initialize static settings and legal lists."""
		# Program information.
		self.username = getpass.getuser()
		# Task information (Priority categories: 1: pre-case, 2: preprocessing, 3: T1 operations (ocr, clustering, etc), 4: T2 operations (search-tagging), 5: exports.)
		self.task_priority = {'ocr': 3, 'search_tag': 4, 'email_tag': 4, 'export': 5}
		#self.task_calls = {'search_tag': op.search_tag, 'email_tag': op.email_tag, 'ocr': op.ocr, 'export': op.export}
		# Legality lists.
		self.section_legal = ('DEFAULT', 'environment', 'tasks', 'ocr', 'export', 'search_tag', 'email_tag')
		self.environment_legal = {'target_case': ('$PATH$',)}
		self.tasks_legal = {'search_tag': ('yes', 'no'), 'email_tag': ('yes', 'no'), 'ocr': ('yes', 'no'), 'export': ('yes', 'no')}
		self.ocr_legal = {'filetype': ('.pdf', '.tiff'), 'quality': ('high_quality', 'mid_range', 'fast'), 'only_unsearchable': ('yes', 'no')}
		self.export_legal = {'summary': ('yes', 'no'), 'kws_export': ('yes', 'no')}
		self.search_tag_legal = {'file': ('$file$')}
		self.email_tag_legal = {'file': ('$file$')}
	 */
}
