package danielszabo.jfaas;

import danielszabo.jfaas.entity.Function;
import org.springframework.stereotype.Component;

@Component
public class FunctionRunner {

	public String run(Function function) {
		return "The code for this function is : " + function.getCode();
	}

}
