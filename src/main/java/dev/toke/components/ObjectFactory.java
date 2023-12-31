//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.16 at 12:38:39 AM AEDT 
//


package dev.toke.components;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dev.toke.components package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dev.toke.components
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComponentRequest }
     * 
     */
    public ComponentRequest createComponentRequest() {
        return new ComponentRequest();
    }

    /**
     * Create an instance of {@link ComponentResponse }
     * 
     */
    public ComponentResponse createComponentResponse() {
        return new ComponentResponse();
    }

    /**
     * Create an instance of {@link ComponentDetails }
     * 
     */
    public ComponentDetails createComponentDetails() {
        return new ComponentDetails();
    }

    /**
     * Create an instance of {@link AllComponentsRequest }
     * 
     */
    public AllComponentsRequest createAllComponentsRequest() {
        return new AllComponentsRequest();
    }

    /**
     * Create an instance of {@link AllComponentsResponse }
     * 
     */
    public AllComponentsResponse createAllComponentsResponse() {
        return new AllComponentsResponse();
    }

    /**
     * Create an instance of {@link DeleteComponentRequest }
     * 
     */
    public DeleteComponentRequest createDeleteComponentRequest() {
        return new DeleteComponentRequest();
    }

    /**
     * Create an instance of {@link DeleteComponentResponse }
     * 
     */
    public DeleteComponentResponse createDeleteComponentResponse() {
        return new DeleteComponentResponse();
    }

}
