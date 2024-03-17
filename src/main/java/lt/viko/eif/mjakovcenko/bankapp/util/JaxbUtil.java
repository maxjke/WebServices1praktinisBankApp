package lt.viko.eif.mjakovcenko.bankapp.util;

import lt.viko.eif.mjakovcenko.bankapp.model.Client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * JaxbUtil class represents methods to convert POJO classes to XML and XML to POJO.
 * @see HibernateUtil
 */
public final class JaxbUtil {
    /**
     * Converts a Java object to an XML file. This method takes any Java object annotated with JAXB annotations
     * and marshals it into an XML file named after the class of the object. Additionally, it prints the XML content
     * to the standard output.
     *
     * @param object The Java object to be converted to XML.
     * @param <T> The type of the object.
     * @throws JAXBException If an error occurs during the marshalling process.
     */
    public static <T> void convertToXML(T object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(object, new File(object.getClass().getSimpleName() + ".xml"));
        jaxbMarshaller.marshal(object, System.out);
    }

    /**
     * Transforms XML content into a Java object. This generic method takes the path to an XML file
     * and the class type of the expected object, unmarshalls the XML content, and returns an instance of
     * the specified object class.
     *
     * @param object The Java object that the XML will be converted to, used to determine the class for JAXB context.
     * @param xmlFilePath The path to the XML file that contains the data to be transformed into a Java object.
     * @param <T> The type of the object that is expected as a result.
     * @return The Java object created from the XML file content.
     * @throws JAXBException If an error occurs during the unmarshalling process.
     */
    public static <T> T transformToPojo(T object, String xmlFilePath) throws JAXBException {
        File file = new File(xmlFilePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        T object1 = (T) jaxbUnmarshaller.unmarshal(file);
        System.out.println(object1);
        return object1;
    }
}
