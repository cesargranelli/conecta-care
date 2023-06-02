package com.sevenine.conecta.mapper

interface EspecialidadeMapper<in T, out O> {
    fun convert(entry: T): O
}