package vastracart.category.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import vastracart.category.Response;

import javax.persistence.Column;

@Component
@Getter
@Setter
@ToString
public class CategoryResposne extends Response{

    private Category resposneBody;
}
