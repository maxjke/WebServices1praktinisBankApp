package lt.viko.eif.mjakovcenko.bankapp.util;

import lt.viko.eif.mjakovcenko.bankapp.model.Client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public final class JaxbUtil {
    public static <T> void convertToXML(T object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(object, new File(object.getClass().getSimpleName() + ".xml"));
        jaxbMarshaller.marshal(object, System.out);
    }

    public static <T> T transformToPojo(T object, String xmlFilePath) throws JAXBException {
        File file = new File(xmlFilePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        T object1 = (T) jaxbUnmarshaller.unmarshal(file);
        System.out.println(object1);
        return object1;
    }
}
