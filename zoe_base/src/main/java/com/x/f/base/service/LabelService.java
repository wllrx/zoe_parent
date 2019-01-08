package com.x.f.base.service;

import com.x.f.base.dao.LabelDao;
import com.x.f.base.entity.Label;
import com.x.f.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zoe
 * @date 2019-01-04
 */
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label){
        label.setId(idWorker.nextId()+"");//设置ID
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 条件查询 Specification匿名内部类
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {
            /**
             *
             * @param root  根对象(当前对象Label) ,也就是把条件封装到哪个对象中, where 类名 = label.getId
             * @param criteriaQuery   封装查询的关键字,例如 order by等
             * @param criteriaBuilder   封装条件对象,如果直接返回null,表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * new 一个list集合,存放所有的条件
                 */
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("labelname") != null && !"".equals(searchMap.get("labelname"))){
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class),"%"+searchMap.get("labelname")+"%"));
                }
                if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))){
                    predicateList.add(criteriaBuilder.equal(root.get("state").as(String.class),searchMap.get("state")));
                }
                if (searchMap.get("recommend") != null && !"".equals(searchMap.get("recommend"))){
                    predicateList.add(criteriaBuilder.like(root.get("recommend").as(String.class),"%"+searchMap.get("recommend")+"%"));
                }
                /**
                 * new  一个数组,作为最终返回值的条件    new Predicate[predicateList.size()]
                 *  toArray  转成数组
                 *
                 *  and  等于 labelname like "%小明%"  and  status = "1"
                 */
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
    public List<Label> findSearch(Map searchMap){
        Specification specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * 分页条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Label> pageQuery(Map searchMap, int page, int size){
        Specification specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return labelDao.findAll(specification,pageRequest);
    }
}


