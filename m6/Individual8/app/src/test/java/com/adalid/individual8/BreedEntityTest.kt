package com.adalid.individual8

import com.adalid.individual8.model.local.entities.BreedEntity
import org.junit.Before
import org.junit.Test

class BreedEntityTest {

    private lateinit var breedEntity: BreedEntity

    @Before
    fun setup(){
        breedEntity= BreedEntity(breed = "Chilean Quiltro")
    }

    @Test
    fun testBreed(){
        assert(breedEntity.breed=="Chilean Quiltro")
    }
}