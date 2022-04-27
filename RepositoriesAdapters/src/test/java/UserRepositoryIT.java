import adapter.repositories.data.users.AdminUserEnt;
import adapter.repositories.data.users.ClientUserEnt;
import adapter.repositories.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryIT {

    private final UserRepository rep = new UserRepository();

    @Test
    public void getUserTest(){
        assertEquals("user1", rep.getUser("user1").getLogin());
    }

    @Test
    public void getUsersTest(){
        assertEquals("user3", rep.getUsers().get(2).getLogin());
    }

    @Test
    public void getByPartLoginTest(){
        assertEquals(3, rep.getByPartLogin("user").size());
    }

    @Test
    public void changeActivityTest(){
        rep.changeActivity("user1");
        assertFalse(rep.getUser("user1").isActive());
    }

    @Test
    public void addAdminTest(){
        rep.addAdminUser(new AdminUserEnt("test1", "test1"));
        assertEquals("test1", rep.getUser("test1").getLogin());
    }

    @Test
    public void addDataUserTest(){
        rep.addAdminUser(new AdminUserEnt("test2", "test2"));
        assertEquals("test2", rep.getUser("test2").getLogin());
    }

    @Test
    public void addClientUserTest(){
        rep.addAdminUser(new AdminUserEnt("test3", "test3"));
        assertEquals("test3", rep.getUser("test3").getLogin());
    }

    @Test
    public void updateUserTest(){
        rep.updateUser(new ClientUserEnt("user1", "testNameChange"));
        assertEquals("testNameChange", rep.getUser("user1").getName());
    }
}
