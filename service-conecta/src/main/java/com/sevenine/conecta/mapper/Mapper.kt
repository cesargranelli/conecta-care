package com.sevenine.conecta.mapper

interface Mapper<in T, out O> {
    fun convert(entry: T): O
}