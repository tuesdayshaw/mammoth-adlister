package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad findById (long id);

    List<Ad> findByUserId (long id);

    List<Ad> findBySearch (String searchString);

    void edit (Ad ad);

    void delete (Ad ad);


}
