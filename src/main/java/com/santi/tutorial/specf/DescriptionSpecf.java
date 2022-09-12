package com.santi.tutorial.specf;

import com.santi.tutorial.domain.Tutorial;
import com.santi.tutorial.domain.Tutorial_;
import lombok.var;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DescriptionSpecf implements Specification<Tutorial> {

    private String description;
    private String title;

    public DescriptionSpecf(String description, String title) {
        this.description = description;
        this.title = title;
    }

    @Override
    public Predicate toPredicate(Root<Tutorial> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(title==null && description==null){
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
        final var generalpredict =  criteriaBuilder.lower(root.get(Tutorial_.description));
        return criteriaBuilder.like(generalpredict,"%"+description.toLowerCase()+"%");
    }
}
