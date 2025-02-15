package com.foldright.auto.pipeline

import com.foldright.auto.pipeline.processor.AutoPipelineProcessor
import com.google.testing.compile.Compiler
import com.google.testing.compile.JavaFileObjects
import io.kotest.core.spec.style.AnnotationSpec

class AutoPipelineProcessorTest : AnnotationSpec() {

    @Test
    @Ignore
    fun test() {
        val configInterface = JavaFileObjects.forResource("test1/ConfigSource.java")

        val compilation = Compiler.javac()
            .withProcessors(AutoPipelineProcessor())
            .compile(configInterface)

        compilation.generatedSourceFiles().forEach { println(it.getCharContent(true)) }

    }
}
