package com.infosys.Wishlist_Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Wishlist
{
    @Id
    private String wishlistId;

    @NotBlank(message = "Username can't be blank!")
    private String userName;

    @NotBlank(message = "Description required!")
    private String shortDesc;

    @NotBlank(message = "category can't be blank!")
    private String category;

    @NotBlank(message = "Displayname can't be blank!")
    private String displayName;





}
