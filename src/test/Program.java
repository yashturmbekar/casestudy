package test;

import java.util.List;
import java.util.Scanner;

import dao.LabDao;
import dao.Signindao;
import pojo.Book;
import pojo.Member;
import user.Owner;

public class Program {
	static Scanner sc = new Scanner(System.in);
	
	
	
	private static void acceptRecord(Book book) 
	{
		System.out.print("Book id	:	");
		book.setBookId(sc.nextInt());
		System.out.print("Subject Name	:	");
		sc.nextLine();
		book.setSubjectName(sc.nextLine());
		System.out.print("Book Name	:	");
		book.setBookName(sc.nextLine());
		System.out.print("Author Name	:	");
	    book.setAuthorName(sc.nextLine());
	    System.out.print("ISBN: ");
		book.setIsbn(sc.nextLine());
		System.out.print("Price	:	");
		book.setPrice(sc.nextFloat());
		
		
	}
		
	private static void acceptRecord(String[] name)
	{
		System.out.println("Enter the name of the book");
		sc.nextLine();
		name[0]=sc.nextLine();
	}
	
	private static void printRecord(List<Book> books)
	{
		if( books != null )
		{
			for (Book book : books) 
				System.out.println(book.toString());
		}
	}
	
	private static void dispRecord(List<Member> member) 
	{

		if(member!= null)
		{
			for (Member mem: member)
			{
				System.out.println(mem.toString());
			}
		}
		
	}
	
	public static int menuList( )
	{
		System.out.println("0. Sign Out");
		System.out.println("1. Edit Profile");
		System.out.println("2. Change password");
		System.out.println("3.Find Book By Name ");
        System.out.println("4. Check Book Availability");
		System.out.println("5. Add New Book");
		System.out.println("6. Add New Copy");
		System.out.println("7. issue book copy");
		System.out.println("8. return book copy");
		System.out.println("9. list issues books");
		System.out.println("10. edit Book");
		System.out.println("11. Change Rack");
		System.out.println("12. Add Member");
		System.out.println("13. Take Payment");
		System.out.println("14. Payment History");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	
	
	
	private static void UpdateUser(Owner owner) {
		
		System.out.print("New email : ");
		owner.setEmail(sc.next());
		System.out.print("New Mobile : ");
		owner.setPhone(sc.next());
	}
	private static void updatePassword(Owner owner) {
		System.out.print("Enter password :");
		owner.setPasswd(sc.next());
	}
	
public static boolean signIn(Owner owner) {
	
	System.out.print("User Email : ");
	owner.setEmail(sc.next());
	System.out.print("Password : ");
	owner.setPasswd(sc.next());
	if(owner.check(owner))
	{
		return true;	
	}
	else
	{
		return false;
	}
		
}

public static boolean check(List<Owner> own, Owner owner) {

	if(own != null) {
	    if(own.contains(owner.getEmail()))
	   {
		return true;
	   }
	    else
	    {
	    	return false;
	    }
	}
	
	return false;
}


private static void signup(Owner owner) 
{
  System.out.print("1. Enter Name : ");
  owner.setName(sc.next());
  System.out.print("2. Enter Email : ");
  owner.setEmail(sc.next());
  System.out.print("3. Enter Phone : ");
  owner.setPhone(sc.next());
  System.out.print("4. Enter Password : ");
  owner.setPasswd(sc.next());
  owner.setRole("Owner");
  
}	
public static int ownerMenuList()
{
	System.out.println("0. Exit");
	System.out.println("1. Sign In");
	System.out.println("2. Sign Up");
	System.out.print("Enter Your choice : ");
	return sc.nextInt();
}


public static int menulist()
{
  System.out.println("1. Owner");
  System.out.println("2. Librarian");
  System.out.println("3. Memeber");
  System.out.print("Enter Your Choice : ");
  return sc.nextInt();
}

public static int ownerEdit() {
	System.out.println("0. Sign Out");
	System.out.println("1. Edit Profile");
	System.out.println("2. Change pasword");
	System.out.println("3. Subjectwise copies book");
	System.out.println("4. Bookwise copies Report");
	System.out.println("5. Fees / Fine Report");
	System.out.print("Enter Your Choice : ");
	return sc.nextInt();
}
public static void main(String[] args) {
	int choice;
	int bookId,memberId;
	float price;
	String name;
	int ownerChoice, ownerEdit;
	Owner owner = new Owner();
	try (Signindao dao = new Signindao(); LabDao dao1 = new LabDao()){
	while((choice = menulist()) != 0)
	{
		switch(choice)
		{
		case 1:
			
			while((ownerChoice = ownerMenuList()) != 0)
			{
				switch(ownerChoice)
				{
				case 0: 
				   break;
				case 1:
					Program.signIn(owner);
					if(dao.signin(owner)) {
				    while((ownerEdit = ownerEdit() ) != 0)
					{
						switch(ownerEdit) {
					
						case 1:
							Program.UpdateUser(owner);
						    dao.updateAccount(owner);
							break;
						case 2:
							Program.updatePassword(owner);
							dao.updatePassword(owner);
							break;
						case 3:
							 dao.bookCount();
							
							break;
						case 4:
							break;
						}
					}
					}
					break;
				case 2:
					Program.signup(owner);
				    dao.signup(owner);
					break;
				}
			}
			
			
			break;
		case 2:
			Program.signIn(owner);
			if(dao.signin(owner)) {
			while( ( choice = Program.menuList( ) ) != 0 )
			{
				switch( choice )
				{
				case 1:
					Program.UpdateUser(owner);
				    dao.updateAccount(owner);
					break;
				case 2:
					Program.updatePassword(owner);
					dao.updatePassword(owner);
					break;
				case 3:
					System.out.println("Enter the name of the book");
    				sc.nextLine();
    			    name = sc.nextLine();
    			    List<Member> mems1 = dao1.findBooks(name);
	                Program.dispRecord(mems1);
	                break;
				case 4:
					//check book availability
					
					break;
				case 5:
					Book book = new Book();
					Program.acceptRecord( book );
					dao1.insert( book );
					break;	
				case 6:
					//add new copy
					break;
				case 7:
					//issue book copy
					break;
				case 8:
					//return book copy
					break;
				case 9:
					// list issued books
					break;	
				case 10:
					System.out.print("Enter book id	:	");
					bookId = sc.nextInt();
					System.out.print("Enter price	:	");
					price = sc.nextFloat();
					dao1.update( bookId, price );
					break;
				case 11:
					//change rack
					break;
				case 12:
					//add member
					break;
				case 13:
					//take payment
					break;
				case 14:
					//payment history
					break;
				case 15:
					List<Book> books = dao1.getBooks();
					Program.printRecord( books );
					break;
					
			
				}
			}
			}
			
			break;
		case 3:
			break;
		}
	}
	}
	catch (Exception ex)
	{
		ex.printStackTrace();
	}
}










}


