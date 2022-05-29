package com.interview.project.services;

import com.interview.project.jpa.model.Node;
import com.interview.project.rest.exceptions.IncorrectDataException;

import java.util.List;
import java.util.Map;

public class ControllerService {

    public static boolean validTypeItem(Node.Type type, Node<?> node) throws IncorrectDataException {
        switch (type) {
            case HASH:
                if (!(node.getValue() instanceof Map)) {
                    throw new IncorrectDataException("The value must match the MAP format");
                }
                break;
            case LIST:
                if (!(node.getValue() instanceof List)) {
                    throw new IncorrectDataException("The value must match the LIST format");
                }
                break;
            case STRING:
                if (!(node.getValue() instanceof String || node.getValue() instanceof Integer)) {
                    throw new IncorrectDataException("The value must match the STRING format");
                }
                break;
            default:
                break;

        }

        return true;
    }
}
