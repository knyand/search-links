package loc.zank;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface LinkService {
    List<Link> findAllLinks(String link) throws IOException;
}
