package com.gestionventa.demo.models;

import org.springframework.http.HttpEntity;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel<T> {

        private T Object;
        private Boolean Succes;
        private List<String> Errors;

    public ResponseModel(T object) {
        Object = object;
        Succes = true;
        Errors = new ArrayList<>();
    }

    public ResponseModel() {
            Object = null;
            Succes = true;
            Errors = new ArrayList<>();
        }

        public Boolean getSucces() {
            return Succes;
        }

        public void setSucces(Boolean succes) {
            Succes = succes;
        }

        public List<String> getErrors() {
            return Errors;
        }

        public void setErrors(List<String> errors) {
            Errors = errors;
        }

    public T getObject() {
        return Object;
    }

    public void setObject(T object) {
        Object = object;
    }
}

