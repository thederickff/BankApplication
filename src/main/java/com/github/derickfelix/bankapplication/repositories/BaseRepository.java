/*
* The MIT License
*
* Copyright (c) 2019 Derick Felix
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
 */
package com.github.derickfelix.bankapplication.repositories;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T> the model the repository will represent
 * @param <ID> the type of the model identification
 */
public interface BaseRepository<T, ID> {
    /**
     * Retrieves all the entities of the database
     *
     * @return - A List of entites
     */
    List<T> findAll();

    /**
     * Gets an entity in the database by specifying an id
     *
     * @param id the id of the entity
     * @return an optional of the found entity
     */
    Optional<T> find(ID id);

    /**
     * Save a specific entity in the database
     *
     * @param model the entity to update
     */
    void save(T model);

    /**
     * Destroy a customer of the database
     *
     * @param id the id to be destroyed
     * @return an optional of the deleted entity
     */
    Optional<T> deleteById(ID id);
}
