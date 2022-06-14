package dev.array21.pdfgen.endpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import dev.array21.pdfgen.RuntimeTypeAdapterFactory;
import dev.array21.pdfgen.generator.Generator;
import dev.array21.pdfgen.protocol.Element;
import dev.array21.pdfgen.protocol.GenerateRequest;
import dev.array21.pdfgen.protocol.elements.ParagraphElement;
import dev.array21.pdfgen.protocol.elements.table.TableElement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
public class Generate {

    @CrossOrigin(origins = {"*"})
    @RequestMapping(method = RequestMethod.GET, path = "/generate", produces = "application/pdf")
    public @ResponseBody ResponseEntity<byte[]> generate(@RequestBody String body) {
        RuntimeTypeAdapterFactory<Element> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(Element.class)
                .registerSubtype(ParagraphElement.class)
                .registerSubtype(TableElement.class);

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory)
                .create();

        GenerateRequest generateRequest;
        try {
            generateRequest = gson.fromJson(body, GenerateRequest.class);
        } catch (JsonSyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage().getBytes(StandardCharsets.UTF_8));
        }

        return new ResponseEntity<>(Generator.generate(generateRequest.documentSpecification), HttpStatus.OK);
    }

}
