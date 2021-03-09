package app;

public class Langpack {
	
	static int langset = 0;
	
	static void language() {
		// TODO Language selection
		switch (langset) {
		case 0:
			System.out.println("Pasirinkta lietuviø kalba.");
			langset = 0;
			break;
		case 1:
			System.out.println("Selected English language.");
			langset = 1;
			break;
		}
		
	}
	
}
