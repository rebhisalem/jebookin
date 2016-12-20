

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.project.BL.IBookService;

import com.spring.project.Config.HibernateConfiguration;
import com.spring.project.Data.Author;
import com.spring.project.Data.Book;
import com.spring.project.Data.Comment;
import com.spring.project.Repo.DAL.RepositoryAuthorInterface;
import com.spring.project.Repo.DAL.RepositoryBook;
import com.spring.project.Repo.DAL.RepositoryBookInterface;


public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
RepositoryBookInterface bk = (RepositoryBookInterface) context.getBean("repositoryBook");
		//		Author a = new Author("74558j798532a", "victor", "hugo");
//		bk1.add(a);
//		//RepositoryBook dao = new RepositoryBook();
		Date date = new Date();
		//RepositoryClientInterface client = (RepositoryClientInterface) context.getBean("CommentDao");
		Comment cmt = new Comment();
		Book b1 = new Book("87899", "hello", date ,89, 789,"littérature");
		List<Comment> comments = new ArrayList<>() ;
		comments.add(cmt);
		b1.setCommentaires(comments);
		Book b2 = new Book("81899", "hello", date ,89, 789,"littérature");
		Book b3 = new Book("88992", "hello", date ,89, 789,"littérature");
		Book b4 = new Book("88993", "hello", date ,89, 789,"littérature");
		Book b5 = new Book("88994", "hello", date ,89, 789,"littérature");
		bk.add(b1);
		bk.add(b2);
		bk.add(b3);
		bk.add(b4);
		bk.add(b5);
	
		IBookService bk11 = (IBookService) context.getBean("bookService");
		List<Book> list = bk11.rechercheRapide("Les misérables");
		System.out.println(list.toString());
	List<Book> list1 = bk11.meilleuresVentes();
		System.out.println(list1.toString());
		List<Book> list12 = bk11.lesPlusRecents();
		System.out.println(list12.toString());
		

//	Book b = (Book) bk.find("47");
//	System.out.println("hello"+b.toString());
		
		
	}
}