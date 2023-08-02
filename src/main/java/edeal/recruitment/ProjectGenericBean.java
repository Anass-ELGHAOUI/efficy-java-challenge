package edeal.recruitment;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import edeal.recruitment.exceptions.AccessDeniedException;
import edeal.recruitment.exceptions.IncorrectJsonException;
import java.time.Period;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ProjectGenericBean {
  public static <T extends BasicBean> BasicBean saveBean(
      HttpSession session, String json, Class<T> type, boolean save) throws Exception {
    if (isNotEmpty(json)) {
      JSONObject jsonO;
      try {
        jsonO = new JSONObject(json);
      } catch (JSONException var8) {
        throw new IncorrectJsonException("The json is not correct");
      }

      BasicBean bean = getBean(session, null, type);

      try {
        bean.populateFromJson(jsonO, save);
        return bean;
      } catch (AccessDeniedException var7) {
        throw new Exception(type.getSimpleName(), var7);
      }
    } else {
      throw new IncorrectJsonException("The json is not correct");
    }
  }

  public static <T extends BasicBean> BasicBean getBean(
      HttpSession session, String id, Class<T> type) throws Exception {
    boolean isNew = id == null || id.length() == 0;

    try {
      return isNew
          ? (BasicBean) type.getDeclaredConstructor(HttpSession.class).newInstance(session)
          : (BasicBean)
              type.getDeclaredConstructor(String.class, HttpSession.class).newInstance(id, session);

    } catch (Exception var6) {
      throw new Exception(type.getName(), var6);
    }
  }

  public abstract Period getDuration();

  public abstract String getDurationToString();

  public abstract String getDurationToString(String flag);
}
