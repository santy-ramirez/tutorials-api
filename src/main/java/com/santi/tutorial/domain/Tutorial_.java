package com.santi.tutorial.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Tutorial.class)
public class Tutorial_ {
    public static volatile SingularAttribute<Tutorial,Long> id;
    public static volatile SingularAttribute<Tutorial,String> title;
    public static volatile SingularAttribute<Tutorial,String> description;
    public static volatile SingularAttribute<Tutorial,Boolean> published;

}
