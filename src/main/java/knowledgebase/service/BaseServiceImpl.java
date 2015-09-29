package knowledgebase.service;

import knowledgebase.dao.CatalogDAO;
import knowledgebase.dao.UserDAO;
import knowledgebase.domain.Catalog;
import knowledgebase.domain.User;
import knowledgebase.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private CatalogDAO catalogDAO;

    @Autowired
    private UserDAO userDAO;


//    public void setCatalogDAO(CatalogDAO catalogDAO) {
//        this.catalogDAO = catalogDAO;
//    }

//    @Transactional
    @Override
    public void addCatalog(Catalog catalog) {
        catalogDAO.save(catalog);
    }

//    @Transactional
    @Override
    public List<Catalog> listCatalog() {
        return catalogDAO.list();
    }

    @Override
    public void renameCatalog(Integer id, String title) {
        if (title != "") {
            catalogDAO.renameCatalog(id, title);
        }
    }

    @Override
    public String getArticleUrlById(Integer id) {
        return catalogDAO.getUrlById(id);
    }

//    @Transactional
//    @Override
//    public void removeCatalog(Integer id) {
//        catalogDAO.removeCatalog(id);
//    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        return userDAO.getUserByLoginPassword(login, password);
    }

    @Override
    public TreeNode<Catalog> getCatalogTree() {
        List<Catalog> catalogList = listCatalog();
        Catalog rootCatalog = new Catalog();
        rootCatalog.setId(0);
        TreeNode<Catalog> tree = new TreeNode<Catalog>(rootCatalog);
        addCatalogToTree(catalogList, tree);
        return tree;
    }

    private void addCatalogToTree(List<Catalog> catalogList, TreeNode<Catalog> tree) {
        for (Catalog catalog : catalogList) {
            if (tree.getData().getId() == catalog.getParentId()) {
                addCatalogToTree(catalogList, tree.addChild(catalog));
            }
        }
    }


}
