package myapp.request;

import myapp.security.Sanitizer;
import myapp.security.SanitizerUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemRequest implements Sanitizer<ItemRequest> {
  private String id;
  private String name;

  @Override
  public ItemRequest sanitize(ItemRequest itemRequest) {
    ItemRequest sanitizer = new ItemRequest();
    sanitizer.id = SanitizerUtils.sanitizeString(itemRequest.id);
    sanitizer.name = SanitizerUtils.sanitizeString(itemRequest.name);
    return sanitizer;
  }
}
