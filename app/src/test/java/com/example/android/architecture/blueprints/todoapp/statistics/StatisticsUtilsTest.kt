package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    
    @Test
    fun getActiveAndCompletedStats_oneNotCompletedTask_returnsHundredZero(){
        // when
        val tasks = listOf<Task>(
                Task("test", "test", false)
        )

        // given
        val result = getActiveAndCompletedStats(tasks)
        
        // then
        assertEquals(100f,result.activeTasksPercent)
        assertEquals(0f, result.completedTasksPercent)
    }
    
    @Test
    fun getActiveAndCompletedStats_oneCompletedTask_returnsZeroHundred(){
        val tasks = listOf<Task>(
                Task("test", "test", true)
        )
        
        val result = getActiveAndCompletedStats(tasks)
        
        assertEquals(0f,result.activeTasksPercent)
        assertEquals(100f,result.completedTasksPercent)
    }
    
    @Test
    fun getActiveAndCompletedStats_twoCompletedTask_threeActiveTask_returnsFortySixty(){
        val tasks = listOf<Task>(
                Task("test", "test", true),
                Task("test", "test", true),
                Task("test", "test", false),
                Task("test", "test", false),
                Task("test", "test", false)
        )
        
        val result = getActiveAndCompletedStats(tasks)
       
        assertEquals(60f,result1.activeTasksPercent)
        assertEquals(40f,result.completedTasksPercent)
    }
    
    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        val result = getActiveAndCompletedStats(emptyList())
        
        assertEquals(0f,result.activeTasksPercent)
        assertEquals(0f,result.completedTasksPercent)
    }
    
    @Test
    fun getActiveAndCompletedStats_null_returnsZeros(){
        val result = getActiveAndCompletedStats(null)
        
        assertEquals(0f,result.activeTasksPercent)
        assertEquals(0f,result.completedTasksPercent)
    }
}