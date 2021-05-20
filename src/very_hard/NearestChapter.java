//Nearest Chapter
//Create a function that returns which chapter is nearest to the page you're on.
//If two chapters are equidistant, return the chapter with the higher page number.
//
//Examples
//nearestChapter(new Chapter[] {
//  new Chapter("Chapter 1", 1),
//  new Chapter("Chapter 2", 15),
//  new Chapter("Chapter 3", 37)
//}, 10) -> "Chapter 2"
//nearestChapter(new Chapter[] {
//  new Chapter("New Beginnings", 1),
//  new Chapter("Strange Developments", 62),
//  new Chapter("The End?", 194),
//  new Chapter("The True Ending", 460)
//}, 200) -> "The End?"
//nearestChapter(new Chapter[] {
//  new Chapter("Chapter 1a", 1),
//  new Chapter("Chapter 1b", 5)
//}, 3) -> "Chapter 1b"

package very_hard;

import java.util.Arrays;

public class NearestChapter {

	public static void main(String[] args) {

		System.out.println(nearestChapter(new Chapter[] {
				new Chapter("Chapter 1", 1), 
				new Chapter("Chapter 2", 15), 
				new Chapter("Chapter 3", 37),
				new Chapter("Chapter 4", 55),
				new Chapter("Chapter 5", 81)}, 
				33));
		
	}
	
	//easiest way
	public static String nearestChapter(Chapter[] chapter, int page) {
		
		int dist = Math.abs(chapter[0].getPage() - page);
		int cdist = dist;
		int index = 0;
		
		for (int i=0; i<chapter.length; i++) {
			dist = Math.abs(chapter[i].getPage() - page);
			if (dist <= cdist) {
				cdist = dist;
				index = i;
			}	
		}
		
		return chapter[index].getName();
	}
	
	//inefficient way
	public static String nearestChapter2(Chapter[] chapter, int page) {
		
		if (page <= chapter[0].getPage()) 
			return chapter[0].getName();

		if (page >= chapter[chapter.length-1].getPage()) 
			return chapter[chapter.length-1].getName();
		
		int start = 0;
		int end = chapter.length - 1;
		int mid = 0;
 
		while (start < end) {
			mid = (start + end) / 2;
			if (page == chapter[mid].getPage())
				return chapter[mid].getName();
			if (page < chapter[mid].getPage()) {
				if (page > chapter[mid - 1].getPage())
					return Math.abs(page - chapter[mid].getPage()) >= Math.abs(page - chapter[mid - 1].getPage()) ? chapter[mid-1].getName()
							: chapter[mid].getName();
				end = mid - 1;
			}

			if (page > chapter[mid].getPage()) {
				
				if (page < chapter[mid + 1].getPage())
					return Math.abs(page - chapter[mid].getPage()) <= Math.abs(page - chapter[mid + 1].getPage()) ? chapter[mid].getName()
							: chapter[mid + 1].getName();
 
				start = mid + 1;
			}
		}
		
		return chapter[mid].getName();
		
	}
	
	//effective way
	public static String nearestChapter3(Chapter[] chapter, int page) {
		return Arrays.stream(chapter).reduce(new Chapter("", Integer.MAX_VALUE), (a, b) -> 
			a = Math.abs(b.getPage()-page) <= a.getPage() ? new Chapter(b.getName(), Math.abs(b.getPage()-page)) : a).getName();
	}
	
	
}

class Chapter {
	private String name;
	private int page;
	
	public Chapter(String name, int page) {
		this.name = name;
		this.page = page;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPage() { return page; }
	public void setPage(int page) { this.page = page; }
}