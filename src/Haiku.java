public class Haiku {

	private String lines;

	public Haiku(){
		int choice = (int) (Math.random()*6);

		switch (choice) {
			case 1:
				lines = "Delightful display\n" +
						"Snowdrops bow their pure white heads\n" +
						"To the sun's glory";
				break;
			case 2:
				lines = "Like crunchy cornflakes\n" +
						"Gold leaves rustle underfoot\n" +
						"Beauty in decay.";
				break;
			case 3:
				lines = "The chill, worming in\n" +
						"Shock, pleasure, bursting within\n" +
						"Summer tongue awakes";
				break;
			case 4:
				lines = "You and me alone\n" +
						"Madness of world locked away\n" +
						"Peace and quiet reigns";
				break;
			case 5:
				lines = "Strokes of affection\n" +
						"Light and tenderly expressed\n" +
						"Keep love’s bonds so strong.";
				break;
			case 6:
				lines = "Calm as a river\n" +
						"Tranquility in my heart\n" +
						"Blue summer skies reign.";
				break;
			case 7:
				lines = "Mellow, mild, May day,\n" +
						"calling children out to play.\n" +
						"Summer's on her way!";
		}
	}


	public String getLines() {
		return lines;
	}

	public static void main(String[] args){

	}

}
