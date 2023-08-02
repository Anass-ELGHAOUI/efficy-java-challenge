package edeal.recruitment;

import edeal.recruitment.exceptions.AccessDeniedException;
import org.json.JSONObject;

public class BasicBean {
    public void populateFromJson(JSONObject jsonO, boolean save) throws AccessDeniedException {
        throw new AccessDeniedException("test");
    }
}
