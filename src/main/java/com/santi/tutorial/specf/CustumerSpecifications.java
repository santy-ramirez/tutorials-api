package com.santi.tutorial.specf;


import com.santi.tutorial.domain.Tutorial;


import com.santi.tutorial.domain.Tutorial_;
import lombok.var;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustumerSpecifications implements Specification<Tutorial> {
        private final String title;

    public CustumerSpecifications(String title) {
        this.title = title;
    }

    @Override
    public Predicate toPredicate(Root<Tutorial> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(title==null){
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
       final var titleExpresion =  criteriaBuilder.lower(root.get(Tutorial_.title));
        return criteriaBuilder.like(titleExpresion,"%"+title.toLowerCase()+"%");
    }
}
