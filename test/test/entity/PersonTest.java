package test.entity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cmc.entity.Person;
import cmc.entity.School;


public class PersonTest {
	
	private Person person, user, student;
    private School[] savedSchool = {"SJU", "CSB"};
	
    @Before
	public PersonTest() {
		// TODO Auto-generated constructor stub
        user = new Person();
        student = new Person("di", "tham", "bennhau", "trondoi", 'u', 'y',new School[0]);
		person = new Person("soai", "ca", "nanhnungboy", "dicuagai", 'u', 'y', savedSchool);
	}
	
    @Test
    public void testGetDefaultFirstName(){
        assertTrue("First name should be set to empty", person.getFirstName().equals(""));
    }
    
    @Test
    public void testGetDefaultLastName(){
        assertTrue("Last name should be set to empty", person.getLastName().equals(""));
    }
    
    @Test
    public void testGetDefaultUserName(){
        assertTrue("Username should be set to empty", person.getUserName().equals(""));
    }
    
    @Test
    public void testGetDefaultPassword(){
        assertTrue("Password should be set to empty", person.getPassword().equals(""));
    }
    
    @Test
    public void testGetDefaultType(){
        assertTrue("Type should be set to empty", person.getFirstName()==' ');
    }
    
    @Test
    public void testGetDefaultStatus(){
        assertTrue("First name should be set to empty", person.getStatus()== ' ');
    }
    
    @Test
	public void testGetFirstName(){
		assertTrue("First name should be set to 'di'", student.getFirstName().equals("di"));
	}

    @Test
	public void testSetFirstName(){
		person.setFirstName("duong");
		assertTrue("Firstname should be 'duong' now ", person.getFirstName().equals("duong");
	}

    @Test
	public void testGetLastName(){
		assertTrue("Last name should be set to 'tham'", student.getLastName().equals("tham"));
	}

    @Test
	public void testSetLastName(){
		person.setLastName("do");
		assertTrue("Firstname should be 'do' now ", person.getLastName().equals("do");
	}

    @Test
	public void testGetUserName(){
		assertTrue("Username should be 'bennhau' now ", student.getUserName().equals("bennhau");
	}

    @Test
	public void testSetUserName(){
		person.setUserName("manunited");
		assertTrue("Username should be 'manunited' now ")person.getFirstName().equals("manunited");
	}

    @Test
	public void testGetPassword(){
        assertTrue("Password should be set to 'trondoi'", student.getPassword().equals("trondoi"));
	}

    @Test
	public void testSetPassword(){
		person.setPassword("vodoi");
        assertTrue("Password should be 'vodoi' now ", person.getPassword().equals("vodoi");
	}

    @Test
	public void testGetType(){
		assertTrue("Type should be 'u' now ",student.getType() == 'u');
	}

    @Test
	public void testSetType(){
		person.setType('a');
		assertTrue("Type should be 'a' now ", person.getType() == 'a';
	}

    @Test
	public void testGetStatus(){
        assertTrue("Status should be 'y' now ",student.getStatus() == 'u');
    }

    @Test
	public void testSetStatus(){
        person.setStatus('n');
        assertTrue("Status should be 'n' now ", person.getType() == 'n';
    }

    @Test
    public void testGetSavedSchool(){
        School[] school = student.getSavedSchool();
        assertTrue("School length should be 2", school.length == 2);
        assertTrue("First school should be 'SJU'", school[0].equals("SJU"));
        assertTrue("Second school should be 'CSB'", school[1].equals("CSB"));
    }

    @Test
    public void testSetSavedSchool(){
        person.setSavedSchool({"John", "Ben"});
        School[] school = person.getSavedSchool();
        assertTrue("School length should be 2", school.length == 2);
        assertTrue("First school should be 'John'", school[0].equals("John"));
        assertTrue("Second school should be 'Ben'", school[1].equals("Ben"));
    }

}
