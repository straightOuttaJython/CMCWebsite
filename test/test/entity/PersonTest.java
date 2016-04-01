package test.entity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cmc.entity.Person;
import cmc.entity.School;


public class PersonTest {
	
	private Person person, user, student;
	School school1 = new School("College University", "Texas", "Urban", "Private", 
			33, 15.5, 200.0, 200.0, 30000.52, 35.5, 
			6500, 58.6, 36.8, 
			5,5,5, new String[2]);
    private School[] savedSchool = {school1};
	
    
    @Before
	public void setUp() {
		// TODO Auto-generated constructor stub
        user = new Person();
        student = new Person("di", "tham", "bennhau", "trondoi", 'u', 'y',new School[0]);
		person = new Person("soai", "ca", "nanhnungboy", "dicuagai", 'u', 'y', savedSchool);
	}
	
    @Test
    public void testGetDefaultFirstName(){
        assertTrue("First name should be set to empty", user.getFirstName().equals(""));
    }
    
    @Test
    public void testGetDefaultLastName(){
        assertTrue("Last name should be set to empty", user.getLastName().equals(""));
    }
    
    @Test
    public void testGetDefaultUserName(){
        assertTrue("Username should be set to empty", user.getUsername().equals(""));
    }
    
    @Test
    public void testGetDefaultPassword(){
        assertTrue("Password should be set to empty", user.getPassword().equals(""));
    }
    
    @Test
    public void testGetDefaultType(){
        assertTrue("Type should be set to empty", user.getType()==' ');
    }
    
    @Test
    public void testGetDefaultStatus(){
        assertTrue("Status should be set to empty", user.getStatus()== ' ');
    }
    
    @Test
	public void testGetFirstName(){
		assertTrue("First name should be set to 'di'", student.getFirstName().equals("di"));
	}

    @Test
	public void testSetFirstName(){
		person.setFirstName("duong");
		assertTrue("Firstname should be 'duong' now ", person.getFirstName().equals("duong"));
	}

    @Test
	public void testGetLastName(){
		assertTrue("Last name should be set to 'tham'", student.getLastName().equals("tham"));
	}

    @Test
	public void testSetLastName(){
		person.setLastName("do");
		assertTrue("Firstname should be 'do' now ", person.getLastName().equals("do"));
	}

    @Test
	public void testGetUserName(){
		assertTrue("Username should be 'bennhau' now ", student.getUsername().equals("bennhau"));
	}

    @Test
	public void testSetUserName(){
		person.setUsername("manunited");
		assertTrue("Username should be 'manunited' now ", person.getUsername().equals("manunited"));
	}

    @Test
	public void testGetPassword(){
        assertTrue("Password should be set to 'trondoi'", student.getPassword().equals("trondoi"));
	}

    @Test
	public void testSetPassword(){
		person.setPassword("vodoi");
        assertTrue("Password should be 'vodoi' now ", person.getPassword().equals("vodoi"));
	}

    @Test
	public void testGetType(){
		assertTrue("Type should be 'u' now ",student.getType() == 'u');
	}

    @Test
	public void testSetType(){
		person.setType('a');
		assertTrue("Type should be 'a' now ", person.getType() == 'a');
	}

    @Test
	public void testGetStatus(){
        assertTrue("Status should be 'y' now ",student.getStatus() == 'y');
    }

    @Test
	public void testSetStatus(){
        person.setStatus('n');
        assertTrue("Status should be 'n' now ", person.getStatus() == 'n');
    }

    @Test
    public void testGetSavedSchool(){
        School[] school = person.getSavedSchools();
        assertTrue("School length should be 1", school.length == 1);
        assertTrue("School name should be 'College University'", school[0].getName().equals("College University"));
        assertTrue("School state should be 'Texas'", school[0].getState().equals("Texas"));
        assertTrue("School location should be 'Urban'", school[0].getLocation().equals("Urban"));
        assertTrue("The Control should be Private", school[0].getControl().equals("Private"));
    }

    @Test
    public void testSetSavedSchool(){
        person.setSavedSchools(new School[0]);
        School[] school = person.getSavedSchools();
        assertTrue("School length should be 0", school.length == 0);
    }

}
