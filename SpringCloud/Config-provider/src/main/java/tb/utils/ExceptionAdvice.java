package tb.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @author TB
 * @date 2019/3/9 - 16:50
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
    private static final Logger log = Logger.getLogger(String.valueOf(ExceptionAdvice.class));
}

