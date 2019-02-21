/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.domain;

/**
 *
 * @author Zika
 */
public abstract class EntityImpl implements Entity {

    protected int id;

    public EntityImpl() {
    }

    public EntityImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {

        return id;
    }

    @Override
    public void setId(int id) {

        this.id = id;

    }
}
