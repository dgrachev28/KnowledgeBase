package knowledgebase.dao;

import java.util.List;

import knowledgebase.domain.Catalog;

public interface CatalogDAO {

    public void save(Catalog catalog);

    public List<Catalog> list();

    public void renameCatalog(Integer id, String title);

    public String getUrlById(Integer id);
}