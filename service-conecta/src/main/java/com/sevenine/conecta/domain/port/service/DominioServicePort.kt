package com.sevenine.conecta.domain.port.service

interface DominioServicePort<out O> {
    fun lista(): List<O>
}