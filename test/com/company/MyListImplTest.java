package com.company;

import org.apache.log4j.Logger;
import org.junit.*;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class MyListImplTest {

    private static MyList<Integer> sut;  //la classe à tester
    private static int expectedSize;  // la taille à l'origine
    private static Properties prop;  // les propriétés
    private static List<Integer> testSet;  //les nombres que nous mettrons dans notre class
    private static FileInputStream propFile;  //le fichier de propriétés

    private static Logger logger = Logger.getLogger(MyListImplTest.class);

    private String myListIntegerToString(MyList<Integer> sut) {
        StringBuilder strbul  = new StringBuilder();
        strbul.append("[");
        for (int i = 0; i < sut.getSize(); i++) {
            strbul.append(sut.getAt(i));
            if (i < sut.getSize() - 1) {
                strbul.append(", ");
            }
        }
        strbul.append("]");
        return strbul.toString();
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        prop = new Properties();
        testSet = new LinkedList<>();
        propFile = new FileInputStream("testResources/config.properties"); //charge le fichier de propriétés
        prop.load(propFile);
        expectedSize = Integer.parseInt(prop.getProperty("taille")); //parse la taille
        logger.info("expectedSize: " + expectedSize);
        String numbers = prop.getProperty("nombre"); //récupère les nombre à mettre dans la liste
        for (String i : numbers.split(" ")) { //pour chaque nombre
            testSet.add(Integer.parseInt(i.trim()));  // l'enregistrer en tant que int
        }
        logger.info("testSet: " + testSet);
        sut = new MyListImpl<>();  // instancier la classe à tester
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        propFile.close();   // on ferme le fichier à la fin du test
    }

    @Before
    public void setUp() throws Exception {
        for (int i : testSet) {
            sut.add(new Integer(i));   //on ajoute les nombres au début de chaque test
        }
    }

    @After
    public void tearDown() throws Exception {
        sut.reset();  // à la fin de chaque test, on reset notre liste
    }

    @Test
    public void add() throws Exception {
        assertEquals(expectedSize, sut.getSize());
        Integer integerToAdd = 8;
        sut.add(integerToAdd);
        logger.info("sut: " + myListIntegerToString(sut));
        assertEquals(expectedSize+1, sut.getSize());
        assertEquals(sut.getAt(sut.getSize() - 1), integerToAdd);
        for(int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test
    public void removeAt() throws Exception {

    }

    @Test
    public void removeItem() throws Exception {

    }

    @Test
    public void setAt() throws Exception {

    }

}
