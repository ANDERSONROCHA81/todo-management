package net.javaguides.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "TodoDto Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private Long id;

    @Schema(description = "Todo Title")
    private String title;

    @Schema(description = "Todo Description")
    private String description;

    @Schema(description = "Shows if Todo is completed or not")
    private boolean completed;
}
