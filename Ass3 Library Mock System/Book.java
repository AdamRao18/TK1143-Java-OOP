public class Book {
   private String title;
   private String author;
   private Student studentBorrowed;
   
   public Book (String title,String author) {
	   this.title=title;
	   this.author=author;
   }
	
   public String getTitle() {
	   return title;
	   
   }
	
   public String getAuthor() {
	   return author;
	   
   }
   
   public void borrowBy(Student student) {
       studentBorrowed = student;
       
   }
 
	public String toString() {
		return title + "("+author+")";
	}
}
