package com.example.mutant

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class DnaRequest(val dna: Array<String>)

@RestController
class MutantController {

    private val detector = MutantDetector()

    @PostMapping("/mutant")
    fun isMutant(@RequestBody request: DnaRequest): ResponseEntity<String> {
        val isMutant = detector.isMutant(request.dna)
        return if (isMutant) {
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }
}
