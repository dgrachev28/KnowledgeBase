package knowledgebase.service;

import java.util.List;
import knowledgebase.domain.Catalog;
import knowledgebase.domain.User;
import knowledgebase.util.TreeNode;

public interface BaseService {

    public void addCatalog(Catalog catalog);

    public List<Catalog> listCatalog();

//    public void removeCatalog(Integer id);

    public void renameCatalog(Integer id, String title);

    public String getArticleUrlById(Integer id);

    public User getUserByLoginPassword(String login, String password);

    public TreeNode<Catalog> getCatalogTree();

}