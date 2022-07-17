package pt.bmo.list4uee.repository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.weld.transaction.spi.TransactionServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pt.bmo.list4uee.model.Item;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArquillianExtension.class)
class ItemRepositoryTest {

    @Inject
    private ItemRepository repository;

    @Test
    void create() {
        assertNotNull(this.repository);
        assertEquals(0, repository.countAll());
    }

    @Test
    void findBookWithInvalidId() {
        assertThrows(Exception.class, () -> this.repository.find(null));
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ItemRepository.class)
                .addClass(Item.class)
                .addClass(TransactionServices.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("test-persistence.xml", "META-INF/persistence.xml");
    }
//    public static Archive<?> createDeployment() {
//        return ShrinkWrap.create(WebArchive.class, "list4u-ee.war")
//                .addPackage(ItemRepository.class.getPackage())
//                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
//                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
}