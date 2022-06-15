package dev.array21.pdfgen.controller;

import dev.array21.pdfgen.document.DocumentGenerator;
import dev.array21.pdfgen.document.DocumentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
public class GenerateController {

    private final DocumentGenerator generator;

    @Autowired
    public GenerateController(DocumentGenerator generator) {
        this.generator = generator;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/generate", produces = "application/pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody DocumentSpecification specification) {

        byte[] pdf = generator.generate(specification);
        if (pdf != null) return ResponseEntity.ok(pdf);

        return ResponseEntity.notFound().build();
    }

}
