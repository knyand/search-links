package loc.zank;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.ejb.Stateless;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LinkServiceImpl implements LinkService, Serializable {
    @Override
    public List<Link> findAllLinks(String url) throws IOException {
        List<Link> links = new ArrayList<>();
        Document document = Jsoup.connect(url).get();

        document.select("a[href]").forEach(
                link -> links.add(new Link(link.text(), link.attr("abs:href")))
        );

        return links;
    }
}
