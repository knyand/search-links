package loc.zank;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class LinkController implements Serializable {
    @Inject
    private LinkService linkService;
    private List<Link> links;
    private String address;

    public void analyzeLink() {
        try {
            links = linkService.findAllLinks(address);
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ошибка доступа!", "Страница не доступна.")
            );
            e.printStackTrace();
        }
    }

    public void clearLinks() {
        if (links != null) {
            links.clear();
        }
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
