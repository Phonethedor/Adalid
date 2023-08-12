package com.example.plantcertification

import com.adalid.plantapp.model.local.entities.PlantEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TestPlantEntity {

    private lateinit var plantEntity : PlantEntity

    @Before
    fun setup(){

        plantEntity = PlantEntity(
            id = 1,
            name = "unit test",
            type = "type",
            img = "Testing plant entity",
            desc = "test description"
        )
    }

    @After
    fun tearDown(){
    }

    @Test
    fun testPlant(){
        assert(plantEntity.id == 1)
        assert(plantEntity.name == "unit test")
        assert(plantEntity.type == "type")
        assert(plantEntity.img == "Testing plant entity")
        assert(plantEntity.desc == "test description")
    }
}