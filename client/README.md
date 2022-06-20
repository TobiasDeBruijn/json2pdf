# json2pdf-client
Rust Client library for the json2pdf server. Json2pdf is a server which takes a JSON description of a PDF, and converts it to a PDF document.

## Usage
```rust
use json2pdf_client::*;

/// Generate a PDF document containing a paragraph and an image
async fn generate_pdf() {
    let spec = DocumentSpecification::new()
        .add_element(Element::paragraph(Paragraph::new("Hello world!"))
            .border(BorderSettings::new()
                .bottom(BorderSpecification::new(4f32))))
        // Make sure you add the actual image bytes, rather than an empty Vec
        .add_element(Element::image(Image::new_bytes(&Vec::new(), 400f32, 400f32)));
    let data = pdf("http://localhost:8080", &spec).await.unwrap();
}
```

## License
json2pdf-client is licensed under the Apache-2.0 license, or the MIT license. At your discretion. Both licenses can be found at the root of this repository.