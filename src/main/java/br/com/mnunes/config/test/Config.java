package br.com.mnunes.config.test;

import br.com.mnunes.exception.ConfigException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public interface Config<T extends Object> {

    T load(String path) throws ConfigException;
}
